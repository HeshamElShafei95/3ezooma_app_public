package com.ezooma.caterer.controllers.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.activities.homeScreens.AddedItemsActivity;
import com.ezooma.caterer.controllers.ui.activities.homeScreens.OnGoingOrderDetailsActivity;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvMenuItemsAdapter;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvOnGoingOrdersAdapter;
import com.ezooma.caterer.interfaces.OnFragmentInteraction;
import com.ezooma.caterer.interfaces.OnItemClickListener;
import com.ezooma.caterer.utilities.abstracts.BaseFragment;

import java.util.ArrayList;

public class MenuFragment extends BaseFragment {

    private OnFragmentInteraction mListener;
    private RecyclerView mRvMenuItems;
    private RvMenuItemsAdapter mRvMenuItemsAdapter;
    ArrayList<String> mList = new ArrayList<>();
    public static String TAG = MenuFragment.class.getSimpleName();

    public MenuFragment() {
        // Required empty public constructor
    }


    public static MenuFragment newInstance() {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        mRvMenuItems = view.findViewById(R.id.rvMenuItems);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mList.add("Food");
        mList.add("Beverages");
        mList.add("Desert");
        mList.add("Breads");
        mList.add("Drinks");
        mList.add("Snacks");
        mList.add("Chinese");
        mList.add("Italian");
        mList.add("Seafood");
        mList.add("Special Meals");
        mList.add("Caterer Speciality");
        setUpRv();
    }

    private void setUpRv() {
        if (getActivity() == null)
            return;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRvMenuItems.setLayoutManager(layoutManager);
        mRvMenuItems.setItemAnimator(new DefaultItemAnimator());
        mRvMenuItemsAdapter = new RvMenuItemsAdapter(getActivity(), mList);
        mRvMenuItems.setAdapter(mRvMenuItemsAdapter);
        mRvMenuItemsAdapter.setOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(View view, String object, int position) {
                changeActivity(getActivity(), AddedItemsActivity.class, false, null);
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteraction) {
            mListener = (OnFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
