package com.sola.android.architecture.data.net;

import com.sola.android.architecture.data.entity.BannerResultEntity;
import com.sola.android.architecture.data.entity.demo.JsonDemoResultEntity;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 这个类可以不是个接口，可以是个class，这里很随意，个人比较喜欢interface的形式
 * <p>
 * author: Sola
 * 2015/11/13
 */
public interface Case1Service {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    String BASE_URL = RestConfig.BASE_URL;

    // ===========================================================
    // Methods
    // ===========================================================

    @POST("/cms/f/imageList")
    Observable<BannerResultEntity> getImageList();

    @POST("/cms/f/articleList")
    Observable<BannerResultEntity> getArticleList(@Query("categoryId") String categoryId);

    @GET("/json")
    Observable<JsonDemoResultEntity> getJsonDemo();

}
