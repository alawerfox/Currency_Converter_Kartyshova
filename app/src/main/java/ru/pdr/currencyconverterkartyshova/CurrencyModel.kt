package ru.pdr.currencyconverterkartyshova

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CurrencyModel : ViewModel() {
    val _currency = MutableLiveData<List<Currency>>()
    val currency: LiveData <List<Currency>>
    get() = _currency


    init {
        _currency.value = listOf(
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
        )
    }
}
