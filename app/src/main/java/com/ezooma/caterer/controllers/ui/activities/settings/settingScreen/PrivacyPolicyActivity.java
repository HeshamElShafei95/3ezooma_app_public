<<<<<<< HEAD
package com.ezooma.caterer.controllers.ui.activities.settings.settingScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

import com.ezooma.caterer.R;

public class PrivacyPolicyActivity extends AppCompatActivity {
AppCompatTextView mTxtToolbarTitle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        mTxtToolbarTitle = findViewById(R.id.txtToolbarTitle);
        mTxtToolbarTitle.setText("Privacy policy");
    }
}
=======
package com.ezooma.caterer.controllers.ui.activities.settings.settingScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

import com.ezooma.caterer.R;

public class PrivacyPolicyActivity extends AppCompatActivity {
AppCompatTextView mTxtToolbarTitle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        mTxtToolbarTitle = findViewById(R.id.txtToolbarTitle);
        mTxtToolbarTitle.setText("Privacy policy");
    }
}
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
