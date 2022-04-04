package ru.pdr.currencyconverterkartyshova

import android.app.Application
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModule = module {
    viewModel { CurrencyModel() }
}
