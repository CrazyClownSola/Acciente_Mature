package com.dome.appstore;

import android.app.Application;

import com.dome.appstore.internal.di.components.ApplicationComponent;
import com.dome.appstore.internal.di.components.DaggerActivityComponent;
import com.dome.appstore.internal.di.components.DaggerApplicationComponent;
import com.dome.appstore.internal.di.modules.ApplicationModule;

/**
 * Created by 禄骥
 * 2016/4/5.
 */
public class MainApplication extends Application {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    ApplicationComponent mComponent;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public ApplicationComponent getApplicationComponent() {
        return mComponent;
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public void onCreate() {
        super.onCreate();
//        DaggerActivityComponent
        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }


    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
