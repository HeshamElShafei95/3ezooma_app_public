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
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvNewOrdersAdapter;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvOnGoingOrdersAdapter;
import com.ezooma.caterer.interfaces.OnFragmentInteraction;
import com.ezooma.caterer.interfaces.OnItemClickListener;
import com.ezooma.caterer.utilities.abstracts.BaseFragment;


public class OngoingOrdersFragment extends BaseFragment {

    private OnFragmentInteraction mListener;
    private RecyclerView mRvOnGoingOrders;
    private RvOnGoingOrdersAdapter mRvOnGoingOrdersAdapter;

    public OngoingOrdersFragment() {
        // Required empty public constructor
    }

    public static OngoingOrdersFragment newInstance() {
        OngoingOrdersFragment fragment = new OngoingOrdersFragment();
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
        View view = inflater.inflate(R.layout.fragment_ongoing_orders, container, false);
        mRvOnGoingOrders = view.findViewById(R.id.rvOngoingOrders);
        return view;
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
        mRvOnGoingOrders.setLayoutManager(layoutManager);
        mRvOnGoingOrders.setItemAnimator(new DefaultItemAnimator());
        mRvOnGoingOrdersAdapter = new RvOnGoingOrdersAdapter(getActivity());
        mRvOnGoingOrders.setAdapter(mRvOnGoingOrdersAdapter);
        mRvOnGoingOrdersAdapter.setOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(View view, String object, int position) {
                changeActivity(getActivity() , OnGoingOrderDetailsActivity.class,false,null);

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
