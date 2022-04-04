package ru.pdr.currencyconverterkartyshova

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CurrencyTransferViewModel : ViewModel() {
    private val _RUB = MutableLiveData<Double>()
    val RUB: LiveData<Double>
    get() = _RUB

    private val _currency = MutableLiveData<Double>()
    val currency: LiveData<Double>
        get() = _currency

    private var amount: Double = 0.0

    fun setAmount(amount: Double){
        this.amount = amount
    }

    fun exchangeToRub(value:Double) {
        _RUB.value=value*amount
    }

    fun exchangeToCurrency(value: Double) {
        if (value ==0.0){
            _currency.value=0.0
        } else {
            _currency.value=value/amount
        }
    }

}