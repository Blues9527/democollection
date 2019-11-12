package com.example.lrucachedemo;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import android.support.v4.util.LruCache;
import android.util.Log;

/**
 * User : Blues
 * Date : 2019/4/10
 * Time : 10:59
 */

public class LruCacheUtils {
    private final String TAG = getClass().getSimpleName();
    private LruCache<String, Bitmap> lruCache;

    public LruCacheUtils() {
        int cacheMemory = (int) (Runtime.getRuntime().maxMemory() / 8);
        lruCache = new LruCache<String, Bitmap>(cacheMemory) {
            @Override
            protected int sizeOf(@NonNull String key, @NonNull Bitmap value) {
                return value.getByteCount() / 1024;
            }
        };
    }

    /**
     * 将bitmap添加到lrucache
     *
     * @param key
     * @param bitmap
     */
    public void addBitmapToLruCache(String key, Bitmap bitmap) {
        if (getBitmapFormLruCache(key) == null) {
            Log.d(TAG, "add bitmap to lrucache , key is " + key);
            lruCache.put(key, bitmap);
        } else {
            Log.d(TAG, "bitmap cache already exist!");
        }
    }

    /**
     * 从lrucache里移除bitmap
     *
     * @param key
     */
    public void removeBitmapFromLruCache(String key) {
        if (null != key) {
            lruCache.remove(key);
        }
    }

    /**
     * 从lrucache里取出bitmap
     *
     * @param key
     * @return
     */
    public Bitmap getBitmapFormLruCache(String key) {
        if (null != key) {
            return lruCache.get(key);
        }
        return null;
    }
}
