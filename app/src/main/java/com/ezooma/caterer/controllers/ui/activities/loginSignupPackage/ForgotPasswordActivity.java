package com.ezooma.caterer.controllers.ui.activities.loginSignupPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.ezooma.caterer.R;
import com.ezooma.caterer.app.rest.ResponseCallBackHandler;
import com.ezooma.caterer.app.rest.ResponseHandler;
import com.ezooma.caterer.interfaces.LoginRegisterInterface;
import com.ezooma.caterer.interfacesImpl.LoginRegisterInterfaceImpl;
import com.ezooma.caterer.utilities.Validations;
import com.ezooma.caterer.utilities.abstracts.BaseActivity;

import java.util.HashMap;
import java.util.Map;

public class ForgotPasswordActivity extends BaseActivity {
    AppCompatTextView mTxtFpTitle;
    AppCompatImageView mImgToolbarBack;
    AppCompatButton mBtnForgotPass;
    Validations mValidations;
    AppCompatEditText mEdtForgotEmail;
    Context mContext;
    String strEmail = "";
    LoginRegisterInterface mLoginRegisterInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        initVariables();
        setViewsTexts();
        setViewsClicks();
    }

    private void setViewsTexts() {
        mTxtFpTitle.setText(getString(R.string.forgot_password));
    }

    private void setViewsClicks() {
        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBtnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEmail = mEdtForgotEmail.getText().toString().trim();
                String result = mValidations.forgotPasswordValidation(mContext, mEdtForgotEmail.getText().toString().trim());
                if (result.equalsIgnoreCase("")) {
                    forgotPasswordApi();
                } else {
                    showErrorAlerter("", result);
                }
            }
        });
    }

    private void forgotPasswordApi() {
        showCircularDialog();
        Map<String, Object> lMap = new HashMap<>();
        lMap.put("email", strEmail);
        mLoginRegisterInterface.forgotPasswordApi(new ResponseCallBackHandler() {
            @Override
            public void returnResponse(ResponseHandler responseHandler) {
                hideCircularDialog();
            }
        }, lMap);


    }

    private void initVariables() {
        mLoginRegisterInterface = new LoginRegisterInterfaceImpl();
        mTxtFpTitle = findViewById(R.id.txtToolbarTitle);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
        mBtnForgotPass = findViewById(R.id.btnForgotPass);
        mEdtForgotEmail = findViewById(R.id.edtForgotEmail);
        mValidations = new Validations();
        mContext = ForgotPasswordActivity.this;

    }
}
