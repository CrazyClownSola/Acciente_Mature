package com.sola.android.architecture.data.net;

import com.sola.android.architecture.data.entity.app.Result_ItemEntity;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
public interface ItemService {
    // ===========================================================
    // Constants
    // ===========================================================

    String BASE_URL = RestConfig.BASE_URL;

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    @GET("/")
    Observable<Result_ItemEntity> getRankAppItems();


    @GET("/")
    Observable<Result_ItemEntity> getRecommendItems();
}
