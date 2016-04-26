package com.dome.appstore.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dome.androidtools.adapter.RecyclerViewAdapter;
import com.dome.androidtools.proxy.IRecyclerViewItem;
import com.dome.appstore.R;
import com.dome.appstore.internal.di.HasComponent;
import com.dome.appstore.internal.di.components.DaggerDomeComponent;
import com.dome.appstore.internal.di.components.DomeComponent;
import com.dome.appstore.internal.di.modules.DomeModule;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 禄骥
 * 2016/4/6.
 */
@EActivity(R.layout.activity_main)
public class DemoActivity extends DGBaseActivity
        implements HasComponent<DomeComponent> {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

//    @Inject
//    ConnectionCase<JsonDemoDTO> connectionCase;

    DomeComponent component;

    @ViewById
    RecyclerView id_recycler_view;

    RecyclerViewAdapter<IRecyclerViewItem> adapter;

    List<IRecyclerViewItem> cacheList;

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component = DaggerDomeComponent.builder()
                .applicationComponent(getApplicationComponent())
                .domeModule(new DomeModule(this)).build();
    }

    // ===========================================================
    // Methods
    // ===========================================================

    @AfterViews
    public void afterViews() {
        getNavigator().checkNotNull();
        viewInflate();
    }

    @Click
    public void id_btn_test() {

        // 这个方法和下面的方法的区别在于case的源的问题，这个的case源是单一性质的请求源<ConnectionCase>
        getComponent().getJsonTest().execute(jsonDemoDTO -> {
            Log.i("Sola", jsonDemoDTO.toString());
        }, Throwable::printStackTrace);

        //下面两个方法用的case源是<ComplexConnectionCase>,一个Case可以对应多个请求，多个仓储，属于一对多的形式
        // 不是最推荐这个方法
        getComponent().getJsonCase().resultWithOutCode(jsonDemoDTO -> {
            Log.i("Sola", "[result WithOutCode]:" + jsonDemoDTO.toString());
//            adapter.addItem(getDataMapper().transform(jsonDemoDTO));
        }, Throwable::printStackTrace);

        //这里和上面的区别在于返回参数的类型不相同的问题
        getComponent().getJsonCase().resultWithCode(jsonDemoResultDTO -> {
            Log.i("Sola", "[result WithCode]:" + jsonDemoResultDTO.toString());
            cacheList.clear();
            cacheList.addAll(getComponent().dtoMapper().transformResult(jsonDemoResultDTO));
            adapter.refreshList(cacheList);
        }, Throwable::printStackTrace);
    }

    @Click
    public void id_btn_circular_progress() {
        getNavigator().switchToMain(this);
    }


    private void viewInflate() {
        cacheList = new ArrayList<>();
        if (adapter == null)
            adapter = new RecyclerViewAdapter<>(this, cacheList);
        id_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        id_recycler_view.setItemAnimator(new DefaultItemAnimator());
        id_recycler_view.setAdapter(adapter);
    }

    @Override
    public DomeComponent getComponent() {
        return component;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
