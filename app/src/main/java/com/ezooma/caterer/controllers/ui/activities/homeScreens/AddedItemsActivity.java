<<<<<<< HEAD
package com.ezooma.caterer.controllers.ui.activities.homeScreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvAddedItemsAdapter;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvOrderItemsAdapter;

public class AddedItemsActivity extends AppCompatActivity {
    AppCompatTextView mTxtTitle;
    RecyclerView mRvAddedItems;
    RvAddedItemsAdapter mRvAddedItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_items);
        initVariables();
        setUpRv();
    }

    private void setUpRv() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
        mRvAddedItems.setLayoutManager(layoutManager);
        mRvAddedItems.setItemAnimator(new DefaultItemAnimator());
        mRvAddedItemsAdapter = new RvAddedItemsAdapter(this);
        mRvAddedItems.setAdapter(mRvAddedItemsAdapter);
    }

    private void initVariables() {
        mTxtTitle = findViewById(R.id.txtToolbarTitle);
        mRvAddedItems = findViewById(R.id.rvAddedItems);
        mTxtTitle.setText("Breads");
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

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvAddedItemsAdapter;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvOrderItemsAdapter;

public class AddedItemsActivity extends AppCompatActivity {
    AppCompatTextView mTxtTitle;
    RecyclerView mRvAddedItems;
    RvAddedItemsAdapter mRvAddedItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_items);
        initVariables();
        setUpRv();
    }

    private void setUpRv() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
        mRvAddedItems.setLayoutManager(layoutManager);
        mRvAddedItems.setItemAnimator(new DefaultItemAnimator());
        mRvAddedItemsAdapter = new RvAddedItemsAdapter(this);
        mRvAddedItems.setAdapter(mRvAddedItemsAdapter);
    }

    private void initVariables() {
        mTxtTitle = findViewById(R.id.txtToolbarTitle);
        mRvAddedItems = findViewById(R.id.rvAddedItems);
        mTxtTitle.setText("Breads");
    }
}
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
