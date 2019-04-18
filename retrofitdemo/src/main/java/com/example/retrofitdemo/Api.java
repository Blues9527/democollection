package com.example.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("Android/{item}/{page}")
    Call<Bean> getCall(@Path("item") int item, @Path("page") int page);
}
