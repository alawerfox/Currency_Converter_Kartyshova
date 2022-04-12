package ru.pdr.currencyconverterkartyshova.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import ru.pdr.currencyconverterkartyshova.Currency
import ru.pdr.currencyconverterkartyshova.data.CurrencyDao
import ru.pdr.currencyconverterkartyshova.data.CurrencyInfoEntity
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

interface CurrenciesRepository {
    suspend fun fetchCurrencies(date: String): CurrenciesResponse
}

class CurrenciesRepositoryImpl(
    private val remoteCurrenciesRepository: RemoteCurrenciesRepository,
    private val localCurrenciesRepository: LocalCurrenciesRepository
) : CurrenciesRepository {

    override suspend fun fetchCurrencies(date: String): CurrenciesResponse{
        return when (val localResponse = localCurrenciesRepository.getCurrencies(date)) {
            is CurrenciesResponse.Success -> localResponse
            is CurrenciesResponse.Failure -> remoteCurrenciesRepository.getCurrencies(date).also {
                if (it is CurrenciesResponse.Success) {
                    localCurrenciesRepository.insertCurrencies(it.data, date)
                }
            }
        }
    }

}

interface RemoteCurrenciesRepository {
    suspend fun getCurrencies(date: String): CurrenciesResponse
}

class RemoteCurrenciesRepositoryImpl (
    private val currencyApi: CurrencyApi
): RemoteCurrenciesRepository {
    override suspend fun getCurrencies(date: String): CurrenciesResponse {
        return withContext(Dispatchers.IO) {
            try {
                val dataFromServer = currencyApi.getCurrencies(date)
                val response = dataFromServer.currencies.map {
                    val value = it.value
                    Currency(value.name, value.code, value.rate)
                }
                CurrenciesResponse.Success(response)
            }catch (e: Throwable) {
                CurrenciesResponse.Failure(e)
            }
        }
    }
}

interface LocalCurrenciesRepository : RemoteCurrenciesRepository {
    suspend fun insertCurrencies(currencies: List<Currency>, date: String)
}

class LocalCurrenciesRepositoryImpl(
    private val currencyDao: CurrencyDao
): LocalCurrenciesRepository {
    override suspend fun insertCurrencies(currencies: List<Currency>,date: String) {
        withContext(Dispatchers.IO) {
            currencyDao.insert(currencies.map {
                CurrencyInfoEntity(0, it.code, it.name, it.value, date)
            })
        }
    }
    override suspend fun getCurrencies(date: String): CurrenciesResponse {
        return withContext(Dispatchers.IO) {
            val dataFromDB = currencyDao.getCurrencyList(date)
            if (dataFromDB.isNotEmpty()) {
                val response = dataFromDB.map { Currency(it.name, it.code, it.rate) }
                CurrenciesResponse.Success(response)
            }
            CurrenciesResponse.Failure(Exception("error"))
        }
    }
}