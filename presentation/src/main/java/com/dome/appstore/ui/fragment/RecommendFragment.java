package com.dome.appstore.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.dome.androidtools.proxy.IRecyclerViewItem;
import com.dome.appstore.BuildConfig;
import com.dome.appstore.R;
import com.dome.appstore.internal.di.components.MainComponent;
import com.dome.appstore.presenter.RecommendPresenter;
import com.dome.appstore.ui.activity.DetailActivity_;
import com.dome.appstore.ui.view.delegate.IRecyclerLoadView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by 禄骥
 * 2016/4/26.
 */
@EFragment(R.layout.fragment_recommend)
public class RecommendFragment extends RecyclerBaseFragment
        implements IRecyclerLoadView {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    @Inject
    RecommendPresenter presenter;

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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 两行配置代码
        // 向MainComponent组件当中注册自己，用于获取组件的存量
        getComponent(MainComponent.class).inject(this);
        // 向代理设置界面刷新接口
        presenter.setLoadView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (BuildConfig.DEBUG)
            Log.d(TAG, "onResume: " + getClass().getName());
        presenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (BuildConfig.DEBUG)
            Log.d(TAG, "onPause: " + getClass().getName());
        presenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (BuildConfig.DEBUG)
            Log.d(TAG, "onDestroy: " + getClass().getName());
        presenter.destroy();
    }

    @Override
    protected void doAfterViews() {
        // 向代理请求更新界面
        presenter.loadData();
    }

    @Override
    protected RecyclerView buildRecyclerView() {
        return id_recycler_view;
    }

    @Override
    public void onDataRefresh(Collection<IRecyclerViewItem> collection) {
        adapter.refreshList(collection);
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

    @Click
    public void id_btn_fab_show() {
        Bundle bundle = new Bundle();
        bundle.putString("title", "明细列表");
        getComponent(MainComponent.class).getNavigator().switchActivity(
                getActivity(), DetailActivity_.class, bundle
        );
    }


    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
