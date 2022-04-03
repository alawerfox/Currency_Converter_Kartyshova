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
    val _currency = MutableLiveData<List<Currency>>()
    val currency: LiveData<List<Currency>>
        get() = _currency

    val progress = MutableLiveData<Boolean>()

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

    fun onDateChanged(date: Date) {
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
                    val _error = MutableLiveData<String>()
                    _error.value = response.throwable.localizedMessage
                    _error.observe()
                        fun toast()
                        Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
                    }
                    }


                    }


                    // Передать в неё response.throwable.localizedMessage (_error.value = response.throwable.localizedMessage)
                    // Подписаться на неё и показать toast
                    // https://developer.android.com/guide/topics/ui/notifiers/toasts

                }
            }



