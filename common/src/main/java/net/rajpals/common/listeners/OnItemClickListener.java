package net.rajpals.common.listeners;

/*
* This class is a ScrollListener for RecyclerView that allows to show/hide
* views when list is scrolled. It assumes that you have added a header

* */
public interface OnItemClickListener<T> {
    void onItemClickListener(int position, T obj);

}