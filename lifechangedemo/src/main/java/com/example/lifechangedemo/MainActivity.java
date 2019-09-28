package com.example.lifechangedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    private static final String TAG = "Blues";
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "MainActivity  --  onCreate()");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TestDialog(MainActivity.this).show();
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        wv = findViewById(R.id.webview);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewClient webViewClient = new WebViewClient();
                WebChromeClient webChromeClient = new WebChromeClient();

                wv.setWebViewClient(webViewClient);
                wv.setWebChromeClient(webChromeClient);
                wv.loadUrl("https://www.baidu.com");
            }
        });


    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        Log.i(TAG, "onRestoreInstanceState");
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "MainActivity  --  onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "MainActivity  --  onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "MainActivity  --  onPause()");
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        Log.i(TAG, "onSaveInstanceState");
//    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "MainActivity  --  onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "MainActivity  --  onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "MainActivity  --  onDestroy()");
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        Log.i(TAG, "onConfigurationChanged");
//    }

    public void ClickToThirdActivity(View view) {
        startActivity(new Intent(this, ThirdActivity.class));
    }
}
