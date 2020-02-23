<<<<<<< HEAD
package com.ezooma.caterer.controllers.ui.activities.homeScreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvNewOrdersAdapter;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvOrderItemsAdapter;

public class NewOrderDetailsActivity extends AppCompatActivity {
    RecyclerView mRvNewOrderItems;
    RvOrderItemsAdapter mRvOrderItemsAdapter;
    ImageView mImgToolbarBack ;
    AppCompatTextView mTxtToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
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
        mRvNewOrderItems.setLayoutManager(layoutManager);
        mRvNewOrderItems.setItemAnimator(new DefaultItemAnimator());
        mRvOrderItemsAdapter = new RvOrderItemsAdapter(this);
        mRvNewOrderItems.setAdapter(mRvOrderItemsAdapter);
    }

    private void initVariables() {
        mRvNewOrderItems = findViewById(R.id.rvNewOrderItems);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
        mTxtToolbarTitle = findViewById(R.id.txtToolbarTitle);

        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mTxtToolbarTitle.setText("New Order");
    }
}
=======
package com.ezooma.caterer.controllers.ui.activities.homeScreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvNewOrdersAdapter;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvOrderItemsAdapter;

public class NewOrderDetailsActivity extends AppCompatActivity {
    RecyclerView mRvNewOrderItems;
    RvOrderItemsAdapter mRvOrderItemsAdapter;
    ImageView mImgToolbarBack ;
    AppCompatTextView mTxtToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
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
        mRvNewOrderItems.setLayoutManager(layoutManager);
        mRvNewOrderItems.setItemAnimator(new DefaultItemAnimator());
        mRvOrderItemsAdapter = new RvOrderItemsAdapter(this);
        mRvNewOrderItems.setAdapter(mRvOrderItemsAdapter);
    }

    private void initVariables() {
        mRvNewOrderItems = findViewById(R.id.rvNewOrderItems);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
        mTxtToolbarTitle = findViewById(R.id.txtToolbarTitle);

        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mTxtToolbarTitle.setText("New Order");
    }
}
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
