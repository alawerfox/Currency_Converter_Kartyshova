package ru.pdr.currencyconverterkartyshova.koin

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.pdr.currencyconverterkartyshova.CurrencyTransferViewModel
import ru.pdr.currencyconverterkartyshova.CurrencyViewModel
import ru.pdr.currencyconverterkartyshova.api.CurrenciesRepository
import ru.pdr.currencyconverterkartyshova.api.CurrenciesRepositoryImpl
import ru.pdr.currencyconverterkartyshova.api.CurrencyApi
import ru.pdr.currencyconverterkartyshova.api.RetrofitClient
import ru.pdr.currencyconverterkartyshova.data.CurrencyDatabase
import java.text.SimpleDateFormat
import java.util.*

val koinModule = module {
    viewModel { CurrencyViewModel(get(), get()) }
    viewModel { CurrencyTransferViewModel() }
    single {
        RetrofitClient
            .getClient()
            .create(CurrencyApi::class.java)
    }

    single<CurrenciesRepository> { CurrenciesRepositoryImpl(get(), get(), get()) }

    single {
        Room.databaseBuilder(androidContext(), CurrencyDatabase::class.java, "internship_db")
            .build()
    }

    single { get<CurrencyDatabase>().currencyDao()}

    single { SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)}
}