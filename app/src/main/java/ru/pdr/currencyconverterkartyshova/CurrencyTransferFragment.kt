package ru.pdr.currencyconverterkartyshova

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.pdr.currencyconverterkartyshova.databinding.CurrencyTransferFragmentBinding
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class CurrencyTransferFragment : Fragment() {

    private val fragmentArgs by navArgs<CurrencyTransferFragmentArgs>()

    private val navController: NavController by lazy { findNavController() }

    private var binding: CurrencyTransferFragmentBinding? = null

    private val viewModel: CurrencyTransferViewModel by viewModel()

    private val currencyFormat = DecimalFormat("#.00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.RUB.observe(this) {
            binding?.editTextRub?.setText(currencyFormat.format(it))
        }
        viewModel.currency.observe(this) {
            binding?.editTextValue?.setText(currencyFormat.format(it))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.currency_transfer_fragment, container, false)?.also {
            binding = CurrencyTransferFragmentBinding.bind(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.toolbar?.setNavigationOnClickListener {
            navController.popBackStack()
        }

        binding?.toolbar?.title = fragmentArgs.arg.code
        binding?.editTextLayoutValue?.hint = fragmentArgs.arg.code
        binding?.currencyName?.text = fragmentArgs.arg.name
        binding?.price?.text = getString(R.string.currency_value, fragmentArgs.arg.value)
        binding?.editTextValue?.setOnEditorActionListener { textView, i, keyEvent ->
            if (i == EditorInfo.IME_ACTION_DONE) {
                val value = textView.text.toString().toDoubleOrNull()
                    ?: return@setOnEditorActionListener false
                viewModel.exchangeToRub(value)
            }
            true
        }
        binding?.editTextRub?.setOnEditorActionListener { textView, i, keyEvent ->
            if (i == EditorInfo.IME_ACTION_DONE) {
                val value = textView.text.toString().toDoubleOrNull()
                    ?: return@setOnEditorActionListener false
                viewModel.exchangeToCurrency(value)
            }
            true
        }

        viewModel.setAmount(fragmentArgs.arg.value)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

