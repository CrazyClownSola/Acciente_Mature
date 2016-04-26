package com.dome.appstore.ui.view.delegate;

import com.dome.androidtools.proxy.IRecyclerViewItem;

import java.util.Collection;

/**
 * Created by 禄骥
 * 2016/4/26.
 */
public interface IRecyclerLoadView extends ILoadDataView {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    void onDataRefresh(Collection<IRecyclerViewItem> collection);
}
