package com.example.urlconnectiondemo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "https://m.weibo.cn/api/container/getIndex?containerid=102803&openApp=0&since_id=1";
    private HttpURLConnection connection;
    private InputStream ios;
    private StringBuffer stringBuffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Click(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    java.net.URL req = new URL(URL);
                    connection = (HttpURLConnection) req.openConnection();
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);
                    connection.setUseCaches(false);
                    connection.setDefaultUseCaches(false);
                    connection.connect();

                    ios = connection.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    stringBuffer = new StringBuffer();
                    while ((len = ios.read(bytes)) != -1) {
                        stringBuffer.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
                    }

                    Gson gosn = new Gson();
                    WeiboEntity entity = gosn.fromJson(String.valueOf(stringBuffer), WeiboEntity.class);
                    Log.i("Blues", entity.getData().getCards().get(0).getMblog().getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
