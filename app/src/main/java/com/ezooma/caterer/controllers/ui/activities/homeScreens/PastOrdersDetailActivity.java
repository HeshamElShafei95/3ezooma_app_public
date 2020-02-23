<<<<<<< HEAD
package com.ezooma.caterer.controllers.ui.activities.homeScreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvOrderItemsAdapter;

public class PastOrdersDetailActivity extends AppCompatActivity {
    RecyclerView mRvPastOrderItems;
    RvOrderItemsAdapter mRvOrderItemsAdapter;
    ImageView mImgToolbarBack;
    AppCompatTextView mTxtToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_orders_detail);
        initVariables();
        setUpRv();
    }

    private void setUpRv() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRvPastOrderItems.setLayoutManager(layoutManager);
        mRvPastOrderItems.setItemAnimator(new DefaultItemAnimator());
        mRvOrderItemsAdapter = new RvOrderItemsAdapter(this);
        mRvPastOrderItems.setAdapter(mRvOrderItemsAdapter);

    }

    private void initVariables() {
        mRvPastOrderItems = findViewById(R.id.rvPastOrderItems);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
        mTxtToolbarTitle = findViewById(R.id.txtToolbarTitle);

        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mTxtToolbarTitle.setText("Completed Order");
    }
}
=======
package com.ezooma.caterer.controllers.ui.activities.homeScreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvOrderItemsAdapter;

public class PastOrdersDetailActivity extends AppCompatActivity {
    RecyclerView mRvPastOrderItems;
    RvOrderItemsAdapter mRvOrderItemsAdapter;
    ImageView mImgToolbarBack;
    AppCompatTextView mTxtToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_orders_detail);
        initVariables();
        setUpRv();
    }

    private void setUpRv() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRvPastOrderItems.setLayoutManager(layoutManager);
        mRvPastOrderItems.setItemAnimator(new DefaultItemAnimator());
        mRvOrderItemsAdapter = new RvOrderItemsAdapter(this);
        mRvPastOrderItems.setAdapter(mRvOrderItemsAdapter);

    }

    private void initVariables() {
        mRvPastOrderItems = findViewById(R.id.rvPastOrderItems);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
        mTxtToolbarTitle = findViewById(R.id.txtToolbarTitle);

        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mTxtToolbarTitle.setText("Completed Order");
    }
}
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
