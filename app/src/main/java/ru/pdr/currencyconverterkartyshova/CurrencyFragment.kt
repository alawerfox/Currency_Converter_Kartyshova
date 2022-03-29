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
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.pdr.currencyconverterkartyshova.databinding.CurrencySelectionBinding
import java.text.SimpleDateFormat
import java.util.*

class CurrencyFragment : Fragment(R.layout.currency_selection) {

    private var binding: CurrencySelectionBinding? = null

    private val currencyAdapter by lazy { CurrencyAdapter() }

    private val navController: NavController by lazy { findNavController() }

    private val viewModel: CurrencyModel by viewModel()

    private val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.currency.observe(this) {
            currencyAdapter.update(it)
        }
    }

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

            dialog.show(parentFragmentManager, "Recyclerview")
        }

        currencyAdapter.clickListener = object : OnCurrencyClickListener {
            override fun onCurrencyClick(currency: Currency) {
                val arg = CurrencyTransferArg(currency.name, currency.code, currency.value)
                navController.navigate(CurrencyFragmentDirections.actionCurrencyFragmentToCurrencyTransfer(arg))
            }
        }

        binding?.recyclerView?.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = currencyAdapter
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}