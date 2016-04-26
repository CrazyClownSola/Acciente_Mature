package com.dome.appstore.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.dome.appstore.R;
import com.dome.appstore.adapter.MyPagerAdapter;
import com.dome.appstore.internal.di.components.MainComponent;
import com.dome.appstore.presenter.RankPresenter;
import com.dome.appstore.uitls.ETab;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
@EFragment(R.layout.fragment_rank)
public class RankFragment extends DGBaseFragment {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    @Inject
    RankPresenter presenter;

    @ViewById
    TabLayout id_tab_layout;

    @ViewById
    ViewPager id_view_pager;

    MyPagerAdapter adapter;

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
        presenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    // ===========================================================
    // Methods
    // ===========================================================

    @AfterViews
    public void afterViews() {
        getComponent(MainComponent.class).inject(this);
        ETab[] tabs = new ETab[]{
                ETab.RANK_APP,
                ETab.RANK_ONLINE,
                ETab.RANK_OFFLINE
        };
        adapter = new MyPagerAdapter(getChildFragmentManager(), tabs);
        id_tab_layout.setTabMode(TabLayout.MODE_FIXED);
        id_tab_layout.setTabGravity(TabLayout.GRAVITY_FILL);
        id_view_pager.setAdapter(adapter);
        id_tab_layout.setupWithViewPager(id_view_pager);
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
