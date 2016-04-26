package com.dome.appstore.internal.di.components;

import android.app.Activity;

import com.dome.appstore.internal.di.PerActivity;
import com.dome.appstore.internal.di.modules.DomeModule;
import com.dome.appstore.mapper.DTOToViewMapper;
import com.sola.android.architecture.domain.demo.JsonDemoDTO;
import com.sola.android.architecture.domain.interactor.ConnectionCase;
import com.sola.android.architecture.domain.interactor.test_case.AJsonComplexCase;

import dagger.Component;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = DomeModule.class)
public interface DomeComponent {
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

    ConnectionCase<JsonDemoDTO> getJsonTest();

    AJsonComplexCase getJsonCase();

    DTOToViewMapper dtoMapper();
}
