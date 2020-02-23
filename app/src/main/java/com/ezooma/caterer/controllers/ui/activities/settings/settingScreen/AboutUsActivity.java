<<<<<<< HEAD
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
=======
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
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
