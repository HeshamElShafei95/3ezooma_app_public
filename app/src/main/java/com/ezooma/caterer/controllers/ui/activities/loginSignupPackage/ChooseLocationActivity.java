package com.ezooma.caterer.controllers.ui.activities.loginSignupPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.activities.homeScreens.HomeScreenActivity;
import com.ezooma.caterer.utilities.abstracts.BaseActivity;

public class ChooseLocationActivity extends BaseActivity {

    AppCompatTextView mTxtTitle;
    RelativeLayout mRlUserLocation;
    AppCompatImageView mImgToolbarBack ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_location);
        initVariables();
        mTxtTitle.setText("Choose location");
    }

    private void initVariables() {
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
        mTxtTitle = findViewById(R.id.txtToolbarTitle);
        mRlUserLocation = findViewById(R.id.rlUserLocation);
        mRlUserLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(ChooseLocationActivity.this, HomeScreenActivity.class, false, null);
            }
        });
        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
