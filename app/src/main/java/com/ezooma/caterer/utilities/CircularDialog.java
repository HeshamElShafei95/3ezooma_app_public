package com.ezooma.caterer.utilities;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import com.ezooma.caterer.R;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class CircularDialog {
    private Dialog dialog;
    private String progressMessage;

    public CircularDialog(Context context) {
        if (dialog == null)
            dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.progress_ring_dialog_view);
    }

    public void showCircularDialog() {
        if (dialog == null)
            return;
        dialog.show();


    }

    public void dismissCircularDialog() {
        if (dialog == null)
            return;
        if (dialog.isShowing())
            dialog.dismiss();
    }

}
