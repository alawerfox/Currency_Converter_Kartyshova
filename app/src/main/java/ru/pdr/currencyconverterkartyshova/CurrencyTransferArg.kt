package ru.pdr.currencyconverterkartyshova

import android.os.Parcelable
import androidx.navigation.NavArgs
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyTransferArg(
    val name: String,
    val code: String,
    val value: Double
) : NavArgs, Parcelable