package net.rajpals.common.pickers;

import android.app.Activity;
import android.app.Dialog;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.widget.AppCompatImageView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;

import net.rajpals.common.R;
import net.rajpals.common.logger.AppLogger;

import io.reactivex.annotations.NonNull;

/**
 * Created by Macrew on 27-11-2018.
 */

public class CheckboxTickerHelper implements View.OnClickListener {

    private final Activity mActivity;
    private Dialog mDialog;
    private OnCheckBoxTickerListener mOnCheckBoxTickerListener;
    private CheckBox mCheckBoxAccept;
    private TextView mTxtAcceptTerms,mTxtAppName;
    private static final String TAG=CheckboxTickerHelper.class.getSimpleName();
    private AppCompatImageView mImgAppIcon;


    public CheckboxTickerHelper(Activity activity) {
        mActivity = activity;
    }


    public void showCheckboxTickerDialog(@NonNull OnCheckBoxTickerListener checkBoxTickerListener) {
        mOnCheckBoxTickerListener = checkBoxTickerListener;
        mDialog = new Dialog(mActivity);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.dialog_checkbox_ticker);
        Window window = mDialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER;
        window.setAttributes(wlp);
        mDialog.getWindow().setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        mDialog.setCancelable(false);
        mDialog.show();

        mTxtAcceptTerms=mDialog.findViewById(R.id.txtAcceptTermsConditions);
        String text = "<font color=#006d97>I agree to </font> <font color=#00D6D6><a href=\"micro://morebass.com\">Terms and Conditions</a></font>";
        mTxtAcceptTerms.setText(Html.fromHtml(text));
        //  mTxtAcceptTermsConditions.setLinksClickable(true);
        mTxtAcceptTerms.setMovementMethod(LinkMovementMethod.getInstance());

        mCheckBoxAccept=mDialog.findViewById(R.id.checkBoxAcceptTerms);
        mDialog.findViewById(R.id.txtProceed).setOnClickListener(this);
        mDialog.findViewById(R.id.txtCancel).setOnClickListener(this);
        mTxtAppName= mDialog.findViewById(R.id.txtAppName);
        mImgAppIcon=mDialog.findViewById(R.id.imgAppIcon);
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = mActivity.getPackageManager().getApplicationInfo(mActivity.getPackageName(), 0);
            mImgAppIcon.setImageResource(applicationInfo.icon);
            mTxtAppName.setText(mActivity.getResources().getString(R.string.app_name));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.txtProceed) {

            if(mCheckBoxAccept.isChecked()){
                mOnCheckBoxTickerListener.onCheckBoxTicked(true);
                mDialog.dismiss();
            }
            else
                AppLogger.showToast(TAG,mActivity.getResources().getString(R.string.pls_accept_terms_conditions));

        }else if (i == R.id.txtCancel) {
            mOnCheckBoxTickerListener.onCheckBoxTicked(false);

            mDialog.dismiss();
        }
        }



    public interface OnCheckBoxTickerListener {
        void onCheckBoxTicked(boolean isPositive);

    }

}
