package com.dome.appstore.internal.di.modules;

import android.app.Application;
import android.content.Context;

import com.dome.appstore.executor.JobExecutor;
import com.dome.appstore.executor.UIThread;
import com.sola.android.architecture.data.manage.DownManagerUtils;
import com.sola.android.architecture.data.repository.ItemDataRepository;
import com.sola.android.architecture.data.repository.JsonDemoDataRepository;
import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;
import com.sola.android.architecture.domain.repository.ItemRepository;
import com.sola.android.architecture.domain.repository.JsonDemoCaseRepository;
import com.sola.android.architecture.domain.utils.DownloadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 禄骥
 * 2016/4/6.
 */
@Module
public class ApplicationModule {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private final Application mApplication;

    // ===========================================================
    // Constructors
    // ===========================================================

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
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
     * @return 返回Application实例用
     */
    @Provides
    @Singleton
    Context provideApplication() {
        return mApplication;
    }

    /**
     * 向Dagger声明，将JobExecutor的实例绑定到ThreadExecutor的调用方去
     *
     * @param executor 官方文档上会有这个带参的存在，但是尝试了下把参数去掉，直接返回实例，也能达到目的，意义不明
     * @return 线程池对象
     */
    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor executor) {
        return executor;
    }

    /**
     * 向Dagger声明，将UIThread的实例绑定到PostExecutionThread的调用方上去
     *
     * @param thread 改变指向，将PostExecutionThread的指向转变为UIThread
     * @return 返回实例
     */
    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread thread) {
        return thread;
    }

    @Provides
    @Singleton
    JsonDemoCaseRepository provideJsonDemoCaseRepository(JsonDemoDataRepository data) {
        return data;
    }

    @Provides
    @Singleton
    ItemRepository provideItemRepository(ItemDataRepository repository) {
        return repository;
    }

    @Provides
    @Singleton
    DownloadExecutor provideDownloadExecutor(DownManagerUtils utils) {
        return utils;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
