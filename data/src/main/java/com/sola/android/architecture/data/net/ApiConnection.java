package com.sola.android.architecture.data.net;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * author: Sola
 * 2015/10/30
 */
public class ApiConnection {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private static OkHttpClient httpClient;
    private static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    //添加对于RxJava的适用，致使可以在Api接口当中直接使用Rxjava
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    //直接使用Gson转换进行对于参数的适配
                    .addConverterFactory(GsonConverterFactory.create(gson));

    private static Retrofit.Builder normalBuilder
            = new Retrofit.Builder()
            //添加对于RxJava的适用，致使可以在Api接口当中直接使用Rxjava
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

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

    /**
     * @param baseUrl      注意这里的基础Url为域名或者Ip地址
     * @param serviceClass 实现服务接口的类
     * @param <S>          返回的服务接口
     * @return 服务接口对象
     */
    public static <S> S createService(String baseUrl, Class<S> serviceClass) {
        if (httpClient == null)
            httpClient = new OkHttpClient.Builder()
                    .addInterceptor(new LoggingInterceptor()).build();
        Retrofit retrofit = builder.baseUrl(baseUrl).client(httpClient).build();
        return retrofit.create(serviceClass);
    }

    public static <S> S createServiceCallString(String baseUrl, Class<S> serviceClass) {
        if (httpClient == null)
            httpClient = new OkHttpClient.Builder()
                    .addInterceptor(new LoggingInterceptor()).build();
        Retrofit retrofit = normalBuilder.baseUrl(baseUrl).client(httpClient).build();
        return retrofit.create(serviceClass);
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    /**
     * 监听请求日志用的类
     */
    static class LoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long t1 = System.nanoTime();
            Log.d("OkHttp", String.format("Sending request %s on %s%n%s body [%s]",
                    request.url(), chain.connection(), request.headers(), request.body()));
            Response response = chain.proceed(request);
            long t2 = System.nanoTime();
            Log.d("OkHttp", String.format("Received response for %s in %.1fms%n%s ",
                    response.request().url(),
                    (t2 - t1) / 1e6d,
                    response.headers()));
            return response;
        }
    }
}
