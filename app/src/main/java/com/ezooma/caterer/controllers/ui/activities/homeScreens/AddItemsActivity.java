<<<<<<< HEAD
package com.ezooma.caterer.controllers.ui.activities.homeScreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.ezooma.caterer.R;

public class AddItemsActivity extends AppCompatActivity {
    AppCompatTextView mTxtToolbarTitle;
    AppCompatEditText mEdtItemName, mEdtItemPrice, mEdtItemDescription;
    CardView mCvSaveItem;
    AppCompatImageView mImgItemImage, mCameraImage;
    AppCompatSpinner mSpinnerSubCategories;
    RelativeLayout mRlImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);
        initVariables();
    }

    private void initVariables() {
        mTxtToolbarTitle = findViewById(R.id.txtToolbarTitle);
        mTxtToolbarTitle.setText("Add new item");
        mEdtItemName = findViewById(R.id.edtItemName);
        mEdtItemPrice = findViewById(R.id.edtItemPrice);
        mEdtItemDescription = findViewById(R.id.edtItemDescription);
        mCvSaveItem = findViewById(R.id.cvSaveItem);
        mImgItemImage = findViewById(R.id.imgItemImage);
        mCameraImage = findViewById(R.id.imgCamera);
        mRlImageView =findViewById(R.id.rlItemImage);
        mSpinnerSubCategories = findViewById(R.id.spinnerSubCategories);
        mRlImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
=======
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
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
