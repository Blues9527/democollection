package com.example.hyfdemo;

import android.util.Log;

/**
 * User : Blues
 * Date : 2019/6/24
 * Time : 10:24
 */

public class Test2 {
    public static final String TAG = "Blues";

    public Test2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("Blues", "this is test2");
            }
        }).start();
    }


}
