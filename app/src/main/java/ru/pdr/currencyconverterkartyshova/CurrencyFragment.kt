package ru.pdr.currencyconverterkartyshova

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.datepicker.MaterialDatePicker
import ru.pdr.currencyconverterkartyshova.databinding.CurrencySelectionBinding
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
class CurrencyFragment : Fragment(R.layout.currency_selection) {

    private var binding: CurrencySelectionBinding? = null

    private val navController: NavController by lazy { findNavController() }

    private val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)?.also {
            binding = CurrencySelectionBinding.bind(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.datePickerActions?.setOnClickListener {
            val dialog = MaterialDatePicker.Builder.datePicker()
                .build()

            dialog.addOnPositiveButtonClickListener {
                val date = Date(it)
                binding?.datePickerActions?.setText(simpleDateFormat.format(date))
            }

            dialog.show(parentFragmentManager, "")
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        val items = listOf(
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
            Currency("Российский рубль","RU", 200.0),
        )

        val currencyAdapter = CurrencyAdapter(items)
        currencyAdapter.clickListener = object : OnCurrencyClickListener {
            override fun onCurrencyClick(currency: Currency) {
                val arg = CurrencyTransferArg(currency.name, currency.code, currency.value)
                navController.navigate(CurrencyFragmentDirections.actionCurrencyFragmentToCurrencyTransfer(arg))
            }
        }

        recyclerView.adapter = currencyAdapter
    }
    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}