package com.ezooma.caterer.controllers.ui.adapters.spinnerAdapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ezooma.caterer.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class SpinnerStringAdapter<T> extends ArrayAdapter<T> {
    private ArrayList<T> mItems;
    private Activity mActivity;

    public SpinnerStringAdapter(Activity activity, ArrayList<T> items) {
        super(activity, android.R.layout.simple_list_item_1, items);
        mActivity = activity;
        mItems = items;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        /*return super.getDropDownView(position, convertView, parent);*/
        View dropDownView = convertView;
        if (dropDownView == null) {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            dropDownView = inflater.inflate(R.layout.spinner_item_drop_down, null);
        }
        TextView txtDropDown = dropDownView.findViewById(R.id.label_sp_drop_down_item);
        if (mItems.get(position) instanceof String) {
            String item = (String) mItems.get(position);
            txtDropDown.setText(item);

            if (position == 0) {
                txtDropDown.setTextColor(mActivity.getResources().getColor(R.color.hint_gray));
            } else {
                txtDropDown.setTextColor(mActivity.getResources().getColor(R.color.black));
            }
        } else {
            T item = mItems.get(position);
            txtDropDown.setText(item.toString());
        }
        return dropDownView;
    }

    @Override
    public boolean isEnabled(int position) {
        if (position == 0) {
            // Disable the first item from Spinner
            // First item will be use for hint
            return false;
        } else {
            return true;
        }
    }

    @Nullable
    @Override
    public T getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View selectedView = convertView;
        if (selectedView == null) {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            selectedView = inflater.inflate(R.layout.spinner_view, null);
        }
        TextView lbl = selectedView.findViewById(R.id.label_sp_item);
        if (mItems.get(position) instanceof String) {
            String item = (String) mItems.get(position);
            lbl.setText(item);
            if (position == 0) {
                lbl.setTextColor(mActivity.getResources().getColor(R.color.hint_gray));
            } else {
                lbl.setTextColor(mActivity.getResources().getColor(R.color.black));
            }
        } else {
            T item = mItems.get(position);
            lbl.setText(item.toString());
        }

        return selectedView;
    }
}
