package ru.pdr.currencyconverterkartyshova

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModule = module {
    viewModel { CurrencyViewModel(get()) }
    single {
        RetrofitClient
            .getClient()
            .create(CurrencyApi::class.java)
    }
    single<CurrenciesRepository> { CurrenciesRepositoryImpl(get()) }
}