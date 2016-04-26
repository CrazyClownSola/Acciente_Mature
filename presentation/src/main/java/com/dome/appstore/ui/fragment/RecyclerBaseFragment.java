package com.dome.appstore.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dome.androidtools.adapter.RecyclerViewAdapter;
import com.dome.androidtools.proxy.IRecyclerViewItem;
import com.dome.appstore.uitls.DividerItemDecoration;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.Collection;

/**
 * Created by 禄骥
 * 2016/4/26.
 */
@EFragment
public abstract class RecyclerBaseFragment extends DGBaseFragment {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    RecyclerViewAdapter<IRecyclerViewItem> adapter;

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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        presenter.setLoadView(this);
    }

    // ===========================================================
    // Methods
    // ===========================================================

    @AfterViews
    public void afterViews() {
        adapter = new RecyclerViewAdapter<>(getContext(), null);
        adapter.setListener(IRecyclerViewItem::itemClick);
        if (buildRecyclerView() != null) {
            buildRecyclerView().addItemDecoration(buildItemDecoration());
            buildRecyclerView().setLayoutManager(buildLayoutManager());
            buildRecyclerView().setItemAnimator(buildItemAnimator());
            buildRecyclerView().setAdapter(adapter);
        }
        doAfterViews();
    }

    protected RecyclerView.ItemDecoration buildItemDecoration() {
        return new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL_LIST);
    }

    protected RecyclerView.LayoutManager buildLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    protected RecyclerView.ItemAnimator buildItemAnimator() {
        return null;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    protected abstract void doAfterViews();

    protected abstract RecyclerView buildRecyclerView();

}
