package ru.pdr.currencyconverterkartyshova

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*


class CurrenciesRepository(
    private val currencyApi: CurrencyApi
) {

    suspend fun fetchCurrencies(date: String): CurrenciesResponse = withContext(Dispatchers.IO) {
        try {


            currencyApi.getCurrencies(date)
        }
        catch (e: Throwable) {
            CurrenciesResponse(emptyMap())
        }
    }
}