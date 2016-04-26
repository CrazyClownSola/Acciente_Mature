package com.dome.appstore.presenter;

import com.dome.appstore.internal.di.PerActivity;
import com.dome.appstore.ui.view.delegate.ILoadDataView;
import com.sola.android.architecture.domain.utils.DownloadExecutor;
import com.sola.android.architecture.domain.utils.IDownloadListener;

import javax.inject.Inject;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
@PerActivity
public class RankPresenter implements IPresenter, IDownloadListener {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    final DownloadExecutor downloadExecutor;

    // ===========================================================
    // Constructors
    // ===========================================================

    @Inject
    public RankPresenter(DownloadExecutor downloadExecutor) {
        this.downloadExecutor = downloadExecutor;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public void resume() {
        downloadExecutor.registerListener(this);
    }

    @Override
    public void pause() {
        downloadExecutor.unregisterListener(this);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void setLoadView(ILoadDataView view) {

    }

    @Override
    public void onResponse(Object... params) {

    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
