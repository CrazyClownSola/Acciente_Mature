package com.dome.appstore.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dome.androidtools.adapter.RecyclerViewAdapter;
import com.dome.androidtools.proxy.IRecyclerViewItem;
import com.dome.appstore.ui.view.delegate.IRankAppLoadView;
import com.dome.appstore.uitls.DividerItemDecoration;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.Collection;

/**
 * 这个基类纯粹是代码的复用
 * Created by 禄骥
 * 2016/4/25.
 */
@EFragment
public abstract class RankLoadViewBaseFragment extends RankListBaseFragment
        implements IRankAppLoadView {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

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
    public void onDataRefresh(Collection<IRecyclerViewItem> collection) {
        adapter.refreshList(collection);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setLoadView(this);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String error) {

    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
