package com.dome.appstore.internal.di.modules;

import android.app.Activity;

import com.dome.appstore.internal.di.PerActivity;
import com.sola.android.architecture.domain.demo.JsonDemoDTO;
import com.sola.android.architecture.domain.interactor.ConnectionCase;
import com.sola.android.architecture.domain.interactor.test_case.AJsonComplexCase;
import com.sola.android.architecture.domain.interactor.test_case.GetJsonDemo;
import com.sola.android.architecture.domain.interactor.test_case.JsonDemoComplex;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 禄骥
 * 2016/4/6.
 */
@Module
public class ActivityModule {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private final Activity mActivity;

    // ===========================================================
    // Constructors
    // ===========================================================

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    @Provides
    @PerActivity
    Activity provideActivity() {
        return mActivity;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
