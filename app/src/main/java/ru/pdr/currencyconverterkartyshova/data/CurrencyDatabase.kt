package ru.pdr.currencyconverterkartyshova.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import java.util.*

@Database(
    version = 1,
    entities = [CurrencyInfoEntity:: class]
   )
abstract class CurrencyDatabase: RoomDatabase() {
    abstract fun currencyDao():CurrencyDao

}