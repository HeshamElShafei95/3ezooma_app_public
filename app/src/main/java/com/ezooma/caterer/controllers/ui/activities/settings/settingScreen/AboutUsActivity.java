package com.ezooma.caterer.controllers.ui.activities.settings.settingScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

import com.ezooma.caterer.R;

public class AboutUsActivity extends AppCompatActivity {
AppCompatTextView mTxtToolbarTitle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        mTxtToolbarTitle =findViewById(R.id.txtToolbarTitle);
        mTxtToolbarTitle.setText("About Us");
    }
}
