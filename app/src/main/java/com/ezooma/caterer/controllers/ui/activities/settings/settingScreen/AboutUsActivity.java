package com.ezooma.caterer.controllers.ui.activities.settings.settingScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

import com.ezooma.caterer.R;
import com.ezooma.caterer.utilities.abstracts.BaseActivity;

public class AboutUsActivity extends BaseActivity {
    AppCompatTextView mTxtToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        mTxtToolbarTitle = findViewById(R.id.txtToolbarTitle);
        mTxtToolbarTitle.setText("About Us");

        callAboutUsApi();
    }

    private void callAboutUsApi() {

    }
}
