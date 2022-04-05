package ru.pdr.currencyconverterkartyshova

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class CurrencyViewModel(
    private val currenciesRepository: CurrenciesRepository
) : ViewModel() {
    private val _currency = MutableLiveData<List<Currency>>()
    val currency: LiveData<List<Currency>>
        get() = _currency

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
    get() = _error

    val progress = MutableLiveData<Boolean>()

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

    fun onDateChanged(date: Date) {
        progress.value = true
        viewModelScope.launch {
            val response = currenciesRepository.fetchCurrencies(dateFormat.format(date))
            when (response) {
                is CurrenciesResponse.Success -> {
                    _currency.value = response.data.currencies.map {
                        val value = it.value
                        Currency(value.name, value.code, value.rate)
                    }
                }
                is CurrenciesResponse.Failure -> {

                    _error.value = response.throwable.localizedMessage

                }
            }
        }
        progress.value = false

    }


}




