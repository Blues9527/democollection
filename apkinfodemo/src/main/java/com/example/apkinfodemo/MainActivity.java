package com.example.apkinfodemo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.example.apkinfodemo.utils.ApkInfoUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Blues", "version_name:" + ApkInfoUtils.getApkVersionName(this));
        Log.i("Blues", "package_name:" + ApkInfoUtils.getPackageName(this));
        Log.i("Blues", "version_code:" + ApkInfoUtils.getApkVersionCode(this));
        Log.i("Blues", "long_code:" + ApkInfoUtils.getLongVersionCode(this));
    }
}
