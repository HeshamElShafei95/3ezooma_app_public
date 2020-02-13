package com.ezooma.caterer.controllers.ui.activities.settings.settingScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.activities.loginSignupPackage.ChangePasswordActivity;
import com.ezooma.caterer.utilities.abstracts.BaseActivity;

public class SettingsActivity extends BaseActivity {
    AppCompatImageView mImgToolbarBack;
    AppCompatTextView mTxtToolbarTitle;
    RelativeLayout mRlChangePassword, mRlContactUs, mRlPrivacyPolicy, mRlTermsConditions, mRlABoutUs, mRlLogout, mRlBusinessSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initVariables();
        setClickListeners();
    }


    private void initVariables() {
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
        mTxtToolbarTitle = findViewById(R.id.txtToolbarTitle);
        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mTxtToolbarTitle.setText("Settings");
        mRlChangePassword = findViewById(R.id.rlChangePassword);
        mRlContactUs = findViewById(R.id.rlLocationSettings);
        mRlPrivacyPolicy = findViewById(R.id.rlPrivacyPolicy);
        mRlTermsConditions = findViewById(R.id.rlTermsAndConditions);
        mRlABoutUs = findViewById(R.id.rlAboutUs);
        mRlLogout = findViewById(R.id.rlLogout);
        mRlBusinessSettings = findViewById(R.id.rlBusinessSettings);
    }

    private void setClickListeners() {
        mRlChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(SettingsActivity.this, ChangePasswordActivity.class, false, null);
            }
        });
        mRlBusinessSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(SettingsActivity.this, BusinessSettingsActivity.class, false, null);
            }
        });
        mRlContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","support@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
        mRlPrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(SettingsActivity.this, PrivacyPolicyActivity.class, false, null);
            }
        });
        mRlABoutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(SettingsActivity.this, AboutUsActivity.class, false, null);
            }
        });
        mRlLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mRlTermsConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(SettingsActivity.this, TermsAndConditionsActivity.class, false, null);
            }
        });
    }
}
