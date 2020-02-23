<<<<<<< HEAD
package com.ezooma.caterer.controllers.ui.activities.loginSignupPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;

import com.ezooma.caterer.R;
import com.ezooma.caterer.utilities.Validations;
import com.ezooma.caterer.utilities.abstracts.BaseActivity;

public class ChangePasswordActivity extends BaseActivity {
    AppCompatTextView mTxtTitle;
    AppCompatImageView mImgBack;
    AppCompatEditText mEdtOldPassword, mEdtNewPassword, mEdtNewConfirmPassword;
    AppCompatButton mBtnChangePassword;
    Validations mValidations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initVariables();
        setViewsTexts();
        setViewsClicks();
    }

    private void setViewsTexts() {
        mTxtTitle.setText(getString(R.string.change_password));
    }

    private void setViewsClicks() {
        mBtnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = mValidations.changePasswordValidation(ChangePasswordActivity.this,
                        mEdtOldPassword.getText().toString().trim(),
                        mEdtNewPassword.getText().toString().trim(),
                        mEdtNewConfirmPassword.getText().toString().trim());
                if (result.equalsIgnoreCase("")) {

                } else {
                    showErrorAlerter("", result);
                }
            }
        });

        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initVariables() {
        mTxtTitle = findViewById(R.id.txtToolbarTitle);
        mImgBack = findViewById(R.id.imgToolbarBack);
        mEdtNewConfirmPassword = findViewById(R.id.edtNewConfirmPassword);
        mEdtOldPassword = findViewById(R.id.edtOldPassword);
        mEdtNewPassword = findViewById(R.id.edtNewPassword);
        mBtnChangePassword = findViewById(R.id.btnChangePassword);

    }
}
=======
package com.ezooma.caterer.controllers.ui.activities.loginSignupPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;

import com.ezooma.caterer.R;

public class ChangePasswordActivity extends AppCompatActivity {
    AppCompatTextView mTxtTitle;
    AppCompatImageView mImgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initVariables();
        setViewsTexts();
        setViewsClicks();
    }
    private void setViewsTexts() {
        mTxtTitle.setText(getString(R.string.change_password));
    }

    private void setViewsClicks() {
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initVariables() {
        mTxtTitle = findViewById(R.id.txtToolbarTitle);
        mImgBack = findViewById(R.id.imgToolbarBack);
    }
}
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
