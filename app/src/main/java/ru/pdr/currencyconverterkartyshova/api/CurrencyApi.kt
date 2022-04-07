package ru.pdr.currencyconverterkartyshova.api

import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyApi {

    @GET("{date}.js")
    suspend fun getCurrencies(@Path("date") date: String): CBRCurrenciesResponse

}