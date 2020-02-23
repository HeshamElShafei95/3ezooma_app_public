<<<<<<< HEAD
package com.ezooma.caterer.utilities.abstracts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.ezooma.caterer.R;
import com.ezooma.caterer.utilities.AppDialogs;
import com.ezooma.caterer.utilities.CircularDialog;
import com.ezooma.caterer.utilities.CommonProgressDialog;
import com.tapadoo.alerter.Alerter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity {
    Intent mIntent;
    public static final String TAG = BaseActivity.class.getName();
    CommonProgressDialog mCommonProgressDialog;
    CircularDialog mCircularDialog;
    AppDialogs mAppDialogs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppDialogs = new AppDialogs(this);
        mCommonProgressDialog = new CommonProgressDialog(this);
        mCircularDialog = new CircularDialog(this);
    }

    /*public void showSingleButtonDialog(String txtButtonName , String txtTitle ,String txt){
mAppDialogs.showInfoDialog();
    }*/

    public void showSuccessAlerter(String title, String message) {
        Alerter.create(this)
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
        Alerter.create(this)
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

    public void changeActivity(Activity source, Class<?> destination, boolean lFinish, Bundle bundle) {
        mIntent = new Intent(source, destination);
        if (bundle != null) {
            mIntent.putExtras(bundle);
        }
        startActivity(mIntent);
        if (lFinish) {
            finish();
        }
    }

    protected void setFragment(Fragment fragment, String tag, boolean addToStack) {
        if (fragment == null)
            return;
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frag_container, fragment, tag);
            if (addToStack)
                fragmentTransaction.addToBackStack(tag);
            fragmentTransaction.commit();
        } catch (IllegalStateException | NullPointerException ex) {
            ///AppLogger.Logger.error(TAG, ex.getMessage(), ex);
            Log.e(TAG, ex.getMessage());
        }
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

      public void showCircularDialog() {
          mCircularDialog.showCircularDialog();
      }

      public void hideCircularDialog() {
          mCircularDialog.dismissCircularDialog();
      }

      public void showCommonProgressDialog(String message) {
          mCommonProgressDialog.showProgressDialog(message);
      }

      public void hideCommonProgressDialog() {
          mCommonProgressDialog.dismissProgressDialog();
      }
    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void showDebugToast(String message) {
        /*      if (AppLogger.DEBUG)*/
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
=======
package com.ezooma.caterer.utilities.abstracts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.ezooma.caterer.R;
import com.ezooma.caterer.utilities.AppDialogs;
import com.tapadoo.alerter.Alerter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity {
    Intent mIntent;
    public static final String TAG = BaseActivity.class.getName();
    /*CommonProgressDialog mCommonProgressDialog;
    CircularDialog mCircularDialog;
*/
    AppDialogs mAppDialogs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppDialogs = new AppDialogs(this);
  /*      mCommonProgressDialog = new CommonProgressDialog(this);
        mCircularDialog = new CircularDialog(this);
  */
    }

    /*public void showSingleButtonDialog(String txtButtonName , String txtTitle ,String txt){
mAppDialogs.showInfoDialog();
    }*/

    public void showSuccessAlerter(String title, String message) {
        Alerter.create(this)
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
        Alerter.create(this)
                .setTitle(title)
                .setText(message)
                .setDuration(2000)
                .disableOutsideTouch()
                .setIcon(R.drawable.ic_logo_white)
                .setIconColorFilter(0)
                .enableSwipeToDismiss()
                .setContentGravity(Gravity.CENTER_VERTICAL)
                .setBackgroundColorInt(getResources().getColor(R.color.btn_red))
                .show();
    }

    public void changeActivity(Activity source, Class<?> destination, boolean lFinish, Bundle bundle) {
        mIntent = new Intent(source, destination);
        if (bundle != null) {
            mIntent.putExtras(bundle);
        }
        startActivity(mIntent);
        if (lFinish) {
            finish();
        }
    }

    protected void setFragment(Fragment fragment, String tag, boolean addToStack) {
        if (fragment == null)
            return;
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frag_container, fragment, tag);
            if (addToStack)
                fragmentTransaction.addToBackStack(tag);
            fragmentTransaction.commit();
        } catch (IllegalStateException | NullPointerException ex) {
            ///AppLogger.Logger.error(TAG, ex.getMessage(), ex);
            Log.e(TAG, ex.getMessage());
        }
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

    /*  public void showCircularDialog() {
          mCircularDialog.showCircularDialog();
      }

      public void hideCircularDialog() {
          mCircularDialog.dismissCircularDialog();
      }

      public void showCommonProgressDialog(String message) {
          mCommonProgressDialog.showProgressDialog(message);
      }

      public void hideCommonProgressDialog() {
          mCommonProgressDialog.dismissProgressDialog();
      }
  */
    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void showDebugToast(String message) {
        /*      if (AppLogger.DEBUG)*/
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
