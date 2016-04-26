package com.sola.android.architecture.domain.interactor.impl;

import com.sola.android.architecture.domain.ItemTabDTO;
import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;
import com.sola.android.architecture.domain.interactor.ComplexConnectionCase;
import com.sola.android.architecture.domain.interactor.ConnectionCase;
import com.sola.android.architecture.domain.repository.ItemRepository;

import java.util.Collection;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
public class GetItemList extends AItemConnectionCase {


    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    final ItemRepository repository;

    // ===========================================================
    // Constructors
    // ===========================================================

    @Inject
    public GetItemList(ThreadExecutor threadExecutor,
                       PostExecutionThread postExecutionThread,
                       ItemRepository repository) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    public void getRankList(Action1<Collection<ItemTabDTO>> onNext, Action1<Throwable> onError) {
        execute(repository.getRankAppList(), onNext, onError);
//        repository.
    }

    @Override
    public void getRecommendList(Action1<Collection<ItemTabDTO>> onNext, Action1<Throwable> onError) {
        execute(repository.getRecommendList(), onNext, onError);
    }


    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
