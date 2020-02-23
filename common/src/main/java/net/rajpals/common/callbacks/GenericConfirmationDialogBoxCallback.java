package net.rajpals.common.callbacks;



import android.content.DialogInterface;

public interface GenericConfirmationDialogBoxCallback {

    void PositiveMethod(DialogInterface dialog, int id);

    void NegativeMethod(DialogInterface dialog, int id);
}