package ru.pdr.currencyconverterkartyshova

import android.app.Application
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

private val koinModule = module {
    viewModel { CurrencyViewModel(get()) }
    single {
        RetrofitClient
            .getClient()
            .create(CurrencyApi::class.java)
    }
    single { CurrenciesRepository(get()) }
}

class CurrencyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(koinModule)
        }
    }
}