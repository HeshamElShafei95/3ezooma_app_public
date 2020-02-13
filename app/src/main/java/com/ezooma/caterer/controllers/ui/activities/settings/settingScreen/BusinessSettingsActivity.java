package com.ezooma.caterer.controllers.ui.activities.settings.settingScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvDaysAdapter;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvRegisterServicesAdapter;
import com.ezooma.caterer.models.ServicesModel;

import java.util.ArrayList;

public class BusinessSettingsActivity extends AppCompatActivity {
    AppCompatTextView mTxtToolbarTitle;
    RecyclerView mRvServices, mRvDays;
    RvRegisterServicesAdapter mRvRegisterServicesAdapter;
    RvDaysAdapter mRvDaysAdapter ;
    ArrayList<ServicesModel> mList = new ArrayList<>();
    ArrayList<String> mDaysList = new ArrayList<>();
    CardView mCvSaveSettings ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_settings);

        initVariables();
        setViewsTexts();
        setUpRv();
        setUpDaysRv();
    }
    private void setUpDaysRv() {
        mDaysList.add("Monday");
        mDaysList.add("Tuesday");
        mDaysList.add("Wednesday");
        mDaysList.add("Thursday");
        mDaysList.add("Friday");
        mDaysList.add("Saturday");
        mDaysList.add("Sunday");

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRvDays.setLayoutManager(layoutManager);
        mRvDays.setItemAnimator(new DefaultItemAnimator());
        mRvDaysAdapter = new RvDaysAdapter(this, mDaysList);
        mRvDays.setAdapter(mRvDaysAdapter);
    }

    private void setUpRv() {
        ServicesModel lServicesModel = new ServicesModel();
        lServicesModel.setServiceName("Food");
        mList.add(lServicesModel);
        ServicesModel lServicesModel2 = new ServicesModel();
        lServicesModel2.setServiceName("Beverages");
        mList.add(lServicesModel2);
        ServicesModel lServicesModel3 = new ServicesModel();
        lServicesModel3.setServiceName("Snacks");
        mList.add(lServicesModel3);
        ServicesModel lServicesModel4 = new ServicesModel();
        lServicesModel4.setServiceName("Desert");
        mList.add(lServicesModel4);
        ServicesModel lServicesModel5 = new ServicesModel();
        lServicesModel5.setServiceName("Breakfast");
        mList.add(lServicesModel5);
        ServicesModel lServicesModel7 = new ServicesModel();
        lServicesModel7.setServiceName("Dinner");
        mList.add(lServicesModel7);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRvServices.setLayoutManager(layoutManager);
        mRvServices.setItemAnimator(new DefaultItemAnimator());
        mRvRegisterServicesAdapter = new RvRegisterServicesAdapter(this, mList);
        mRvServices.setAdapter(mRvRegisterServicesAdapter);
    }

    private void setViewsTexts() {
        mTxtToolbarTitle.setText("Business settings");
    }
    private void initVariables() {
        mTxtToolbarTitle = findViewById(R.id.txtToolbarTitle);
        mCvSaveSettings = findViewById(R.id.cvSaveSettings);
        mRvServices = findViewById(R.id.rvServices);
        mRvDays = findViewById(R.id.rvDays);
    }
}
