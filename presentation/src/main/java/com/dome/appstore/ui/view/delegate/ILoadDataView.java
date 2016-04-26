package com.dome.appstore.ui.view.delegate;

import android.content.Context;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
public interface ILoadDataView {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    void showLoading();

    void hideLoading();

    void showError(String error);

    Context getContext();

}
