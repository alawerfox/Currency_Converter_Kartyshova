package ru.pdr.currencyconverterkartyshova

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

interface CurrenciesRepository {
    suspend fun fetchCurrencies(date: String): CurrenciesResponse
}

class CurrenciesRepositoryImpl (
    private val currencyApi: CurrencyApi
) : CurrenciesRepository {

    override suspend fun fetchCurrencies(date: String): CurrenciesResponse = withContext(Dispatchers.IO) {
        try {
            val data = currencyApi.getCurrencies(date)
            CurrenciesResponse.Success(data)
        } catch (e: Throwable) {
            CurrenciesResponse.Failure(e)
        }
    }
}