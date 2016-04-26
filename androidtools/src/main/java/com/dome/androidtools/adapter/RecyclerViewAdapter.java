package com.dome.androidtools.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.dome.androidtools.BuildConfig;
import com.dome.androidtools.proxy.IRecyclerViewItem;

import java.util.Collection;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
public class RecyclerViewAdapter<Param extends IRecyclerViewItem>
        extends RecyclerMiddlewareAdapter<Param> {

    // ===========================================================
    // Constants
    // ===========================================================

    private final static String TAG = "Sola";

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    public RecyclerViewAdapter(Context mContext,
                               Collection<Param> list) {
        super(mContext, list);
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    protected void onBindView(Context mContext, RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (BuildConfig.DEBUG)
            Log.v(TAG, "onBindView: [" + position + "][" + viewType + "][" + holder + "]");
        cacheList.get(position).refreshView(mContext, holder, viewType);

    }

    @Override
    protected RecyclerView.ViewHolder onCreateView(Context mContext, ViewGroup parent, int viewType) {
        if (BuildConfig.DEBUG)
            Log.v(TAG, "onCreateView: " + viewType);
        Param item = getItemByViewType(viewType);
        if (item == null)
            return null;
        RecyclerView.ViewHolder holder = item.getHolder(mContext, parent, viewType);
        if (listener != null) {
            holder.itemView.setOnClickListener(v ->
                    listener.onItemClick(item, v));
        }
        return holder;
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
