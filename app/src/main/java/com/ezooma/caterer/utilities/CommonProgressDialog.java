package com.ezooma.caterer.utilities;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class CommonProgressDialog {
    private ProgressDialog progressDialog;
    private String progressMessage;

    public CommonProgressDialog(Context context) {
        if (progressDialog == null)
            this.progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
    }

    public void showProgressDialog(String message) {
        if (progressDialog == null)
            return;
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public void dismissProgressDialog() {
        if (progressDialog == null)
            return;
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

}
