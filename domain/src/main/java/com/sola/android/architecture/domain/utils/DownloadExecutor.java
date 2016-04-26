package com.sola.android.architecture.domain.utils;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
public interface DownloadExecutor {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    void registerListener(IDownloadListener listener);

    void unregisterListener(IDownloadListener listener);

}
