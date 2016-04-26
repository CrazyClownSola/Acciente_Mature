package com.sola.android.architecture.data.repository;

import android.util.Log;

import com.sola.android.architecture.data.entity.mapper.BannerEntityDataMapper;
import com.sola.android.architecture.data.net.ApiConnection;
import com.sola.android.architecture.data.net.Case1Service;
import com.sola.android.architecture.domain.demo.JsonDemoDTO;
import com.sola.android.architecture.domain.demo.JsonDemoResultDTO;
import com.sola.android.architecture.domain.repository.JsonDemoCaseRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by 禄骥
 * 2016/4/6.
 */
public class JsonDemoDataRepository implements JsonDemoCaseRepository {

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
    public JsonDemoDataRepository(BannerEntityDataMapper userEntityDataMapper) {
        this.userEntityDataMapper = userEntityDataMapper;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    public Observable<JsonDemoDTO> getJsonDemo() {
        Log.d("Sola", "It s in Data get Json Demo");
        return ApiConnection.createService(Case1Service.BASE_URL, Case1Service.class)
                .getJsonDemo()
                .flatMap(jsonDemoResultEntity ->
                        Observable.from(
                                userEntityDataMapper.transform(jsonDemoResultEntity)
                        ));
    }

    @Override
    public Observable<JsonDemoResultDTO> getJsonDemoResult() {
        return ApiConnection.createService(Case1Service.BASE_URL, Case1Service.class)
                .getJsonDemo()
                .flatMap(jsonDemoResultEntity ->
                        Observable.just(userEntityDataMapper.transformResult(jsonDemoResultEntity))
                );
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
