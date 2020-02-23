package com.ezooma.caterer.controllers.ui.adapters.pagerAdapters;

import com.ezooma.caterer.controllers.ui.fragments.NewOrdersFragment;
import com.ezooma.caterer.controllers.ui.fragments.OngoingOrdersFragment;
import com.ezooma.caterer.controllers.ui.fragments.PastOrdersFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class MyOrdersPagerAdapter extends FragmentStatePagerAdapter {
    private String[] mPagerTitles;

    public MyOrdersPagerAdapter(@NonNull FragmentManager fm, String[] pPagerTitles) {
        super(fm);
        mPagerTitles = pPagerTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NewOrdersFragment.newInstance();
            case 1:
                return OngoingOrdersFragment.newInstance();
            case 2:
                return PastOrdersFragment.newInstance();

        }

        return NewOrdersFragment.newInstance();
    }

    @Override
    public int getCount() {
        return mPagerTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mPagerTitles[position];//mFragmentTitleList.get(position);
    }
}
