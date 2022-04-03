package ru.pdr.currencyconverterkartyshova

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CurrencyTransferViewModel : ViewModel() {
    private val _RUB= MutableLiveData<Double>

    val RUB =

    private var amount: Double = 0.0

    fun setAmount(amount: Double){
        this.amount = amount
    }

    fun exchangeToRub(RUB:Double) {
        value
    }
}