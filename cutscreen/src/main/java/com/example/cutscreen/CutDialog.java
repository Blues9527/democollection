package com.example.cutscreen;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * User : Blues
 * Date : 2019/5/9
 * Time : 11:57
 */

public class CutDialog extends Dialog {

    private OnScreenShotListener mListener;
    private Context mContext;
    private ImageView ivImage;
    private Bitmap mBitmap;

    public CutDialog(Context context, Bitmap bitmap, OnScreenShotListener listener) {
        super(context);
        this.mContext = context;
        this.mBitmap = bitmap;
        this.mListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_cutscreen);
        ivImage = findViewById(R.id.iv_image);

        ivImage.setImageBitmap(mBitmap);

        setWindowAttr();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, 2000);
    }

    private void setWindowAttr() {
        Window window = this.getWindow();

        window.setBackgroundDrawableResource(android.R.color.transparent);

        WindowManager m = window.getWindowManager();
        // 获取屏幕宽、高用
        Display d = m.getDefaultDisplay();
        // 获取对话框当前的参数值
        WindowManager.LayoutParams p = window.getAttributes();
        // 高度设置为屏幕的0.5
        p.height = (int) (d.getHeight() * 0.5);
        // 高度设置为屏幕的0.5
        p.width = (int) (d.getWidth() * 0.5);
        //设置弹出框位置
        p.gravity = Gravity.CENTER;

        window.setAttributes(p);

        window.setWindowAnimations(R.style.ZoomAnim);

    }

    @Override
    public void dismiss() {
        super.dismiss();
        mListener.onScreenShotFinished();
    }

    public interface OnScreenShotListener {
        void onScreenShotFinished();
    }
}
