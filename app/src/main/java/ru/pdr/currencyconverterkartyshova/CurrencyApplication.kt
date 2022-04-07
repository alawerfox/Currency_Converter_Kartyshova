package ru.pdr.currencyconverterkartyshova

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.pdr.currencyconverterkartyshova.koin.koinModule

class CurrencyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CurrencyApplication)
            modules(koinModule)
        }
    }
}