<<<<<<< HEAD
package com.ezooma.caterer.controllers.ui.activities.loginSignupPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.ezooma.caterer.R;
import com.ezooma.caterer.utilities.abstracts.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                changeActivity(SplashActivity.this , ChooseLoginActivity.class,false,null);

            }
        }, 3000);
    }
}
=======
package com.ezooma.caterer.controllers.ui.activities.loginSignupPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.ezooma.caterer.R;
import com.ezooma.caterer.utilities.abstracts.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                changeActivity(SplashActivity.this , ChooseLoginActivity.class,false,null);

            }
        }, 3000);
    }
}
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
