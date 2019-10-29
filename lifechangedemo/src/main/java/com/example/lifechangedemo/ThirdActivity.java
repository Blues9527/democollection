package com.example.lifechangedemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * User : Blues
 * Date : 2019/8/1
 * Time : 16:51
 */

public class ThirdActivity extends Activity {

    private static final String TAG = "Blues";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Log.i(TAG, "ThirdActivity  --  onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "ThirdActivity  --  onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "ThirdActivity  --  onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "ThirdActivity  --  onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "ThirdActivity  --  onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "ThirdActivity  --  onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "ThirdActivity  --  onDestroy()");
    }
}
