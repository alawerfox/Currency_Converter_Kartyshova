package ru.pdr.currencyconverterkartyshova

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CurrencyModel : ViewModel() {
    val currency by lazy { MutableLiveData<List<Currency>>() }

    init {
        currency.value = listOf(
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
