package com.sola.android.architecture.data.manage;

import android.util.Log;

import com.sola.android.architecture.data.BuildConfig;
import com.sola.android.architecture.domain.utils.DownloadExecutor;
import com.sola.android.architecture.domain.utils.IDownloadListener;

import javax.inject.Inject;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
public class DownManagerUtils implements DownloadExecutor {

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

    @Inject
    public DownManagerUtils() {
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public void registerListener(IDownloadListener listener) {
        if (BuildConfig.DEBUG)
            Log.d(TAG, "it is in register listener");
    }

    @Override
    public void unregisterListener(IDownloadListener listener) {
        if (BuildConfig.DEBUG)
            Log.d(TAG, "it is in unregister listener");
    }


    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
