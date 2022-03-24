package ru.pdr.currencyconverterkartyshova;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CurrencyFragmentDirections {
  private CurrencyFragmentDirections() {
  }

  @NonNull
  public static ActionCurrencyFragmentToCurrencyTransfer actionCurrencyFragmentToCurrencyTransfer(
      @NonNull CurrencyTransferArg arg) {
    return new ActionCurrencyFragmentToCurrencyTransfer(arg);
  }

  public static class ActionCurrencyFragmentToCurrencyTransfer implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionCurrencyFragmentToCurrencyTransfer(@NonNull CurrencyTransferArg arg) {
      if (arg == null) {
        throw new IllegalArgumentException("Argument \"arg\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg", arg);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionCurrencyFragmentToCurrencyTransfer setArg(@NonNull CurrencyTransferArg arg) {
      if (arg == null) {
        throw new IllegalArgumentException("Argument \"arg\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg", arg);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("arg")) {
        CurrencyTransferArg arg = (CurrencyTransferArg) arguments.get("arg");
        if (Parcelable.class.isAssignableFrom(CurrencyTransferArg.class) || arg == null) {
          __result.putParcelable("arg", Parcelable.class.cast(arg));
        } else if (Serializable.class.isAssignableFrom(CurrencyTransferArg.class)) {
          __result.putSerializable("arg", Serializable.class.cast(arg));
        } else {
          throw new UnsupportedOperationException(CurrencyTransferArg.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_currencyFragment_to_currency_transfer;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public CurrencyTransferArg getArg() {
      return (CurrencyTransferArg) arguments.get("arg");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionCurrencyFragmentToCurrencyTransfer that = (ActionCurrencyFragmentToCurrencyTransfer) object;
      if (arguments.containsKey("arg") != that.arguments.containsKey("arg")) {
        return false;
      }
      if (getArg() != null ? !getArg().equals(that.getArg()) : that.getArg() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getArg() != null ? getArg().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionCurrencyFragmentToCurrencyTransfer(actionId=" + getActionId() + "){"
          + "arg=" + getArg()
          + "}";
    }
  }
}
