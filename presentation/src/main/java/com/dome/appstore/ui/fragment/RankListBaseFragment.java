package com.dome.appstore.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.dome.appstore.BuildConfig;
import com.dome.appstore.internal.di.components.MainComponent;
import com.dome.appstore.presenter.IPresenter;
import com.dome.appstore.presenter.RankListPresenter;
import com.dome.appstore.ui.view.delegate.ILoadDataView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
@EFragment
public abstract class RankListBaseFragment extends RecyclerBaseFragment {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    @Inject
    RankListPresenter presenter;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(getFragment());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (BuildConfig.DEBUG)
            Log.d(TAG, "onResume: " + getClass().getName());
        presenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (BuildConfig.DEBUG)
            Log.d(TAG, "onPause: " + getClass().getName());
        presenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (BuildConfig.DEBUG)
            Log.d(TAG, "onDestroy: " + getClass().getName());
        presenter.destroy();
    }

    // ===========================================================
    // Methods
    // ===========================================================

    /**
     * 向MainComponent组件注入自己，注意在afterView的地方进行调用
     *
     * @param fragment 子类
     */
    protected void inject(RankListBaseFragment fragment) {
        getComponent(MainComponent.class).inject(fragment);
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================


    protected abstract RankListBaseFragment getFragment();
}
