package com.dome.appstore.internal.di.components;

import com.dome.appstore.internal.di.PerActivity;
import com.dome.appstore.internal.di.modules.ActivityModule;
import com.dome.appstore.internal.di.modules.MainModule;
import com.dome.appstore.navigator.Navigator;
import com.dome.appstore.ui.fragment.GameFragment;
import com.dome.appstore.ui.fragment.RankListBaseFragment;
import com.dome.appstore.ui.fragment.RankFragment;
import com.dome.appstore.ui.fragment.RecommendFragment;

import dagger.Component;

/**
 * 推荐模块的组件
 * <p>
 * Created by 禄骥
 * 2016/4/25.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {
        ActivityModule.class, MainModule.class
})
public interface MainComponent extends ActivityComponent {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    void inject(RankFragment fragment);

    void inject(RecommendFragment fragment);

    void inject(GameFragment fragment);

    void inject(RankListBaseFragment fragment);

    Navigator getNavigator();
}
