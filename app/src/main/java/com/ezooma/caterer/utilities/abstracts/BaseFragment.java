package com.ezooma.caterer.utilities.abstracts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.ezooma.caterer.R;
import com.ezooma.caterer.utilities.CircularDialog;
import com.ezooma.caterer.utilities.CommonProgressDialog;
import com.tapadoo.alerter.Alerter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public abstract class BaseFragment extends Fragment {
    private Intent mIntent;
    public static final String TAG = BaseActivity.class.getName();
    private CircularDialog mCircularDialog;
    private CommonProgressDialog mCommonProgressDialog;

    public void changeActivity(Activity source, Class<?> destination, boolean lFinish, Bundle bundle) {
        mIntent = new Intent(source, destination);
        if (bundle != null) {
            mIntent.putExtras(bundle);
        }
        startActivity(mIntent);
        if (lFinish) {
            if (getActivity() == null)
                return;
            getActivity().finish();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() == null)
            return;
        mCommonProgressDialog = new CommonProgressDialog(getActivity());
        mCircularDialog = new CircularDialog(getActivity());
    }

    public void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && activity != null) {
            View f = activity.getCurrentFocus();
            if (f != null)
                inputMethodManager.hideSoftInputFromWindow(f.getWindowToken(), 0);
        }
    }

    protected void showSoftKeyboard(Activity activity, EditText editText) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    public void showCommonProgressDialog(String message) {
        mCommonProgressDialog.showProgressDialog(message);
    }

    public void hideCommonProgressDialog() {
        mCommonProgressDialog.dismissProgressDialog();
    }

    protected void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showDebugToast(String message) {
        /*        if (AppLogger.DEBUG)*/
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    public void showCircularDialog() {
        mCircularDialog.showCircularDialog();
    }

    public void hideCircularDialog() {
        mCircularDialog.dismissCircularDialog();
    }

    public void showSuccessAlerter(String title, String message) {
        if (getActivity() == null)
            return;
        Alerter.create(getActivity())
                .setTitle(title)
                .setText(message)
                .setDuration(2000)
                .disableOutsideTouch()
                .setIcon(R.drawable.ic_logo_white)
                .setIconColorFilter(0)
                .setBackgroundColorInt(getResources().getColor(R.color.green))
                .show();
    }

    public void showErrorAlerter(String title, String message) {
        if (getActivity() == null)
            return;
        Alerter.create(getActivity())
                .setTitle(title)
                .setText(message)
                .setDuration(2000)
                .disableOutsideTouch()
                .setIcon(R.drawable.ic_logo_white)
                .setIconColorFilter(0)
                .enableSwipeToDismiss()
                .setContentGravity(Gravity.CENTER_VERTICAL)
                .setBackgroundColorInt(getResources().getColor(R.color.error_red))
                .show();
    }
}
