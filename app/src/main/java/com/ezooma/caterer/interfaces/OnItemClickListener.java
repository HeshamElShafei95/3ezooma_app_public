package com.ezooma.caterer.interfaces;

import android.view.View;

public interface OnItemClickListener<T> {
    void onItemClick(View view, T object, int position);
}


