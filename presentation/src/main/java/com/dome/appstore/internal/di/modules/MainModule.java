package com.dome.appstore.internal.di.modules;

import com.dome.appstore.internal.di.PerActivity;
import com.sola.android.architecture.domain.interactor.impl.AItemConnectionCase;
import com.sola.android.architecture.domain.interactor.impl.GetItemList;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
@Module
public class MainModule {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================


    @Provides
    @PerActivity
    @Named("RankAppItem")
    AItemConnectionCase provideGetItemList(GetItemList itemList) {
        return itemList;
    }

//    @Provides
//    @PerActivity
//    RankListPresenter provideRankPresenter(
//            DownloadExecutor downloadExecutor,
//            @Named("RankAppItem") AItemConnectionCase connectionCase) {
//        return new RankListPresenter(downloadExecutor, connectionCase);
//    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
