package com.ezooma.caterer.controllers.ui.activities.homeScreens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.activities.loginSignupPackage.ChangePasswordActivity;
import com.ezooma.caterer.controllers.ui.activities.settings.settingScreen.NotificationActivity;
import com.ezooma.caterer.controllers.ui.activities.settings.settingScreen.SettingsActivity;
import com.ezooma.caterer.controllers.ui.adapters.pagerAdapters.MyOrdersPagerAdapter;
import com.ezooma.caterer.interfaces.OnFragmentInteraction;
import com.ezooma.caterer.utilities.abstracts.BaseActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeScreenActivity extends BaseActivity implements OnFragmentInteraction {
    AppCompatTextView mToolbarTitle;
    AppCompatImageView mImgToolbarSideMenu, mImgToolbarNotifications;
    DrawerLayout mDrawerLayout;
    NavigationView mNavView;
    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initVariables();
        setInitialValues();
        homeClickListeners();
        setUpTabLayouts();
    }
    private void setUpTabLayouts() {

        String[] strings = new String[]{"New Orders", "Ongoing Orders","Past Orders"};

        MyOrdersPagerAdapter lMyOrdersPagerAdapter = new MyOrdersPagerAdapter(getSupportFragmentManager(), strings);

        mViewPager.setAdapter(lMyOrdersPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void initVariables() {
        mToolbarTitle = findViewById(R.id.txtHomeToolbarLocation);
        mImgToolbarSideMenu = findViewById(R.id.imgHomeToolbarMenu);
        mImgToolbarNotifications = findViewById(R.id.imgToolbarNotifications);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavView = findViewById(R.id.nav_view);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.pager);
        mToolbarTitle.setText("Our Orders");
    }
    private void setInitialValues() {
        openCloseDrawer(false);
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_menu:
                        openCloseDrawer(false);
                        changeActivity(HomeScreenActivity.this, MenuActivity.class, false, null);
                        return false;
                    case R.id.nav_schedule:
                        openCloseDrawer(false);
                       // changeActivity(HomeScreenActivity.this, NotificationsActivity.class, false, null);
                        return false;
                    case R.id.nav_profile:
                        openCloseDrawer(false);
                    //    changeActivity(HomeScreenActivity.this, HelpActivity.class, false, null);
                        return false;
                    case R.id.nav_reviews:
                        openCloseDrawer(false);
                            changeActivity(HomeScreenActivity.this, ReviewsAndRatingActivity.class, false, null);
                        return false;


                    case R.id.nav_settings:
                        openCloseDrawer(false);
                        changeActivity(HomeScreenActivity.this, SettingsActivity.class, false, null);
                        return false;


                }
                return false;
            }
        });
    }
    private void homeClickListeners() {
        mImgToolbarSideMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCloseDrawer(true);
            }
        });

        mImgToolbarNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(HomeScreenActivity.this , NotificationActivity.class , false,null);
            }
        });
    }

    void openCloseDrawer(boolean drawerStatus) {
        if (drawerStatus) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.closeDrawers();
        }
    }

    @Override
    public void onFragment(Object o, String fragmentTag) {

    }
}
