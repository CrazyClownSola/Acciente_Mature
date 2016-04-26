package com.dome.appstore.ui.view.delegate;

import com.dome.androidtools.proxy.IRecyclerViewItem;

import java.util.Collection;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
public interface IRankAppLoadView extends ILoadDataView {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    void onDataRefresh(Collection<IRecyclerViewItem> collection);

}
