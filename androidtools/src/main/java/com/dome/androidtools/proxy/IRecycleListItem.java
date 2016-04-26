package com.dome.androidtools.proxy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description:
 * <p>
 * author: Sola
 * 2015/9/25
 */
public interface IRecycleListItem {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    /**
     * 获取布局
     *
     * @param context context容器
     * @param parent  父类布局
     * @return 返回布局View
     */
    View getView(Context context, ViewGroup parent);

    /**
     * 构建Holder
     *
     * @param context  context容器
     * @param parent   父类布局
     * @param viewType 布局类型
     * @return 返回RecyclerView需要的ViewHolder
     */
    RecyclerView.ViewHolder getHolder(Context context, ViewGroup parent, int viewType);

    /**
     * 刷新布局
     *
     * @param context  context容器
     * @param holder   view容器
     * @param viewType 布局类型
     */
    void refreshView(Context context, RecyclerView.ViewHolder holder, int viewType);

    /**
     * item点击事件
     *
     * @param v 点击的view
     */
    void itemClick(View v);

}
