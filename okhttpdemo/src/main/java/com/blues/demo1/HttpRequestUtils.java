package com.blues.demo1;


import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpRequestUtils {

    private static volatile OkHttpClient instance;
    private String baseUrl;
    private static OkHttpClient okHttpClient;
    private static Request request;
    private static Call call;
    private static Gson gson;

    private HttpRequestUtils() {

    }

    public static OkHttpClient getInstance() {
        if (instance == null) {
            synchronized (HttpRequestUtils.class) {
                if (instance == null) {
                    instance = new OkHttpClient.Builder()
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS)
                            .retryOnConnectionFailure(true)
                            .build();
                }
            }
        }
        return instance;
    }

    public static  <T> T get(String url, final Class<T> tClass) {
        request = new Request.Builder()
                .url(url)
                .get()
                .build();
        call = getInstance().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("Blues", "请求失败");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                gson = new Gson();
                gson.fromJson(response.body().string(), (Type) tClass);
            }
        });
        return (T) tClass;
    }
}
