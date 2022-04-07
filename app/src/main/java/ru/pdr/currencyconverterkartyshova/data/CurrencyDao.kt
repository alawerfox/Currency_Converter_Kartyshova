package ru.pdr.currencyconverterkartyshova.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CurrencyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(currency: List<CurrencyInfoEntity>)

    @Query("SELECT * FROM currency_table WHERE date = :date")
    fun getCurrencyList(date: String): List<CurrencyInfoEntity>
}