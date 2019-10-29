package com.example.volleydemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * User : Blues
 * Date : 2019/5/6
 * Time : 16:14
 */

public class MainActivity extends Activity {

    private Context mContext;
    private static final String url = "http://gank.io/api/data/Android/10/1";

    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        tvShow = findViewById(R.id.tv_show);
    }

    public void SendRequest(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                1.构建一个请求队列
                RequestQueue rq = new Volley().newRequestQueue(mContext);

//                2.构建一个请求体
                StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tvShow.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Blues", "error code--->" + error.networkResponse.statusCode);
                    }
                });
//                3.将请求体放入请求队列
                rq.add(sr);
            }
        }).start();
    }
}
