package com.dome.appstore.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.dome.appstore.ui.fragment.GameFragment;
import com.dome.appstore.ui.fragment.GameFragment_;
import com.dome.appstore.ui.fragment.ManageFragment;
import com.dome.appstore.ui.fragment.ManageFragment_;
import com.dome.appstore.ui.fragment.RankAppFragment;
import com.dome.appstore.ui.fragment.RankAppFragment_;
import com.dome.appstore.ui.fragment.RankFragment;
import com.dome.appstore.ui.fragment.RankFragment_;
import com.dome.appstore.ui.fragment.RankOffLineFragment;
import com.dome.appstore.ui.fragment.RankOffLineFragment_;
import com.dome.appstore.ui.fragment.RankOnLineFragment;
import com.dome.appstore.ui.fragment.RankOnLineFragment_;
import com.dome.appstore.ui.fragment.RecommendFragment;
import com.dome.appstore.ui.fragment.RecommendFragment_;
import com.dome.appstore.uitls.ETab;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
public class MyPagerAdapter extends ETabPagerAdapter {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    public MyPagerAdapter(FragmentManager fm, ETab[] tab) {
        super(fm, tab);
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    protected ETab getRelation(Fragment f) {
        if (f instanceof RankAppFragment)
            return ETab.RANK_APP;
        else if (f instanceof RankOffLineFragment)
            return ETab.RANK_OFFLINE;
        else if (f instanceof RankOnLineFragment)
            return ETab.RANK_ONLINE;
        else if (f instanceof RankFragment)
            return ETab.RANK;
        else if (f instanceof GameFragment)
            return ETab.GAME;
        else if (f instanceof ManageFragment)
            return ETab.MANAGE;
        else if (f instanceof RecommendFragment)
            return ETab.RECOMMEND;
        return null;
    }

    @Override
    protected Fragment initFragment(ETab tab) {
        switch (tab) {
            case RANK:
                return new RankFragment_();
            case GAME:
                return new GameFragment_();
            case RECOMMEND:
                return new RecommendFragment_();
            case MANAGE:
                return new ManageFragment_();
            case RANK_APP:
                return new RankAppFragment_();
            case RANK_OFFLINE:
                return new RankOffLineFragment_();
            case RANK_ONLINE:
                return new RankOnLineFragment_();
        }
        return null;
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
