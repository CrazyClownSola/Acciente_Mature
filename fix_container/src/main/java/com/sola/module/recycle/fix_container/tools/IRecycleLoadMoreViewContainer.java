package com.sola.module.recycle.fix_container.tools;

import android.support.v7.widget.RecyclerView;

/**
 * Created by 禄骥
 * 2016/4/11.
 */
public interface IRecycleLoadMoreViewContainer extends IRecycleLoadMoreContainer {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    void setOnScrollListener(RecyclerView.OnScrollListener listener);

    void setShowLoadingForFirstPage(boolean shown);

    void setLoadMoreUIHandler(IRecycleLoadMoreUIHandler handler);

    void setLoadMoreHandler(IRecycleLoadMoreHandler handler);
}
