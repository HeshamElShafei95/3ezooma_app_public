<<<<<<< HEAD
package com.ezooma.caterer.controllers.ui.adapters.rvAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezooma.caterer.R;
import com.ezooma.caterer.interfaces.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class RvMenuItemsAdapter extends RecyclerView.Adapter<RvMenuItemsAdapter.ViewHolder> {
    private Context mContext;
private ArrayList<String> mList ;
    private OnItemClickListener<String> mOnItemClickListener;
    public RvMenuItemsAdapter(Context pContext, ArrayList<String> pList) {
        mContext = pContext;
        mList = pList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_menu_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.OnBind(mList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatTextView mTxtMenuFoodName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxtMenuFoodName = itemView.findViewById(R.id.txtMenuFoodName);
            itemView.setOnClickListener(this);
        }

        public void OnBind(String pS, int pPosition) {
            mTxtMenuFoodName.setText(pS);
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
=======
package com.ezooma.caterer.controllers.ui.adapters.rvAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezooma.caterer.R;
import com.ezooma.caterer.interfaces.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class RvMenuItemsAdapter extends RecyclerView.Adapter<RvMenuItemsAdapter.ViewHolder> {
    private Context mContext;
private ArrayList<String> mList ;
    private OnItemClickListener<String> mOnItemClickListener;
    public RvMenuItemsAdapter(Context pContext, ArrayList<String> pList) {
        mContext = pContext;
        mList = pList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_menu_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.OnBind(mList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatTextView mTxtMenuFoodName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxtMenuFoodName = itemView.findViewById(R.id.txtMenuFoodName);
            itemView.setOnClickListener(this);
        }

        public void OnBind(String pS, int pPosition) {
            mTxtMenuFoodName.setText(pS);
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
>>>>>>> d56c8e2f0b4ca020f46703d2dea49ad510a7f45a
