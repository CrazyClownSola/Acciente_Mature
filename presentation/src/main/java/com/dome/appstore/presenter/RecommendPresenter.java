package com.dome.appstore.presenter;

import com.dome.appstore.internal.di.PerActivity;
import com.dome.appstore.mapper.ItemDtoToViewMapper;
import com.dome.appstore.ui.view.delegate.IRecyclerLoadView;
import com.sola.android.architecture.domain.interactor.impl.AItemConnectionCase;
import com.sola.android.architecture.domain.utils.DownloadExecutor;
import com.sola.android.architecture.domain.utils.IDownloadListener;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by 禄骥
 * 2016/4/26.
 */
@PerActivity
public class RecommendPresenter implements IPresenter<IRecyclerLoadView>, IDownloadListener {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private IRecyclerLoadView loadView;

    final DownloadExecutor mExecutor;

    final ItemDtoToViewMapper mMapper;

    final AItemConnectionCase mConnectionCase;

    // ===========================================================
    // Constructors
    // ===========================================================

    @Inject
    public RecommendPresenter(
            DownloadExecutor downloadExecutor,
            ItemDtoToViewMapper mapper,
            @Named("RankAppItem") AItemConnectionCase connectionCase
    ) {
        mExecutor = downloadExecutor;
        mMapper = mapper;
        mConnectionCase = connectionCase;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public void onResponse(Object... params) {

    }

    @Override
    public void resume() {
        mExecutor.registerListener(this);
    }

    @Override
    public void pause() {
        mExecutor.unregisterListener(this);
    }

    @Override
    public void destroy() {
        mConnectionCase.unSubscribe();
        mExecutor.unregisterListener(this);
    }

    @Override
    public void setLoadView(IRecyclerLoadView view) {
        this.loadView = view;
    }

    // ===========================================================
    // Methods
    // ===========================================================

    public void loadData() {
        mConnectionCase.getRecommendList(itemTabDTOs ->
                loadView.onDataRefresh(mMapper.transform(itemTabDTOs)), throwable -> {
            throwable.printStackTrace();
            loadView.showError(throwable.getMessage());
        });
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
