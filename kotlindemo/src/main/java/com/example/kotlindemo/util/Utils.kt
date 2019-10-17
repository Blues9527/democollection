package com.example.kotlindemo.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * User : Blues
 * Date : 2019/10/12
 * Time : 10:15
 */

class Utils private constructor() {

    companion object {

        /**
         * 将dp转换成px
         */
        fun dp2px(dp: Float, mContext: Context): Float {
            return dp * mContext.resources.displayMetrics.density + 0.5F
        }

        /**
         * 将px转换成dp
         */
        fun px2dp(px: Float, mContext: Context): Float {
            return px / mContext.resources.displayMetrics.density + 0.5F
        }

        /**
         * 将sp转成px
         */
        fun sp2px(sp: Float, mContext: Context): Float {
            return sp * mContext.resources.displayMetrics.scaledDensity + 0.5F
        }

        /**
         * 将px转成sp
         */
        fun px2sp(px: Float, mContext: Context): Float {
            return px / mContext.resources.displayMetrics.scaledDensity + 0.5F
        }

        /**
         * 获取屏幕宽度
         */
        fun screenWidth(mContext: Context): Int {
            val wm = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()
            wm.defaultDisplay.getMetrics(dm)
            return dm.widthPixels
        }

        /**
         * 获取屏幕高度
         */
        fun screenHeight(mContext: Context): Int {
            val wm = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()
            wm.defaultDisplay.getMetrics(dm)
            return dm.heightPixels
        }

        /**
         * 网络连接
         */
        fun networkConnected(mContext: Context): Boolean {
            return getActiveNetworkInfo(mContext) != null && getActiveNetworkInfo(mContext)!!.isConnected
        }

        /**
         * 必须要有 ACCESS_NETWORK_STATE 权限
         */
        private fun getActiveNetworkInfo(mContext: Context): NetworkInfo? {
            return (mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
        }


    }
}