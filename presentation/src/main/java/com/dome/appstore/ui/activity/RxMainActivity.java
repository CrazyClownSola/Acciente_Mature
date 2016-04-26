package com.dome.appstore.ui.activity;

import android.support.design.widget.TabLayout;
import android.view.View;

import com.dome.androidtools.view.NoScrollViewPager;
import com.dome.appstore.R;
import com.dome.appstore.adapter.MyPagerAdapter;
import com.dome.appstore.internal.di.HasComponent;
import com.dome.appstore.internal.di.components.DaggerMainComponent;
import com.dome.appstore.internal.di.components.MainComponent;
import com.dome.appstore.uitls.ETab;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
@EActivity(R.layout.activity_rx_main)
public class RxMainActivity extends RxBaseActivity
        implements HasComponent<MainComponent> {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private MainComponent component;

    @ViewById
    NoScrollViewPager id_view_pager;

    @ViewById
    TabLayout id_tab_layout;

    MyPagerAdapter pagerAdapter;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================


    @Override
    protected void doAfterViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        component = DaggerMainComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
        ETab[] tabs = new ETab[]{
                ETab.RECOMMEND,
                ETab.GAME,
                ETab.RANK,
                ETab.MANAGE
        };
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), tabs);
        id_view_pager.setAdapter(pagerAdapter);
        // TODO: 2016/4/26 这里需要考虑的情况是，是否需要设定所有加载的Fragment为静态的问题，设定成静态，界面不会有刷新的问题
        id_view_pager.setOffscreenPageLimit(4);
        id_tab_layout.setupWithViewPager(id_view_pager);
        for (int i = 0; i < id_tab_layout.getTabCount(); i++) {
            View view = View.inflate(this, tabs[i].getResourceID(), null);
            if (i == 0)
                view.setSelected(true);
            if (id_tab_layout.getTabAt(i) != null && view != null)
                id_tab_layout.getTabAt(i).setCustomView(view);
        }
    }

    @Override
    public MainComponent getComponent() {
        return component;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
