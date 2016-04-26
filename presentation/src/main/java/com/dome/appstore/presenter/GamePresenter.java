package com.dome.appstore.presenter;

import com.dome.appstore.internal.di.PerActivity;
import com.dome.appstore.ui.view.delegate.ILoadDataView;
import com.sola.android.architecture.domain.utils.IDownloadListener;

import javax.inject.Inject;

/**
 * Created by 禄骥
 * 2016/4/26.
 */
@PerActivity
public class GamePresenter implements IPresenter, IDownloadListener {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    @Inject
    public GamePresenter() {
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    public void onResponse(Object... params) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void setLoadView(ILoadDataView view) {

    }
    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
