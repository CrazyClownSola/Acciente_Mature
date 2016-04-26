package com.dome.appstore.presenter;

import com.dome.appstore.mapper.ItemDtoToViewMapper;
import com.dome.appstore.ui.view.delegate.ILoadDataView;
import com.dome.appstore.ui.view.delegate.IRankAppLoadView;
import com.sola.android.architecture.domain.interactor.impl.AItemConnectionCase;
import com.sola.android.architecture.domain.utils.DownloadExecutor;
import com.sola.android.architecture.domain.utils.IDownloadListener;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
public class RankListPresenter implements IPresenter<IRankAppLoadView>, IDownloadListener {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    final DownloadExecutor downloadExecutor;

    final AItemConnectionCase connectionCase;

    final ItemDtoToViewMapper mapper;

    int type;

    IRankAppLoadView loadView;

    // ===========================================================
    // Constructors
    // ===========================================================

    @Inject
    public RankListPresenter(
            DownloadExecutor downloadExecutor,
            ItemDtoToViewMapper mapper,
            @Named("RankAppItem") AItemConnectionCase connectionCase
    ) {
        this.downloadExecutor = downloadExecutor;
        this.connectionCase = connectionCase;
        this.mapper = mapper;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public void setType(int type) {
        this.type = type;
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public void resume() {
        downloadExecutor.registerListener(this);
    }

    @Override
    public void pause() {
        downloadExecutor.unregisterListener(this);
    }

    @Override
    public void destroy() {
        connectionCase.unSubscribe();
    }

    @Override
    public void setLoadView(IRankAppLoadView view) {
        loadView = view;
    }

    @Override
    public void onResponse(Object... params) {

    }

    // ===========================================================
    // Methods
    // ===========================================================

    public void loadData() {
        connectionCase.getRankList(itemTabDTO ->
                        loadView.onDataRefresh(mapper.transform(itemTabDTO)),
                Throwable::printStackTrace);
    }


    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
