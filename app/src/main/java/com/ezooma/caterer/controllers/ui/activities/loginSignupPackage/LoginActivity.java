<<<<<<< HEAD
package com.ezooma.caterer.controllers.ui.activities.loginSignupPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.ezooma.caterer.R;
import com.ezooma.caterer.app.rest.ResponseCallBackHandler;
import com.ezooma.caterer.app.rest.ResponseHandler;
import com.ezooma.caterer.interfaces.LoginRegisterInterface;
import com.ezooma.caterer.interfacesImpl.LoginRegisterInterfaceImpl;
import com.ezooma.caterer.utilities.AppConstants;
import com.ezooma.caterer.utilities.GlobalBundleKeys;
import com.ezooma.caterer.utilities.Validations;
import com.ezooma.caterer.utilities.abstracts.BaseActivity;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity {
    AppCompatTextView mTxtSignUp, mTxtTitle, mTxtForgotPassword;
    CardView mCvFacebook, mCvLogin;
    AppCompatEditText mEdtEmail, mEdtPassword;
    AppCompatImageView mImgToolbarBack;
    String mRoute;
    Bundle mBundle;
    Validations mValidations;
    Context mContext;
    String strEmail = "", strPassword = "";
    LoginRegisterInterface mLoginRegisterInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mBundle = getIntent().getExtras();
        if (mBundle == null)
            return;
        mRoute = (String) mBundle.getSerializable(GlobalBundleKeys.BK_LOGIN_ROUTE);
        initVariables();
        setViewsTexts();
        setViewsClicks();
    }

    private void setViewsTexts() {
        mTxtTitle.setText(getString(R.string.login));
    }

    private void setViewsClicks() {
        mTxtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRoute.equalsIgnoreCase(AppConstants.CHOOSE_OPTIONS)) {
                    mBundle = new Bundle();
                    mBundle.putSerializable(GlobalBundleKeys.BK_LOGIN_ROUTE, AppConstants.CHOOSE_OPTIONS);
                    changeActivity(LoginActivity.this, RegisterActivity.class, false, mBundle);
                } else
                    finish();
            }
        });
        mTxtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(LoginActivity.this, ForgotPasswordActivity.class, false, null);
            }
        });
        mCvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEmail = mEdtEmail.getText().toString().trim();
                strPassword = mEdtPassword.getText().toString().trim();
                String result = mValidations.loginValidation(mContext, mEdtEmail.getText().toString().trim(), mEdtPassword.getText().toString().trim());
                if (result.equalsIgnoreCase("")) {
                    callLoginAPi();
                    //   changeActivity(LoginActivity.this, ChooseLocationActivity.class, false, null);
                } else {
                    showErrorAlerter("", result);
                }
            }
        });

        mCvFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void callLoginAPi() {

        showCircularDialog();
        Map<String, Object> lMap = new HashMap<>();
        lMap.put("email", strEmail);
        lMap.put("password", strPassword);
        /*lMap.put("deviceType", "A");
        lMap.put("deviceToken", "abc");
        lMap.put("userType", "C");
        lMap.put("loginType", "G");*/
        mLoginRegisterInterface.loginApi(new ResponseCallBackHandler() {
            @Override
            public void returnResponse(ResponseHandler responseHandler) {
                hideCircularDialog();
            }
        }, lMap);
    }

    private void initVariables() {
        mContext = LoginActivity.this;
        mLoginRegisterInterface = new LoginRegisterInterfaceImpl();
        mValidations = new Validations();
        mTxtSignUp = findViewById(R.id.txtSignUp);
        mTxtTitle = findViewById(R.id.txtToolbarTitle);
        mTxtForgotPassword = findViewById(R.id.txtForgetPassword);
        mCvFacebook = findViewById(R.id.btnFacebookLogin);
        mCvLogin = findViewById(R.id.cvLogin);
        mEdtEmail = findViewById(R.id.edtEmail);
        mEdtPassword = findViewById(R.id.edtPassword);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
    }
}
=======
package com.ezooma.caterer.controllers.ui.activities.loginSignupPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;

import com.ezooma.caterer.R;
import com.ezooma.caterer.utilities.AppConstants;
import com.ezooma.caterer.utilities.GlobalBundleKeys;
import com.ezooma.caterer.utilities.abstracts.BaseActivity;

public class LoginActivity extends BaseActivity {
    AppCompatTextView mTxtSignUp, mTxtTitle, mTxtForgotPassword;
    CardView mCvFacebook, mCvLogin;
    AppCompatEditText mEdtEmail, mEdtPassword;
    AppCompatImageView mImgToolbarBack;
    String mRoute;
    Bundle mBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mBundle = getIntent().getExtras();
        if (mBundle == null)
            return;
        mRoute = (String) mBundle.getSerializable(GlobalBundleKeys.BK_LOGIN_ROUTE);
        initVariables();
        setViewsTexts();
        setViewsClicks();
    }
    private void setViewsTexts() {
        mTxtTitle.setText(getString(R.string.login));
    }

    private void setViewsClicks() {
        mTxtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRoute.equalsIgnoreCase(AppConstants.CHOOSE_OPTIONS)) {
                    mBundle = new Bundle();
                    mBundle.putSerializable(GlobalBundleKeys.BK_LOGIN_ROUTE,AppConstants.CHOOSE_OPTIONS);
                    changeActivity(LoginActivity.this, RegisterActivity.class, false, mBundle);
                }
                else
                    finish();
            }
        });
        mTxtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(LoginActivity.this, ForgotPasswordActivity.class, false, null);
            }
        });
        mCvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                changeActivity(LoginActivity.this, ChooseLocationActivity.class, false, null);

            }
        });

        mCvFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initVariables() {
        mTxtSignUp = findViewById(R.id.txtSignUp);
        mTxtTitle = findViewById(R.id.txtToolbarTitle);
        mTxtForgotPassword = findViewById(R.id.txtForgetPassword);
        mCvFacebook = findViewById(R.id.btnFacebookLogin);
        mCvLogin = findViewById(R.id.cvLogin);
        mEdtEmail = findViewById(R.id.edtEmail);
        mEdtPassword = findViewById(R.id.edtPassword);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
    }
}
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
