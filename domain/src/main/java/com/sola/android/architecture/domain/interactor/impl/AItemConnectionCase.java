package com.sola.android.architecture.domain.interactor.impl;

import com.sola.android.architecture.domain.ItemTabDTO;
import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;
import com.sola.android.architecture.domain.interactor.ComplexConnectionCase;
import com.sola.android.architecture.domain.repository.ItemRepository;

import java.util.Collection;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
public abstract class AItemConnectionCase extends ComplexConnectionCase {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    public AItemConnectionCase(ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread
    ) {
        super(threadExecutor, postExecutionThread);
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

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    public abstract void getRankList(Action1<Collection<ItemTabDTO>> onNext, Action1<Throwable> onError);

    public abstract void getRecommendList(Action1<Collection<ItemTabDTO>> onNext, Action1<Throwable> onError);

}
