package com.dome.androidtools.adapter;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;

import com.dome.androidtools.proxy.IRecyclerViewItem;

import java.util.Collection;
import java.util.List;

/**
 * RecyclerView的中间件适配器
 * <p>
 * Created by 禄骥
 * 2016/4/25.
 */
public abstract class RecyclerMiddlewareAdapter<Param extends IRecyclerViewItem>
        extends RecyclerBaseAdapter {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    protected List<Param> cacheList;

    protected SparseIntArray typeArray = new SparseIntArray();

    protected onRecyclerItemClickListener listener;

    // ===========================================================
    // Constructors
    // ===========================================================

    @SuppressWarnings("UnusedDeclaration")
    public RecyclerMiddlewareAdapter(final Context mContext,
                                     Collection<Param> list) {
        super(mContext);
        refreshList(list);
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    @SuppressWarnings("UnusedDeclaration")
    public void setListener(onRecyclerItemClickListener listener) {
        this.listener = listener;
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    protected int getCount() {
        return cacheList == null ? 0 : cacheList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (cacheList == null || cacheList.size() == 0)
            return -1;
        else {
            int viewType = cacheList.get(position).getViewType(position);
            if (typeArray.indexOfKey(viewType) == -1)
                typeArray.put(viewType, position);
            return viewType;
        }
    }

    // ===========================================================
    // Methods
    // ===========================================================

    /**
     * 通过ViewType去获取到数据的对应项
     *
     * @param viewType 布局类型
     * @return 返回对应的项
     */
    protected Param getItemByViewType(int viewType) {
        return cacheList.get(typeArray.get(viewType));
    }

    /**
     * @param params 刷新适配器当中所用到的集合数据
     */
    public void refreshList(Collection<Param> params) {
        if (params == null || params.size() == 0) {
            cacheList = new java.util.ArrayList<>();
        } else {
            if (cacheList == null)
                cacheList = new java.util.ArrayList<>();
            cacheList.clear();
            cacheList.addAll(params);
        }
        notifyDataSetChanged();
    }

    public void remove(int position) {
        if (getCount() != 0 && cacheList.size() > position) {
            cacheList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public Param getItemPosition(int position) {
        return cacheList == null ? null : cacheList.get(position);
    }

    public int getItemPosition(Param item) {
        return cacheList == null ? -1 : cacheList.indexOf(item);
    }

    public void addItem(Param item) {
        if (cacheList == null)
            return;
        cacheList.add(item);
        notifyItemInserted(cacheList.indexOf(item));
    }

    public void moveItem(int from, int to) {
        if (cacheList == null)
            return;
        Param param = cacheList.get(from);
        cacheList.remove(from);
        if (to == -1) {
            cacheList.add(param);
            notifyDataSetChanged();
        } else {
            cacheList.add(to, param);
            notifyDataSetChanged();
        }
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    public interface onRecyclerItemClickListener {
        void onItemClick(IRecyclerViewItem param, View view);
    }

}
