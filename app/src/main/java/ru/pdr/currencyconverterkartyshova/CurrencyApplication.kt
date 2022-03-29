package ru.pdr.currencyconverterkartyshova

import android.app.Application
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class CurrencyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            module {
                viewModel { CurrencyModel() }
            }
        }
    }
}