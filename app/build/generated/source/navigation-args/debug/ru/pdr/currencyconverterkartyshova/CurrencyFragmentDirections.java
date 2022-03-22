package ru.pdr.currencyconverterkartyshova;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class CurrencyFragmentDirections {
  private CurrencyFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionCurrencyFragmentToCurrencyTransfer() {
    return new ActionOnlyNavDirections(R.id.action_currencyFragment_to_currency_transfer);
  }
}
