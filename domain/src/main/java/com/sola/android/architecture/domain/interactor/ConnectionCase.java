package com.sola.android.architecture.domain.interactor;

import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * 如果是构建一对一的关系的话可以继承此类
 * 这种方式思路比较清晰，单个类就代表访问了单个接口，缺点就是接口一旦数量多起来，代码量会增加
 * author: Sola
 * 2016/1/8
 */
public abstract class ConnectionCase<T> {
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

    protected ConnectionCase(ThreadExecutor threadExecutor,
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
     * @return 根据不同需求返回不同服务接口
     */
    protected abstract Observable<T> buildUseCaseObservable();

    /**
     * 提交请求
     *
     * @param onNext  正确流程处理
     * @param onError 出错处理
     */
    @SuppressWarnings("unchecked")
    public void execute(Action1<T> onNext, Action1<Throwable> onError) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(onNext, onError);
    }

    /**
     * 提交请求
     *
     * @param subscriber 提供另外一种回调方式
     */
    @SuppressWarnings("unchecked")
    public void execute(Subscriber subscriber) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(subscriber);
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
