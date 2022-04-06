package ru.pdr.currencyconverterkartyshova

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CurrencyTransferViewModel : ViewModel() {
    private val _rub = MutableLiveData<Double>()
    val rub: LiveData<Double>
        get() = _rub

    private val _currency = MutableLiveData<Double>()
    val currency: LiveData<Double>
        get() = _currency

    private var amount: Double = 0.0

    fun setAmount(amount: Double) {
        this.amount = amount
    }

    fun exchangeToRub(value: Double) {
        _rub.value = value * amount
    }

    fun exchangeToCurrency(value: Double) {
        _currency.value = if(value == 0.0) 0.0 else value/amount
    }

}