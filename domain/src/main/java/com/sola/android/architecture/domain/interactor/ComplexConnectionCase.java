package com.sola.android.architecture.domain.interactor;

import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * author: Sola
 * 2016/1/8
 */
public abstract class ComplexConnectionCase {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private final ThreadExecutor threadExecutor;

    private final PostExecutionThread postExecutionThread;

    private Subscription subscription = Subscriptions.empty();


    // ===========================================================
    // Constructors
    // ===========================================================

    protected ComplexConnectionCase(ThreadExecutor threadExecutor,
                                    PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
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

    /**
     * 提交请求
     *
     * @param onNext     正确流程处理
     * @param onError    出错处理
     * @param observable 处理流
     */
    protected <T> void execute(Observable<T> observable,
                               Action1<? super T> onNext,
                               Action1<Throwable> onError) {
        this.subscription = observable
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(onNext, onError);
    }


    /**
     * 关闭RxJava流程
     */
    public void unSubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
