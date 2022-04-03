package ru.pdr.currencyconverterkartyshova

import com.google.gson.annotations.SerializedName

sealed class CurrenciesResponse {
    data class Success(val data: CurrenciesResponse1) : CurrenciesResponse()
    data class Failure(val throwable: Throwable) : CurrenciesResponse()
}

data class CurrenciesResponse1(
    @SerializedName("Valute")
    val currencies: Map<String, CurrencyListInfo>
)

data class CurrencyListInfo(

    @SerializedName("ID")
    val id: String,

    @SerializedName("CharCode")
    val code: String,

    @SerializedName("Name")
    val name: String,

    @SerializedName("Value")
    val rate: Double

)


