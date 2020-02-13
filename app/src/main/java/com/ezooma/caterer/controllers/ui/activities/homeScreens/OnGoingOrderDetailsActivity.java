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

public class OnGoingOrderDetailsActivity extends AppCompatActivity {
    RecyclerView mRvOnGoingOrderItems;
    RvOrderItemsAdapter mRvOrderItemsAdapter;
    ImageView mImgToolbarBack ;
    AppCompatTextView mTxtToolbarTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_going_order_details);
        initVariables();
        setUpRv();
    }

    private void setUpRv() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRvOnGoingOrderItems.setLayoutManager(layoutManager);
        mRvOnGoingOrderItems.setItemAnimator(new DefaultItemAnimator());
        mRvOrderItemsAdapter = new RvOrderItemsAdapter(this);
        mRvOnGoingOrderItems.setAdapter(mRvOrderItemsAdapter);
    }

    private void initVariables() {
        mRvOnGoingOrderItems = findViewById(R.id.rvOnGoingOrderItems);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
        mTxtToolbarTitle = findViewById(R.id.txtToolbarTitle);

        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mTxtToolbarTitle.setText("Ongoing Order");
    }
}
