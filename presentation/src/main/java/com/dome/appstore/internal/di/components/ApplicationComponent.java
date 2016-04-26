package com.dome.appstore.internal.di.components;

import android.content.Context;

import com.dome.appstore.internal.di.modules.ApplicationModule;
import com.dome.appstore.mapper.DTOToViewMapper;
import com.dome.appstore.navigator.Navigator;
import com.dome.appstore.ui.activity.DGBaseActivity;
import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;
import com.sola.android.architecture.domain.repository.ItemRepository;
import com.sola.android.architecture.domain.repository.JsonDemoCaseRepository;
import com.sola.android.architecture.domain.utils.DownloadExecutor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 禄骥
 * 2016/4/6.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    /******************
     * 容器的创建
     *********************/

    void inject(DGBaseActivity context);

    Context getContext();

    /******************
     * 工具类的创建
     *********************/
    Navigator getNavigator();

    ThreadExecutor getThreadExecutor();

    PostExecutionThread getPostExecutionThread();

    DownloadExecutor downManager();

    /******************
     * 仓储部分的创建
     *********************/

    JsonDemoCaseRepository demoRepository();

    ItemRepository itemRepository();
}
