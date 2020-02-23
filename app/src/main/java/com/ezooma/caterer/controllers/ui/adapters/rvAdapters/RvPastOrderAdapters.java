<<<<<<< HEAD
package com.ezooma.caterer.controllers.ui.adapters.rvAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezooma.caterer.R;
import com.ezooma.caterer.interfaces.OnItemClickListener;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class RvPastOrderAdapters extends RecyclerView.Adapter<RvPastOrderAdapters.ViewHolder> {
    private Context mContext;
    private OnItemClickListener<String> mOnItemClickListener;

    public RvPastOrderAdapters(Context pContext) {
        mContext = pContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_past_orders, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatButton mBtnDetail;
        AppCompatTextView mTxtPastOrderStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mBtnDetail = itemView.findViewById(R.id.btnDetail);
            mTxtPastOrderStatus = itemView.findViewById(R.id.txtPastOrderStatus);
            mBtnDetail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, "", getLayoutPosition());
            }
        }

        public void onBind(int pPosition) {
            if (pPosition % 2 == 0) {
            mTxtPastOrderStatus.setText("Order Status: Order Delivered");
            mTxtPastOrderStatus.setTextColor(mContext.getResources().getColor(R.color.green));
            }
            else{
                mTxtPastOrderStatus.setText("Order Status: Order Cancelled");
                mTxtPastOrderStatus.setTextColor(mContext.getResources().getColor(R.color.btn_red));
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener<String> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
=======
package com.ezooma.caterer.controllers.ui.adapters.rvAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezooma.caterer.R;
import com.ezooma.caterer.interfaces.OnItemClickListener;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class RvPastOrderAdapters extends RecyclerView.Adapter<RvPastOrderAdapters.ViewHolder> {
    private Context mContext;
    private OnItemClickListener<String> mOnItemClickListener;

    public RvPastOrderAdapters(Context pContext) {
        mContext = pContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_past_orders, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatButton mBtnDetail;
        AppCompatTextView mTxtPastOrderStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mBtnDetail = itemView.findViewById(R.id.btnDetail);
            mTxtPastOrderStatus = itemView.findViewById(R.id.txtPastOrderStatus);
            mBtnDetail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, "", getLayoutPosition());
            }
        }

        public void onBind(int pPosition) {
            if (pPosition % 2 == 0) {
            mTxtPastOrderStatus.setText("Order Status: Order Delivered");
            mTxtPastOrderStatus.setTextColor(mContext.getResources().getColor(R.color.green));
            }
            else{
                mTxtPastOrderStatus.setText("Order Status: Order Cancelled");
                mTxtPastOrderStatus.setTextColor(mContext.getResources().getColor(R.color.btn_red));
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener<String> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
}