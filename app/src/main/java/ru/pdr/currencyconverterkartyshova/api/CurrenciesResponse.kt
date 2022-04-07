package ru.pdr.currencyconverterkartyshova.api

import com.google.gson.annotations.SerializedName
import ru.pdr.currencyconverterkartyshova.Currency

sealed class CurrenciesResponse {
    data class Success(val data: List<Currency>) : CurrenciesResponse()
    data class Failure(val throwable: Throwable) : CurrenciesResponse()
}

data class CBRCurrenciesResponse(
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


