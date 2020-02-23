<<<<<<< HEAD
package com.ezooma.caterer.controllers.ui.activities.settings.settingScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

import com.ezooma.caterer.R;

public class TermsAndConditionsActivity extends AppCompatActivity {
AppCompatTextView mTxtToolbarTitle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);
        mTxtToolbarTitle =findViewById(R.id.txtToolbarTitle);
        mTxtToolbarTitle.setText("Terms and conditions");
    }
}
=======
package com.ezooma.caterer.controllers.ui.activities.settings.settingScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

import com.ezooma.caterer.R;

public class TermsAndConditionsActivity extends AppCompatActivity {
AppCompatTextView mTxtToolbarTitle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);
        mTxtToolbarTitle =findViewById(R.id.txtToolbarTitle);
        mTxtToolbarTitle.setText("Terms and conditions");
    }
}
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
