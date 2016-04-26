package com.dome.appstore.ui.fragment;

import android.support.v7.widget.RecyclerView;

import com.dome.appstore.R;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
@EFragment(R.layout.fragment_default_recycler_view)
public class RankAppFragment extends RankLoadViewBaseFragment {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    @ViewById
    RecyclerView id_recycler_view;

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
    protected void doAfterViews() {
        presenter.loadData();
    }

    @Override
    protected RecyclerView buildRecyclerView() {
        return id_recycler_view;
    }

    @Override
    protected RankListBaseFragment getFragment() {
        return this;
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
