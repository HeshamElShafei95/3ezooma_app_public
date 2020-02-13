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
