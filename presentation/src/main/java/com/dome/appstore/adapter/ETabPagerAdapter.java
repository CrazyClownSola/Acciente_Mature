package com.dome.appstore.adapter;

import android.support.v4.app.FragmentManager;

import com.dome.androidtools.adapter.AFragmentStatePagerAdapter;
import com.dome.appstore.uitls.ETab;


/**
 * Created by 禄骥
 * 2016/4/15.
 */
public abstract class ETabPagerAdapter extends AFragmentStatePagerAdapter<ETab> {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================
    public ETabPagerAdapter(FragmentManager fm, ETab[] tab) {
        super(fm, tab);
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public CharSequence getPageTitle(int position) {
        return getCacheTabs()[position].getTitle();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
