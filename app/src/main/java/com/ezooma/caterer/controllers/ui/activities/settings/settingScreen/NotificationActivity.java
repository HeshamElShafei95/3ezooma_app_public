package com.ezooma.caterer.controllers.ui.activities.settings.settingScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvNotificationsAdapter;

public class NotificationActivity extends AppCompatActivity {
    RecyclerView mRvNotifications;
    AppCompatTextView mToolBarTitle;
    AppCompatImageView mImgBack;
    RvNotificationsAdapter mRvNotificationsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
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
        mRvNotifications.setLayoutManager(layoutManager);
        mRvNotifications.setItemAnimator(new DefaultItemAnimator());
        mRvNotificationsAdapter = new RvNotificationsAdapter(this);
        mRvNotifications.setAdapter(mRvNotificationsAdapter);
    }

    private void initVariables() {
        mRvNotifications = findViewById(R.id.rvNotifications);
        mToolBarTitle = findViewById(R.id.txtToolbarTitle);
        mImgBack = findViewById(R.id.imgToolbarBack);
        mToolBarTitle.setText("Notifications");
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
