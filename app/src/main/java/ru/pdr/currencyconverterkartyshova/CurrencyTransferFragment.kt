package ru.pdr.currencyconverterkartyshova

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.pdr.currencyconverterkartyshova.databinding.CurrencyTransferFragmentBinding

class CurrencyTransferFragment : Fragment() {

    private val fragmentArgs by navArgs<CurrencyTransferFragmentArgs>()

    private val navController: NavController by lazy { findNavController() }

    private var binding: CurrencyTransferFragmentBinding? = null

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
        binding?.currencyName?.text = fragmentArgs.arg.name
        binding?.price?.text = getString(R.string.currency_value,fragmentArgs.arg.value)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

