<<<<<<< HEAD
package com.ezooma.caterer.controllers.ui.activities.homeScreens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.fragments.AddCategoryFragment;
import com.ezooma.caterer.controllers.ui.fragments.MenuFragment;
import com.ezooma.caterer.interfaces.OnFragmentInteraction;
import com.ezooma.caterer.utilities.abstracts.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends BaseActivity implements OnFragmentInteraction {

    MenuFragment mMenuFragment;
    AddCategoryFragment mAddCategoryFragment;
    BottomNavigationView mBottomNavigation;
    Bundle mBundle;
    AppCompatTextView mTxtToolbarTitle;
    AppCompatImageView mImgToolbarBack;
    RelativeLayout mRlAddItems, mMenuToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initVariables();
        firstFragment();
        mTxtToolbarTitle.setText("Menu Categories");
        mRlAddItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MenuActivity.this, AddItemsActivity.class, false, null);
            }
        });
    }

    private void initVariables() {
        mMenuToolbar = findViewById(R.id.menuToolbar);
        mTxtToolbarTitle = findViewById(R.id.txtToolbarTitle);
        mBottomNavigation = findViewById(R.id.navigation);
        mRlAddItems = findViewById(R.id.rlAddItems);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
        mBottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_menu:
                            firstFragment();
                            break;
                        case R.id.navigation_add_category:
                            mBundle = new Bundle();
                            onFragment(mBundle, AddCategoryFragment.TAG);
                            break;
                    }
                    return true;
                }

            };

    @Override
    public void onFragment(Object o, String fragmentTag) {
        if (fragmentTag.equalsIgnoreCase(MenuFragment.TAG)) {
            mMenuFragment = MenuFragment.newInstance();
            mTxtToolbarTitle.setText("Menu Categories");
            /*mMenuToolbar.setVisibility(View.VISIBLE);*/
            changeFragment(MenuFragment.TAG, mMenuFragment);
        } else if (fragmentTag.equalsIgnoreCase(AddCategoryFragment.TAG)) {
            mAddCategoryFragment = AddCategoryFragment.newInstance();
            mTxtToolbarTitle.setText("Add New Category");
            /*mMenuToolbar.setVisibility(View.GONE);*/
            changeFragment(AddCategoryFragment.TAG, mAddCategoryFragment);
        }
    }

    private void firstFragment() {

        mBundle = new Bundle();
        onFragment(mBundle, MenuFragment.TAG);
    }

    private void changeFragment(String tag, Fragment fragment) {
        setFragment(fragment, tag, false);
    }
}
=======
package com.ezooma.caterer.controllers.ui.activities.homeScreens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.fragments.AddCategoryFragment;
import com.ezooma.caterer.controllers.ui.fragments.MenuFragment;
import com.ezooma.caterer.interfaces.OnFragmentInteraction;
import com.ezooma.caterer.utilities.abstracts.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends BaseActivity implements OnFragmentInteraction {

    MenuFragment mMenuFragment;
    AddCategoryFragment mAddCategoryFragment;
    BottomNavigationView mBottomNavigation;
    Bundle mBundle;
    AppCompatTextView mTxtToolbarTitle ;
    AppCompatImageView mImgToolbarBack;
    RelativeLayout mRlAddItems ,mMenuToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initVariables();
        firstFragment();
        mTxtToolbarTitle.setText("Menu Categories");
        mRlAddItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MenuActivity.this, AddItemsActivity.class, false, null);
            }
        });
    }

    private void initVariables() {
        mMenuToolbar = findViewById(R.id.menuToolbar);
        mTxtToolbarTitle = findViewById(R.id.txtToolbarTitle);
        mBottomNavigation = findViewById(R.id.navigation);
        mRlAddItems = findViewById(R.id.rlAddItems);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
        mBottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_menu:
                            firstFragment();
                            break;
                        case R.id.navigation_add_category:
                            mBundle = new Bundle();
                            onFragment(mBundle, AddCategoryFragment.TAG);
                            break;
                    }
                    return true;
                }

            };

    @Override
    public void onFragment(Object o, String fragmentTag) {
        if (fragmentTag.equalsIgnoreCase(MenuFragment.TAG)) {
            mMenuFragment = MenuFragment.newInstance();
            mTxtToolbarTitle.setText("Menu Categories");
            /*mMenuToolbar.setVisibility(View.VISIBLE);*/
            changeFragment(MenuFragment.TAG, mMenuFragment);
        } else if (fragmentTag.equalsIgnoreCase(AddCategoryFragment.TAG)) {
            mAddCategoryFragment = AddCategoryFragment.newInstance();
            mTxtToolbarTitle.setText("Add New Category");
            /*mMenuToolbar.setVisibility(View.GONE);*/
            changeFragment(AddCategoryFragment.TAG, mAddCategoryFragment);
        }
    }

    private void firstFragment() {

        mBundle = new Bundle();
        onFragment(mBundle, MenuFragment.TAG);
    }

    private void changeFragment(String tag, Fragment fragment) {
        setFragment(fragment, tag, false);
    }
}
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
