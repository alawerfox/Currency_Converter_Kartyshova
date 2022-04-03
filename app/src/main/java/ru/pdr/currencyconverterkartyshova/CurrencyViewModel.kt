package ru.pdr.currencyconverterkartyshova

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class CurrencyViewModel(
   private val currenciesRepository: CurrenciesRepository
): ViewModel() {
    val _currency = MutableLiveData<List<Currency>>()
    val currency: LiveData <List<Currency>>
        get() = _currency

    val progress = MutableLiveData<Boolean>()

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

    fun onDateChanged(date: Date) {
        viewModelScope.launch {
            try {
                progress.value = true
                val response = currenciesRepository.fetchCurrencies(dateFormat.format(date))

                _currency.value = response.currencies.map {
                    val value = it.value
                    Currency(value.name, value.code, value.rate)
                }
            } finally {
                progress.value = false
            }
        }
    }
}
