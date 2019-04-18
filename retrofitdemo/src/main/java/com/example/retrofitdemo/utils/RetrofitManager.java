package com.example.retrofitdemo.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static Retrofit.Builder mRetrofitBuilder;
    private static String BASE_URL = "";

    private static String getBaseUrl() {
        return BASE_URL;
    }

    private static void setBaseUrl(String url) {
        BASE_URL = url;
    }

    public static Retrofit getInstance() {
        if (null == mRetrofitBuilder) {
            synchronized (RetrofitManager.class) {
                if (null == mRetrofitBuilder) {
                    mRetrofitBuilder = new Retrofit.Builder()
                            .client(new OkHttpClient())
                            .addConverterFactory(GsonConverterFactory.create());
                }
            }
        }
        return mRetrofitBuilder
                .baseUrl(getBaseUrl())
                .build();
    }
}
