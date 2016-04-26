package com.sola.android.architecture.domain.interactor.impl;

import com.sola.android.architecture.domain.BannerResultDTO;
import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;
import com.sola.android.architecture.domain.interactor.ConnectionCase;
import com.sola.android.architecture.domain.repository.Case1Repository;

import javax.inject.Inject;

import rx.Observable;

/**
 * author: Sola
 * 2016/1/8
 */
public class GetImageList extends ConnectionCase<BannerResultDTO> {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private final Case1Repository repository;

    // ===========================================================
    // Constructors
    // ===========================================================
    @Inject
    protected GetImageList(ThreadExecutor threadExecutor,
                           PostExecutionThread postExecutionThread,
                           Case1Repository repository) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    protected Observable<BannerResultDTO> buildUseCaseObservable() {
        return repository.getImageList();
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
