package ru.pdr.currencyconverterkartyshova

import android.app.Application
import org.koin.core.context.startKoin

class CurrencyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(koinModule)
        }
    }
}