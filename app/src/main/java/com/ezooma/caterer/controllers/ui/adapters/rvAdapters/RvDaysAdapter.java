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
