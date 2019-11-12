package com.example.lrucachedemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String url = "https://www.baidu.com/img/xinshouye_46cc6be3783724af1729ba51cfcde494.png";
    private LruCacheUtils utils;
    private static final String TAG = "Blues";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ImageView iv1 = findViewById(R.id.imageview1);
        final ImageView iv2 = findViewById(R.id.imageview2);

        utils = new LruCacheUtils();

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "从网络中获取图片");
                new DownloadImageThread(MainActivity.this, utils, iv1, url).start();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != utils.getBitmapFormLruCache(url)) {
                    Log.i(TAG, "从缓存中获取图片");
                    iv2.setImageBitmap(utils.getBitmapFormLruCache(url));
                } else {
                    Toast.makeText(MainActivity.this, "缓存中没有图片", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (utils.getBitmapFormLruCache(url) != null) {
            utils.removeBitmapFromLruCache(url);
//            utils.getBitmapFormLruCache(url).recycle();
        }
    }
}
