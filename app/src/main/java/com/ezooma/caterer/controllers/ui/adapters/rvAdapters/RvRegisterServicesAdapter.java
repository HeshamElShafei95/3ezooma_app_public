package com.ezooma.caterer.controllers.ui.adapters.rvAdapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezooma.caterer.R;
import com.ezooma.caterer.models.ServicesModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class RvRegisterServicesAdapter extends RecyclerView.Adapter<RvRegisterServicesAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<ServicesModel> mServiceList;

    public RvRegisterServicesAdapter(Context pContext, ArrayList<ServicesModel> pServiceList) {
        mContext = pContext;
        mServiceList = pServiceList;
    }

    @NonNull
    @Override
    public RvRegisterServicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_services, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvRegisterServicesAdapter.ViewHolder holder, int position) {
        holder.onBind(mServiceList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mServiceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatCheckBox mCbService;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCbService = itemView.findViewById(R.id.cbService);
        }

        public void onBind(ServicesModel pServicesModel, int pPosition) {
            Log.e("SERVICES" , pServicesModel.getServiceName().toString());
            mCbService.setText(pServicesModel.getServiceName());
        }
    }
}
