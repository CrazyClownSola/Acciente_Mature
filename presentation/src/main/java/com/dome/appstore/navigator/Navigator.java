package com.dome.appstore.navigator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.dome.appstore.ui.activity.RxMainActivity_;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by 禄骥
 * 2016/4/6.
 */
@Singleton
public class Navigator {
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
    public Navigator() {
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

    public void checkNotNull() {
        Log.d("Sola", "It s in Navigator");
    }

    public void switchToMain(final Context context) {
        Intent intent = new Intent();
        intent.setClass(context, RxMainActivity_.class);
        context.startActivity(intent);
    }

    public void switchActivity(final Context context, Class<?> cls) {
        switchActivity(context, cls, null);
    }

    public void switchActivity(final Context context, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        if (bundle != null && !bundle.isEmpty())
            intent.putExtras(bundle);
        context.startActivity(intent);
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
