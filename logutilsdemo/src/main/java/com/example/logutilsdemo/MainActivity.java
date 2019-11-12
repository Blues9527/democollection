package com.example.logutilsdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.logutilsdemo.logutils.LogUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtils.printLog(LogUtils.DEBUG, "哈哈", "哈哈哈哈", "哈哈哈哈哈哈", "哈哈哈哈哈哈哈哈", "哈哈哈哈哈哈哈哈哈哈");

        LogUtils.printLog(LogUtils.DEBUG, "哈哈", "哈哈哈哈", "哈哈哈哈哈哈", "哈哈哈哈哈哈哈哈", "哈哈哈哈哈哈哈哈哈哈");
    }
}
