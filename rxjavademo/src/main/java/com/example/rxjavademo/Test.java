package com.example.rxjavademo;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * User : Blues
 * Date : 2019/6/26
 * Time : 18:31
 */

public interface Test {

    @GET("/test")
    Observable<Messaget> getMsg(String code, String token);

}
