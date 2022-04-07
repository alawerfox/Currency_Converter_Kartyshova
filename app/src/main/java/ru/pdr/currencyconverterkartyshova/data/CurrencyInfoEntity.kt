package ru.pdr.currencyconverterkartyshova.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency_table")

data class CurrencyInfoEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val code: String,
    val name: String,
    val rate: Double,
    val date: String
)

