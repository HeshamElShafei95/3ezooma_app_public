package com.ezooma.caterer.utilities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.ezooma.caterer.R;


/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class AppDialogs {
    public interface DialogInfo {
        void onPositiveButton(DialogInterface dialog, int which);

        void onNegativeButton(DialogInterface dialog, int which);

    }

    private AlertDialog alertDialog;
    private Context mContext;

    public AppDialogs(Context context) {
        this.mContext = context;
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setCanceledOnTouchOutside(false);

    }

    public AppDialogs setTitle(String title) {
        alertDialog.setTitle(title);
        return this;
    }

    public void showSimpleInfoDialog(String buttonName, String message) {
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, buttonName,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alertDialog.show();
    }


    public void showInfoDialog(String buttonName, String title, String message, final DialogInfo dialogInfo) {
        alertDialog.setMessage(message);
        alertDialog.setTitle(title);
        alertDialog.setCancelable(false);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, buttonName,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialogInfo.onPositiveButton(dialog, which);
                    }
                });


        alertDialog.show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(mContext.getResources().getColor(R.color.black));
    }


    public void showInfoDialogBothButtons(String buttonName, String title, String message, final DialogInfo dialogInfo, String buttonNameNegative) {
        alertDialog.setMessage(message);
        alertDialog.setTitle(title);
        alertDialog.setCancelable(true);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, buttonName,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialogInfo.onPositiveButton(dialog, which);
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, buttonNameNegative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInfo.onNegativeButton(dialogInterface, i);
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(mContext.getResources().getColor(R.color.black));
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(mContext.getResources().getColor(R.color.black));
    }


    public void showAlertDialogAndExitApp(String buttonName, String message, final DialogInfo dialogInfo) {
        alertDialog.setTitle(mContext.getString(R.string.alert));
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, buttonName,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialogInfo.onPositiveButton(dialog, which);
                    }
                });

        alertDialog.show();
    }


}

