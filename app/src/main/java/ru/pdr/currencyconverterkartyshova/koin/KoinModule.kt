package ru.pdr.currencyconverterkartyshova.koin

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.pdr.currencyconverterkartyshova.CurrencyTransferViewModel
import ru.pdr.currencyconverterkartyshova.CurrencyViewModel
import ru.pdr.currencyconverterkartyshova.api.*
import ru.pdr.currencyconverterkartyshova.data.CurrencyDatabase
import java.text.SimpleDateFormat
import java.util.*

val koinModule = module {
    viewModel { CurrencyViewModel(get()) }
    viewModel { CurrencyTransferViewModel() }
    single {
        RetrofitClient
            .getClient()
            .create(CurrencyApi::class.java)
    }

    single<CurrenciesRepository> { CurrenciesRepositoryImpl(get(), get()) }
    single<LocalCurrenciesRepository> {LocalCurrenciesRepositoryImpl(get()) }
    single<RemoteCurrenciesRepository> {RemoteCurrenciesRepositoryImpl(get()) }

    single {
        Room.databaseBuilder(androidContext(), CurrencyDatabase::class.java, "internship_db")
            .build()
    }

    single { get<CurrencyDatabase>().currencyDao()}

}