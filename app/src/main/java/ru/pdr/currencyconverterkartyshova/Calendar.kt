package ru.pdr.currencyconverterkartyshova

import com.google.android.material.datepicker.MaterialDatePicker

class Calendar {
    val datePicker =
        MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .build()

}