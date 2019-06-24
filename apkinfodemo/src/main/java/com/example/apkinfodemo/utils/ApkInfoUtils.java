package com.example.apkinfodemo.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.Objects;

/**
 * User : Blues
 * Date : 2019/4/22
 * Time : 10:50
 */

public class ApkInfoUtils {


    public static String getPackageName(Context context) {

        return context.getPackageName();
    }

    public static PackageInfo getPackageInfo(Context context) {

        try {
            return context.getPackageManager().getPackageInfo(getPackageName(context), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getApkVersionCode(Context context) {

        return Objects.requireNonNull(getPackageInfo(context)).versionCode;
    }

    @SuppressLint("NewApi")
    public static long getLongVersionCode(Context context) {
        return Objects.requireNonNull(getPackageInfo(context)).getLongVersionCode();
    }

    public static String getApkVersionName(Context context) {

        return Objects.requireNonNull(getPackageInfo(context)).versionName;
    }


}
