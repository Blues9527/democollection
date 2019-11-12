package com.example.logutilsdemo.logutils;

import android.text.TextUtils;
import android.util.Log;

/**
 * User : Blues
 * Date : 2019/4/29
 * Time : 11:59
 */

public class LogUtils {
    private static final String DEFAULT_TAG = "Blues";

    public static final int INFO = 0x001;
    public static final int DEBUG = 0x002;
    public static final int WARN = 0x003;
    public static final int ERROR = 0x004;
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

    //info----------------------------------------------------------------------------------------------
    public static void printInfoLog(String... strings) {
        printInfoLog(TextUtils.isEmpty(getGlobalTag()) ? DEFAULT_TAG : getGlobalTag(), strings);
    }

    public static void printInfoLog(String tag, String... strings) {
        if (isOpen) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                sb.append(" \n ").append(TextUtils.isEmpty(getGlobalTag()) ? DEFAULT_TAG : getGlobalTag()).append("     ||    第").append(i + 1).append("个参数，日志为：").append(strings[i]);
            }
            Log.i(tag, sb.toString());
        }
    }

    //debug----------------------------------------------------------------------------------------------
    public static void printDebugLog(String... strings) {
        printDebugLog(TextUtils.isEmpty(getGlobalTag()) ? DEFAULT_TAG : getGlobalTag(), strings);
    }

    public static void printDebugLog(String tag, String... strings) {
        if (isOpen) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                sb.append(" \n ").append(TextUtils.isEmpty(getGlobalTag()) ? DEFAULT_TAG : getGlobalTag()).append("     ||    第").append(i + 1).append("个参数，日志为：").append(strings[i]);
            }
            Log.d(tag, sb.toString());
        }

    }

    //warn----------------------------------------------------------------------------------------------
    public static void printWarnLog(String... strings) {
        printWarnLog(TextUtils.isEmpty(getGlobalTag()) ? DEFAULT_TAG : getGlobalTag(), strings);
    }

    private static void printWarnLog(String tag, String... strings) {
        if (isOpen) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                sb.append(" \n ").append(TextUtils.isEmpty(getGlobalTag()) ? DEFAULT_TAG : getGlobalTag()).append("     ||    第").append(i + 1).append("个参数，日志为：").append(strings[i]);
            }
            Log.w(tag, sb.toString());
        }
    }

    //error----------------------------------------------------------------------------------------------
    public static void printErrorLog(String... strings) {
        printErrorLog(TextUtils.isEmpty(getGlobalTag()) ? DEFAULT_TAG : getGlobalTag(), strings);
    }

    private static void printErrorLog(String tag, String... strings) {
        if (isOpen) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                sb.append(" \n ").append(TextUtils.isEmpty(getGlobalTag()) ? DEFAULT_TAG : getGlobalTag()).append("     ||    第").append(i + 1).append("个参数，日志为：").append(strings[i]);
            }
            Log.e(tag, sb.toString());
        }
    }

    //----------------------------------------------------------------------------------------------

    /**
     * 默认级别 DEBUG，默认 Tag DEFAULT_TAG
     *
     * @param strings 要输出的日志
     */
    public static void printLog(String... strings) {
        printLog(LogUtils.DEBUG, strings);
    }

    /**
     * 默认 Tag DEFAULT_TAG
     *
     * @param level   日志级别
     * @param strings 要输出的日志
     */
    public static void printLog(int level, String... strings) {
        printLog(TextUtils.isEmpty(getGlobalTag()) ? DEFAULT_TAG : getGlobalTag(), level, strings);
    }

    /**
     * 自定义级别和tag
     *
     * @param tag     自定义的过滤tag
     * @param level   自定义日志级别
     * @param strings 输出内容
     */
    public static void printLog(String tag, int level, String... strings) {
        switch (level) {
            case INFO:
                printInfoLog(tag, strings);
                break;
            case DEBUG:
                printDebugLog(tag, strings);
                break;
            case WARN:
                printWarnLog(tag, strings);
                break;
            case ERROR:
                printErrorLog(tag, strings);
                break;
        }
    }
}
