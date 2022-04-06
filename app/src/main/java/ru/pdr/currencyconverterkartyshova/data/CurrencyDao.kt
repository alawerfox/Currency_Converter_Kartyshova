package ru.pdr.currencyconverterkartyshova.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.pdr.currencyconverterkartyshova.CurrencyListInfo
import java.util.*

@Dao
interface CurrencyDao {

    @Insert
    suspend fun addCurrency (currency: Currency)

    @Query("SELECT * FROM currency_info")
    fun readAllData():LiveData<List<Currency>>


}