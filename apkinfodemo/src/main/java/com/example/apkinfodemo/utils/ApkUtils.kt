package com.example.apkinfodemo.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import java.io.File

/**
 * User : Blues
 * Date : 2019/10/18
 * Time : 11:24
 */

class ApkUtils {
    companion object {
        fun installApk(ctx: Context, path: String) {
            ctx.startActivity(Intent(Intent.ACTION_VIEW).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                setDataAndType(Uri.fromFile(File(path)), "application/vnd.android.package-archive")
            })
        }

        fun uninstallApk(ctx: Context, packageName: String) {
            ctx.startActivity(Intent(Intent.ACTION_DELETE).apply {
                data = Uri.parse("package:$packageName")
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            })
        }

        fun launchApp(ctx: Context, packageName: String) {
            ctx.startActivity(ctx.packageManager.getLaunchIntentForPackage(packageName))
        }

        fun isInstallApp(ctx: Context, packageName: String): Boolean {
            return ctx.packageManager.getLaunchIntentForPackage(packageName) != null
        }
    }
}