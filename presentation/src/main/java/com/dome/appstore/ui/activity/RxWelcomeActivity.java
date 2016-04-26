package com.dome.appstore.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;

import com.dome.appstore.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

/**
 * Created by 禄骥
 * 2016/4/26.
 */
@EActivity(R.layout.activity_welcome)
public class RxWelcomeActivity extends DGBaseActivity {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    @ViewById
    ViewStub id_view_stub_banner_view;

    Subscription time_sub = Subscriptions.empty();

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
    protected void onPause() {
        super.onPause();
        if (!time_sub.isUnsubscribed())
            time_sub.unsubscribe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        time_sub = Observable.interval(2, TimeUnit.SECONDS)
                .take(2)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    if (aLong == 0) {
                        id_view_stub_banner_view.inflate();
                        View view = findViewById(R.id.id_btn_welcome_skip_wait);
                        if (view != null)
                            view.setOnClickListener(v -> switchActivity(RxMainActivity_.class));
                    } else {
                        switchActivity(RxMainActivity_.class);
                    }
                });
    }

    // ===========================================================
    // Methods
    // ===========================================================

    private void switchActivity(Class<?> activity) {
        navigator.switchActivity(this, activity);
        this.finish();
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
