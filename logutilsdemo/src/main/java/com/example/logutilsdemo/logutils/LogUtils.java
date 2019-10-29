package com.example.logutilsdemo.logutils;

import android.text.TextUtils;
import android.util.Log;
南头站
/**
 * User : Blues
 * Date : 2019/4/29
 * Time : 11:59
 */

public class LogUtils {
    private static final String DEFAULT_TAG = "Blues";

    private static final int INFO = 0x001;
    private static final int DEBUG = 0x002;
    private static final int WARN = 0x003;
    private static final int ERROR = 0x004;
//    private static final int FATAL = 0x005;

    private static boolean isOpen = true;
    private static String globalTag = "";

    public static void setDebugable(boolean isDebugable) {
        isOpen = isDebugable;
    }

    public static void setGlobalTag(String tag) {
        globalTag = tag;
    }

    public static String getGlobalTag() {
        return globalTag;
    }

    public static void printInfoLog(String... strings) {
        if (isOpen)
            if (TextUtils.isEmpty(getGlobalTag()))
                printInfoLog(DEFAULT_TAG, strings);
            else
                printInfoLog(getGlobalTag(), strings);
    }

    public static void printInfoLog(String tag, String... strings) {
        if (isOpen)
            for (String str : strings)
                Log.i(tag, str);
    }

    public static void printDebugLog(String... strings) {
        if (isOpen)
            if (TextUtils.isEmpty(getGlobalTag()))
                printDebugLog(DEFAULT_TAG, strings);
            else
                printDebugLog(getGlobalTag(), strings);
    }

    public static void printDebugLog(String tag, String... strings) {
        if (isOpen)
            for (String str : strings)
                Log.d(tag, str);
    }

    public static void printWarnLog(String... strings) {
        if (isOpen)
            if (TextUtils.isEmpty(getGlobalTag()))
                printWarnLog(DEFAULT_TAG, strings);
            else
                printWarnLog(getGlobalTag(), strings);
    }

    private static void printWarnLog(String tag, String... strings) {
        if (isOpen)
            for (String str : strings)
                Log.w(tag, str);
    }

    private static void printErrorLog(String tag, String... strings) {
        if (isOpen)
            for (String str : strings) {
                Log.e(tag, str);
            }
    }

    public static void printErrorLog(String... strings) {
        if (isOpen)
            if (TextUtils.isEmpty(getGlobalTag()))
                printErrorLog(DEFAULT_TAG, strings);
            else
                printErrorLog(getGlobalTag(), strings);
    }

    public static void printLog(int level, String... strings) {
        if (isOpen)
            if (TextUtils.isEmpty(getGlobalTag()))
                printLog(level, DEFAULT_TAG, strings);
            else
                printLog(level, getGlobalTag(), strings);
    }

    public static void printLog(int level, String tag, String... strings) {
        if (isOpen)
            switch (level) {
                case INFO:
                    printInfoLog(tag, strings);
                case DEBUG:
                    printDebugLog(tag, strings);
                case WARN:
                    printWarnLog(tag, strings);
                case ERROR:
                    printErrorLog(tag, strings);
            }
    }
}
