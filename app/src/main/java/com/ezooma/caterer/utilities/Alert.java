package com.ezooma.caterer.utilities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.widget.Button;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class Alert {

    private Context mContext;
    private AlertDialog.Builder alertBuilder;
    private OnAlertClick mOnAlertClick;

    public Alert(Context context, String message) {
        this.mContext = context;
        prepareAlertDialog(message);
    }

    public Alert(Context context, String message, String okBtnText, String cancelBtnText, OnAlertClick onAlertClick) {
        this.mContext = context;
        this.mOnAlertClick = onAlertClick;
        prepareAlertDialogWithCancel(message, okBtnText, cancelBtnText);
    }

    private void prepareAlertDialog(String message) {
        alertBuilder = new AlertDialog.Builder(mContext);
        alertBuilder.setTitle("Wine Diary");
        alertBuilder.setMessage(message);

        alertBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }


    private void prepareAlertDialogWithCancel(String message, String okBtnText, String cancelBtnText) {
        alertBuilder = new AlertDialog.Builder(mContext);
        alertBuilder.setTitle("Wine Diary");
        alertBuilder.setMessage(message);
        alertBuilder.setPositiveButton(okBtnText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //dialogInterface.dismiss();
                mOnAlertClick.onOk();
            }
        });
        alertBuilder.setNegativeButton(cancelBtnText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mOnAlertClick.onCancel();
            }
        });
    }

    public void show() {
        AlertDialog alert11 = alertBuilder.create();
        alert11.show();
        Button buttonbackground1 = alert11.getButton(DialogInterface.BUTTON_POSITIVE);
        buttonbackground1.setTextColor(Color.BLACK);

    }

    public interface OnAlertClick {
        void onOk();

        void onCancel();
    }
}

