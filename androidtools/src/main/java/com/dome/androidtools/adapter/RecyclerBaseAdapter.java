package com.dome.androidtools.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.dome.androidtools.proxy.IRecycleExtraItem;

import java.lang.ref.WeakReference;

/**
 * Created by 禄骥
 * 2016/4/7.
 */
public abstract class RecyclerBaseAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private final WeakReference<Context> mContext;

    // ===========================================================
    // Constructors
    // ===========================================================

    public RecyclerBaseAdapter(Context mContext) {
        this.mContext = new WeakReference<Context>(mContext);
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateView(mContext.get(), parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindView(mContext.get(), holder, position);
    }

    @Override
    public int getItemCount() {
        return getCount();
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================


    protected abstract int getCount();

    protected abstract void onBindView(Context mContext, RecyclerView.ViewHolder holder, int position);

    protected abstract RecyclerView.ViewHolder onCreateView(Context mContext, ViewGroup parent, int viewType);
}
