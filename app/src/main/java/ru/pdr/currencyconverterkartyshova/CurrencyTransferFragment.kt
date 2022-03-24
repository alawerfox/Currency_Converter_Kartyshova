package ru.pdr.currencyconverterkartyshova

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import kotlinx.parcelize.Parcelize

class CurrencyTransferFragment : Fragment() {

    private val arg by navArgs<CurrencyTransferArg>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.currency_transfer_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}

@Parcelize
data class CurrencyTransferArg(
    val name: String,
    val code: String,
    val value: Double
) : NavArgs, Parcelable
