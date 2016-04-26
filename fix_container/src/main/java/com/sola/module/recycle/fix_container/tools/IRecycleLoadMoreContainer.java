package com.sola.module.recycle.fix_container.tools;

import android.support.v7.widget.RecyclerView;

import com.sola.module.recycle.fix_container.RecyclerContainerBase;

/**
 * Description:
 * <p>
 * author: Sola
 * 2015/10/13
 */
public interface IRecycleLoadMoreContainer {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================


    void loadMoreFinish(boolean emptyResult, boolean hasMore);

    void loadMoreError(int errorCode, String errorMessage);

    RecyclerContainerBase getContainerBase();

}
