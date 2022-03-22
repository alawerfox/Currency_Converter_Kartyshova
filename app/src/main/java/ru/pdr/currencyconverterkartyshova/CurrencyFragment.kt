package ru.pdr.currencyconverterkartyshova

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.pdr.currencyconverterkartyshova.databinding.CurrencySelectionBinding

class CurrencyFragment : Fragment(R.layout.currency_selection) {

    private var binding: CurrencySelectionBinding? = null

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


        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context,3)
        recyclerView.adapter = CurrencyAdapter(listOf(
            Currency("RU", 200.0),
            Currency("RU", 200.0),
            Currency("RU", 200.0),
            Currency("RU", 200.0),
            Currency("RU", 200.0),
            Currency("RU", 200.0),
            Currency("RU", 200.0),
            Currency("RU", 200.0),
            Currency("RU", 200.0),
            Currency("RU", 200.0),
            Currency("RU", 200.0),
            Currency("RU", 200.0),
        ))
    }
}