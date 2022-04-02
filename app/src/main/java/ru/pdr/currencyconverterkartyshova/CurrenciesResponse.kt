package ru.pdr.currencyconverterkartyshova

import com.google.gson.annotations.SerializedName

data class CurrenciesResponse(
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


