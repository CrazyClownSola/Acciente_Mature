package com.dome.appstore.ui.fragment;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.dome.appstore.BuildConfig;
import com.dome.appstore.R;
import com.dome.appstore.internal.di.components.MainComponent;
import com.dome.appstore.presenter.GamePresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

/**
 * Created by 禄骥
 * 2016/4/26.
 */
@EFragment(R.layout.fragment_game)
public class GameFragment extends DGBaseFragment {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    @Inject
    GamePresenter presenter;

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

    @AfterViews
    public void afterViews() {
        getComponent(MainComponent.class).inject(this);
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
