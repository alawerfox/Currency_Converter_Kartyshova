package ru.pdr.currencyconverterkartyshova.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.pdr.currencyconverterkartyshova.Currency
import ru.pdr.currencyconverterkartyshova.data.CurrencyDao
import ru.pdr.currencyconverterkartyshova.data.CurrencyInfoEntity
import java.text.SimpleDateFormat
import java.util.*

interface CurrenciesRepository {
    suspend fun fetchCurrencies(date: String): CurrenciesResponse
}

class CurrenciesRepositoryImpl(
    private val currencyApi: CurrencyApi,
    private val currencyDao: CurrencyDao,
    private val dateFormat: SimpleDateFormat
) : CurrenciesRepository {

    override suspend fun fetchCurrencies(date: String): CurrenciesResponse =
        withContext(Dispatchers.IO) {
            try {
                val dataFromDB = currencyDao.getCurrencyList(date)
                if (dataFromDB.isNotEmpty()) {
                    val response = dataFromDB.map { Currency(it.name, it.code, it.rate) }
                    return@withContext CurrenciesResponse.Success(response)
                }
                val dateNow = dateFormat.format(Date())
                val dataFromServer = currencyApi.getCurrencies(date)
                currencyDao.insert(dataFromServer.currencies.map {
                    val value = it.value
                    CurrencyInfoEntity(0, value.code, value.name, value.rate, dateNow)
                })
                val response = dataFromServer.currencies.map {
                    val value = it.value
                    Currency(value.name, value.code, value.rate)
                }
                CurrenciesResponse.Success(response)
            } catch (e: Throwable) {
                CurrenciesResponse.Failure(e)
            }
        }
}