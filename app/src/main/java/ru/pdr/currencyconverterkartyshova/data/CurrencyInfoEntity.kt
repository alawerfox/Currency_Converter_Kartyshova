package ru.pdr.currencyconverterkartyshova.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "currency_info")

data class CurrencyInfoEntity(
    @ColumnInfo(name = "info_id")
    val infoId: String,
    val code: String,
    val name: String,
    val value: String,
    val date: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)