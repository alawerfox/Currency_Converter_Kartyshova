package ru.pdr.currencyconverterkartyshova

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Сurrency_transfer : Fragment() {

    companion object {
        fun newInstance() = Сurrency_transfer()
    }

    private lateinit var viewModel: CurrencyTransferViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.currency_transfer_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CurrencyTransferViewModel::class.java)
        // TODO: Use the ViewModel
    }

}