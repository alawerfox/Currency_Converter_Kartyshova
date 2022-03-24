package ru.pdr.currencyconverterkartyshova;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CurrencyTransferFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CurrencyTransferFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private CurrencyTransferFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CurrencyTransferFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CurrencyTransferFragmentArgs __result = new CurrencyTransferFragmentArgs();
    bundle.setClassLoader(CurrencyTransferFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("arg")) {
      CurrencyTransferArg arg;
      if (Parcelable.class.isAssignableFrom(CurrencyTransferArg.class) || Serializable.class.isAssignableFrom(CurrencyTransferArg.class)) {
        arg = (CurrencyTransferArg) bundle.get("arg");
      } else {
        throw new UnsupportedOperationException(CurrencyTransferArg.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (arg == null) {
        throw new IllegalArgumentException("Argument \"arg\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("arg", arg);
    } else {
      throw new IllegalArgumentException("Required argument \"arg\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CurrencyTransferFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    CurrencyTransferFragmentArgs __result = new CurrencyTransferFragmentArgs();
    if (savedStateHandle.contains("arg")) {
      CurrencyTransferArg arg;
      arg = savedStateHandle.get("arg");
      if (arg == null) {
        throw new IllegalArgumentException("Argument \"arg\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("arg", arg);
    } else {
      throw new IllegalArgumentException("Required argument \"arg\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public CurrencyTransferArg getArg() {
    return (CurrencyTransferArg) arguments.get("arg");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("arg")) {
      CurrencyTransferArg arg = (CurrencyTransferArg) arguments.get("arg");
      if (Parcelable.class.isAssignableFrom(CurrencyTransferArg.class) || arg == null) {
        __result.set("arg", Parcelable.class.cast(arg));
      } else if (Serializable.class.isAssignableFrom(CurrencyTransferArg.class)) {
        __result.set("arg", Serializable.class.cast(arg));
      } else {
        throw new UnsupportedOperationException(CurrencyTransferArg.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    CurrencyTransferFragmentArgs that = (CurrencyTransferFragmentArgs) object;
    if (arguments.containsKey("arg") != that.arguments.containsKey("arg")) {
      return false;
    }
    if (getArg() != null ? !getArg().equals(that.getArg()) : that.getArg() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getArg() != null ? getArg().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CurrencyTransferFragmentArgs{"
        + "arg=" + getArg()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull CurrencyTransferFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull CurrencyTransferArg arg) {
      if (arg == null) {
        throw new IllegalArgumentException("Argument \"arg\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg", arg);
    }

    @NonNull
    public CurrencyTransferFragmentArgs build() {
      CurrencyTransferFragmentArgs result = new CurrencyTransferFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setArg(@NonNull CurrencyTransferArg arg) {
      if (arg == null) {
        throw new IllegalArgumentException("Argument \"arg\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg", arg);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public CurrencyTransferArg getArg() {
      return (CurrencyTransferArg) arguments.get("arg");
    }
  }
}
