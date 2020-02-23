package net.rajpals.common.utilities;

import android.content.Context;
import android.os.Build;

import java.util.Locale;

;


/**
 * The type CommonUtilities.
 */
public abstract class ConflictUtilities {

    public static Locale getLocals(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            return context.getResources().getConfiguration().getLocales().get(0);
        else
            return  context.getResources().getConfiguration().locale;
    }

    //Is greater than lollipop
    public static boolean isGreaterThanMarshMallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }
}
