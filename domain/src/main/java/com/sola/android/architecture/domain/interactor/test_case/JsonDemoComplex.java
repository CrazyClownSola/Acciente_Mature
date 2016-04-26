package com.sola.android.architecture.domain.interactor.test_case;

import com.sola.android.architecture.domain.demo.JsonDemoDTO;
import com.sola.android.architecture.domain.demo.JsonDemoResultDTO;
import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;
import com.sola.android.architecture.domain.repository.JsonDemoCaseRepository;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by 禄骥
 * 2016/4/6.
 */
public class JsonDemoComplex extends AJsonComplexCase {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    final JsonDemoCaseRepository repository;

    // ===========================================================
    // Constructors
    // ===========================================================

    @Inject
    protected JsonDemoComplex(ThreadExecutor threadExecutor,
                              PostExecutionThread postExecutionThread,
                              JsonDemoCaseRepository repository) {
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
    public void resultWithCode(Action1<JsonDemoResultDTO> onNext, Action1<Throwable> onError) {
        execute(repository.getJsonDemoResult(), onNext, onError);
    }

    @Override
    public void resultWithOutCode(Action1<JsonDemoDTO> onNext, Action1<Throwable> onError) {
        execute(repository.getJsonDemo(), onNext, onError);

    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
