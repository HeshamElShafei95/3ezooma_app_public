package com.ezooma.caterer.controllers.ui.activities.settings.settingScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ezooma.caterer.R;
import com.ezooma.caterer.app.rest.ResponseCallBackHandler;
import com.ezooma.caterer.app.rest.ResponseHandler;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvNotificationsAdapter;
import com.ezooma.caterer.interfaces.HomeInterface;
import com.ezooma.caterer.interfacesImpl.HomeInterfacesImpl;
import com.ezooma.caterer.models.notificationModels.NotificationModel;
import com.ezooma.caterer.utilities.abstracts.BaseActivity;

import java.util.HashMap;
import java.util.Map;

public class NotificationActivity extends BaseActivity {
    RecyclerView mRvNotifications;
    AppCompatTextView mToolBarTitle;
    AppCompatImageView mImgBack;
    RvNotificationsAdapter mRvNotificationsAdapter;
    HomeInterface mHomeInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        initVariables();
        setUpRv();
        getNotificationsApi();
    }

    private void getNotificationsApi() {
        showCircularDialog();
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "2");
        mHomeInterface.notificationsApi(new ResponseCallBackHandler() {
            @Override
            public void returnResponse(ResponseHandler responseHandler) {
                hideCircularDialog();
                if (responseHandler.isExecuted()) {

                } else {
                    Toast.makeText(NotificationActivity.this, responseHandler.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, params);
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
        mHomeInterface = new HomeInterfacesImpl();
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
