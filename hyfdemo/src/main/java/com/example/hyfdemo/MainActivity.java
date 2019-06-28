package com.example.hyfdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Blues";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Test test = new Test.Builder()
                .params1("str1")
                .params2("str2")
                .build();

//        Log.i(TAG, test.toString());

        Test1 t1 = new Test1();
        Test2 t2 = new Test2();

        if (t1 instanceof TestInterface) {
            Log.i("Blues", "t1 is right");
        }
        if (t2 instanceof TestInterface) {
            Log.i("Blues", "t2 is right");
        }
    }
}
