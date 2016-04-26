package com.dome.appstore.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dome.appstore.MainApplication;
import com.dome.appstore.internal.di.components.ApplicationComponent;
import com.dome.appstore.internal.di.modules.ActivityModule;
import com.dome.appstore.navigator.Navigator;

import javax.inject.Inject;

/**
 * Created by 禄骥
 * 2016/4/6.
 */
public abstract class DGBaseActivity extends AppCompatActivity {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    @Inject
    Navigator navigator;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    protected Navigator getNavigator() {
        return navigator;
    }

    public ApplicationComponent getApplicationComponent() {
        return ((MainApplication) getApplication()).getApplicationComponent();
    }

    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //向Application组件注册自己，不注册就没办法获取到组件中已有的实例
        getApplicationComponent().inject(this);
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
