package com.sola.android.architecture.domain.interactor.test_case;

import com.sola.android.architecture.domain.demo.JsonDemoDTO;
import com.sola.android.architecture.domain.demo.JsonDemoResultDTO;
import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;
import com.sola.android.architecture.domain.interactor.ComplexConnectionCase;

import rx.functions.Action1;

/**
 * Created by 禄骥
 * 2016/4/6.
 */
public abstract class AJsonComplexCase extends ComplexConnectionCase {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    protected AJsonComplexCase(ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread) {
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

    public abstract void resultWithCode(Action1<JsonDemoResultDTO> onNext,
                                        Action1<Throwable> onError);

    public abstract void resultWithOutCode(Action1<JsonDemoDTO> onNext,
                                           Action1<Throwable> onError);

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
