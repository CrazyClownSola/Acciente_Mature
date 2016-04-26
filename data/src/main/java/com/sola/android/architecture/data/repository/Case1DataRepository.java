package com.sola.android.architecture.data.repository;

import com.sola.android.architecture.data.entity.mapper.BannerEntityDataMapper;
import com.sola.android.architecture.data.exception.NetworkConnectionException;
import com.sola.android.architecture.data.net.ApiConnection;
import com.sola.android.architecture.data.net.Case1Service;
import com.sola.android.architecture.domain.BannerResultDTO;
import com.sola.android.architecture.domain.demo.JsonDemoDTO;
import com.sola.android.architecture.domain.repository.Case1Repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * author: Sola
 * 2016/1/8
 */
@Singleton
public class Case1DataRepository implements Case1Repository {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private final BannerEntityDataMapper userEntityDataMapper;

    // ===========================================================
    // Constructors
    // ===========================================================

    @Inject
    public Case1DataRepository(BannerEntityDataMapper userEntityDataMapper) {
        this.userEntityDataMapper = userEntityDataMapper;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    /**
     * @return 这里做了一个预处理，过滤掉了访问返回所带的Code和message信息
     */
    @Override
    public Observable<BannerResultDTO> getImageList() {
        //这里的实现方式，有人推荐使用一种工厂模式去做Observable的构建
        return ApiConnection.createService(Case1Service.BASE_URL, Case1Service.class)
                .getImageList()
                .flatMap(bannerResultEntity -> {
                    if (bannerResultEntity != null && bannerResultEntity.isSuccess())
                        return Observable.from(
                                userEntityDataMapper.transform(bannerResultEntity));
                    return Observable.error(
                            new NetworkConnectionException(
                                    bannerResultEntity == null ? "" :
                                            bannerResultEntity.getMsg()));
                });
    }

    @Override
    public Observable<BannerResultDTO> getArticleList(String categoryId) {
        return ApiConnection.createService(Case1Service.BASE_URL, Case1Service.class)
                .getArticleList(categoryId)
                .flatMap(bannerResultEntity ->
                        Observable.from(
                                userEntityDataMapper.transform(bannerResultEntity)));
    }


//    @Override
//    public Observable<JsonDemoDTO> getJsonDemo() {
//        return ApiConnection.createService(Case1Service.BASE_URL, Case1Service.class)
//                .getJsonDemo()
//                .flatMap(jsonDemoResultEntity ->
//                        Observable.from(
//                                userEntityDataMapper.transform(jsonDemoResultEntity)
//                        ));
//    }
    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
