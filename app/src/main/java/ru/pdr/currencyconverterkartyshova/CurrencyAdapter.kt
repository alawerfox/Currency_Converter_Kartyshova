package ru.pdr.currencyconverterkartyshova

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CurrencyAdapter(private val currencylist:List<Currency>) : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.currency_item_name)
        val value = itemView.findViewById<TextView>(R.id.currency_item_value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_currency_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currency = currencylist[position]
        holder.name.text = currency.name
        holder.value.text = currency.value.toString()
    }

    override fun getItemCount(): Int {
       return currencylist.size
    }
}

class Currency (val name: String, val value:Double)
