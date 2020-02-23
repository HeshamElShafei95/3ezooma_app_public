<<<<<<< HEAD
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
import com.ezooma.caterer.controllers.ui.activities.homeScreens.OnGoingOrderDetailsActivity;
import com.ezooma.caterer.controllers.ui.activities.homeScreens.PastOrdersDetailActivity;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvNewOrdersAdapter;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvPastOrderAdapters;
import com.ezooma.caterer.interfaces.OnFragmentInteraction;
import com.ezooma.caterer.interfaces.OnItemClickListener;
import com.ezooma.caterer.utilities.abstracts.BaseFragment;

public class PastOrdersFragment extends BaseFragment {

    private RecyclerView mRvPastOrders;
    private RvPastOrderAdapters mRvPastOrderAdapters;
    private OnFragmentInteraction mListener;

    public PastOrdersFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PastOrdersFragment newInstance() {
        PastOrdersFragment fragment = new PastOrdersFragment();
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
        View lView = inflater.inflate(R.layout.fragment_past_orders, container, false);
        mRvPastOrders = lView.findViewById(R.id.rvPastOrders);
        return lView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRv();
    }

    private void setUpRv() {
        if (getActivity() == null)
            return;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRvPastOrders.setLayoutManager(layoutManager);
        mRvPastOrders.setItemAnimator(new DefaultItemAnimator());
        mRvPastOrderAdapters = new RvPastOrderAdapters(getActivity());
        mRvPastOrders.setAdapter(mRvPastOrderAdapters);
        mRvPastOrderAdapters.setOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(View view, String object, int position) {
                changeActivity(getActivity() , PastOrdersDetailActivity.class,false,null);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
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
=======
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
import com.ezooma.caterer.controllers.ui.activities.homeScreens.OnGoingOrderDetailsActivity;
import com.ezooma.caterer.controllers.ui.activities.homeScreens.PastOrdersDetailActivity;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvNewOrdersAdapter;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvPastOrderAdapters;
import com.ezooma.caterer.interfaces.OnFragmentInteraction;
import com.ezooma.caterer.interfaces.OnItemClickListener;
import com.ezooma.caterer.utilities.abstracts.BaseFragment;

public class PastOrdersFragment extends BaseFragment {

    private RecyclerView mRvPastOrders;
    private RvPastOrderAdapters mRvPastOrderAdapters;
    private OnFragmentInteraction mListener;

    public PastOrdersFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PastOrdersFragment newInstance() {
        PastOrdersFragment fragment = new PastOrdersFragment();
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
        View lView = inflater.inflate(R.layout.fragment_past_orders, container, false);
        mRvPastOrders = lView.findViewById(R.id.rvPastOrders);
        return lView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRv();
    }

    private void setUpRv() {
        if (getActivity() == null)
            return;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRvPastOrders.setLayoutManager(layoutManager);
        mRvPastOrders.setItemAnimator(new DefaultItemAnimator());
        mRvPastOrderAdapters = new RvPastOrderAdapters(getActivity());
        mRvPastOrders.setAdapter(mRvPastOrderAdapters);
        mRvPastOrderAdapters.setOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(View view, String object, int position) {
                changeActivity(getActivity() , PastOrdersDetailActivity.class,false,null);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
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
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
