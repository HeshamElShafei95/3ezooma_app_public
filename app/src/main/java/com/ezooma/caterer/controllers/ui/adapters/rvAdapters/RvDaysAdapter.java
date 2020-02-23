<<<<<<< HEAD
package com.ezooma.caterer.controllers.ui.adapters.rvAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezooma.caterer.R;
import com.ezooma.caterer.interfaces.OnItemClickListener;
import com.ezooma.caterer.models.servicesModels.ServicesDaysModel;
import com.ezooma.caterer.models.servicesModels.ServicesModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class RvDaysAdapter extends RecyclerView.Adapter<RvDaysAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<ServicesDaysModel> mServicesDaysList;
    private OnItemClickListener<ServicesDaysModel> mOnItemClickListener;

    public RvDaysAdapter(Context pContext, ArrayList<ServicesDaysModel> pStringArrayList) {
        mContext = pContext;
        mServicesDaysList = pStringArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_services, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(mServicesDaysList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mServicesDaysList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatCheckBox mCbDays;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCbDays = itemView.findViewById(R.id.cbService);
            mCbDays.setOnClickListener(this);
        }

        public void onBind(ServicesDaysModel serviceDayModel, int pPosition) {
            mCbDays.setText(serviceDayModel.getDayName());
            if (serviceDayModel.isDaysChecked()) {
                mCbDays.setChecked(true);
            } else {
                mCbDays.setChecked(false);
            }
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, mServicesDaysList.get(getAdapterPosition()), getLayoutPosition());
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener<ServicesDaysModel> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
}
=======
package com.ezooma.caterer.controllers.ui.adapters.rvAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezooma.caterer.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class RvDaysAdapter extends RecyclerView.Adapter<RvDaysAdapter.ViewHolder> {
    Context mContext ;
    ArrayList<String> mStringArrayList ;

    public RvDaysAdapter(Context pContext, ArrayList<String> pStringArrayList) {
        mContext = pContext;
        mStringArrayList = pStringArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_services, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(mStringArrayList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mStringArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatCheckBox mCbDays;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCbDays = itemView.findViewById(R.id.cbService);
        }

        public void onBind(String pS, int pPosition) {
            mCbDays.setText(pS);

        }
    }
}
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
