package com.dome.appstore.internal.di.components;

import android.app.Activity;

import com.dome.appstore.internal.di.PerActivity;
import com.dome.appstore.internal.di.modules.ActivityModule;
import com.sola.android.architecture.domain.demo.JsonDemoDTO;
import com.sola.android.architecture.domain.interactor.ConnectionCase;
import com.sola.android.architecture.domain.interactor.test_case.AJsonComplexCase;

import dagger.Component;

/**
 * 这个组件是作为父类组件存在的，基本不单用
 * <p>
 * Created by 禄骥
 * 2016/4/6.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = ActivityModule.class)
public interface ActivityComponent {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    Activity getActivity();

}
