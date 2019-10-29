package com.example.customview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

import java.util.Random;


/**
 * 1.生成一张与原来一样的图片
 * 2.添加一个全屏动画显示场地
 * 3.动画执行
 * 3.1 震动
 * 3.2 缩小透明
 * 3.3 粒子爆炸
 * 3.4 view恢复原状
 */
public class Utils {

    private static final Canvas CANVAS = new Canvas();

    public static final Random RANDOM = new Random();


    public static Bitmap createBitmapFromView(View v) {

        //清楚焦点，使view恢复原样
        v.clearFocus();
        Bitmap bitmap = createBitmapSafely(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888, 1);

        if (bitmap != null) {
            synchronized (CANVAS) {
                CANVAS.setBitmap(bitmap);
                v.draw(CANVAS);
                CANVAS.setBitmap(null);
            }
        }

        return bitmap;
    }

    private static Bitmap createBitmapSafely(int width, int height, Bitmap.Config config, int retryCount) {

        try {
            return Bitmap.createBitmap(width, height, config);

        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            if (retryCount > 0) {
                System.gc();
                return createBitmapSafely(width, height, config, retryCount - 1);
            }
        }
        return null;
    }
}
