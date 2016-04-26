package com.sola.android.architecture.domain.interactor.test_case;

import com.sola.android.architecture.domain.demo.JsonDemoDTO;
import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;
import com.sola.android.architecture.domain.interactor.ComplexConnectionCase;
import com.sola.android.architecture.domain.interactor.ConnectionCase;
import com.sola.android.architecture.domain.repository.JsonDemoCaseRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by 禄骥
 * 2016/4/6.
 */
public class GetJsonDemo extends ConnectionCase<JsonDemoDTO> {

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
    protected GetJsonDemo(
            ThreadExecutor threadExecutor,
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
    protected Observable<JsonDemoDTO> buildUseCaseObservable() {
        return repository.getJsonDemo();
    }

    // ===========================================================
    // Methods
    // ===========================================================


    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
