package ru.pdr.currencyconverterkartyshova

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.pdr.currencyconverterkartyshova.databinding.ViewCurrencyItemBinding

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    private var items: List<Currency> = emptyList()

    var clickListener: OnCurrencyClickListener? = null

    class ViewHolder(private val binding: ViewCurrencyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currency: Currency) {
            binding.currencyItemName.text = currency.code
            binding.currencyItemValue.text = currency.value.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = ViewCurrencyItemBinding.inflate(inflator, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currency = items[position]
        holder.bind(currency)

        holder.itemView.setOnClickListener {
            clickListener?.onCurrencyClick(currency)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun update(items: List<Currency>) {
        this.items = items
        notifyDataSetChanged()
    }
}

interface OnCurrencyClickListener {
    fun onCurrencyClick(currency: Currency)
}

