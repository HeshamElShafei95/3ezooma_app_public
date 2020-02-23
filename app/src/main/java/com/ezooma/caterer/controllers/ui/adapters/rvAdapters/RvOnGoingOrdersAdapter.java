package com.ezooma.caterer.controllers.ui.adapters.rvAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezooma.caterer.R;
import com.ezooma.caterer.interfaces.OnItemClickListener;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class RvOnGoingOrdersAdapter extends RecyclerView.Adapter<RvOnGoingOrdersAdapter.ViewHolder> {
    private Context mContext ;
    private OnItemClickListener<String> mOnItemClickListener;
    public RvOnGoingOrdersAdapter(Context pContext) {
        mContext = pContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_ongoing_orders, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatButton mBtnDetail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mBtnDetail = itemView.findViewById(R.id.btnDetail);
            mBtnDetail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, "", getLayoutPosition());
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener<String> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
}