package com.ezooma.caterer.controllers.ui.activities.homeScreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

import com.ezooma.caterer.R;

public class AddItemsActivity extends AppCompatActivity {
    AppCompatTextView mTxtToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);
        initVariables();
    }

    private void initVariables() {
        mTxtToolbarTitle = findViewById(R.id.txtToolbarTitle);
        mTxtToolbarTitle.setText("Add new item");
    }
}
