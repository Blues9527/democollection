package com.example.cutscreen;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private LinearLayout fl_root;
    private CutDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.iv_show);
        fl_root = findViewById(R.id.fl_root);

        findViewById(R.id.click_to_cut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
                saveView(MainActivity.this, fl_root, "Blues");
            }
        });
    }

    /**
     * 获取和保存当前View的截图
     */
    public void saveView(final Activity activity, View view, String fileName) {
        fileName = fileName + ".png";
        boolean sdcardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        // 有存储才保存
        if (sdcardExist) {
            //1.获取屏幕
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache(true);
            view.setBackgroundColor(Color.WHITE);

            Bitmap screenShot = Bitmap.createBitmap(view.getDrawingCache());
            view.setDrawingCacheEnabled(false);
            view.destroyDrawingCache();

            dialog = new CutDialog(activity, screenShot, new CutDialog.OnScreenShotListener() {
                @Override
                public void onScreenShotFinished() {
                    Toast.makeText(activity, "截屏弹窗后弹出toast", Toast.LENGTH_SHORT).show();
                }
            });
            dialog.show();

            //2.保存Bitmap，默认放到系统相册路径中去
            String savePath = Environment.getExternalStorageDirectory() + File.separator + "DCIM" + File.separator;

            try {
                File path = new File(savePath);
                // 文件
                String filepath = savePath + File.separator + fileName;
                File file = new File(filepath);
                if (!path.exists()) {
                    path.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileOutputStream fos = null;
                fos = new FileOutputStream(file);

                if (null != fos) {
                    screenShot.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    fos.flush();
                    fos.close();

                    String screenTips = "账号已截图并保存至设备图库！";
                    Toast.makeText(activity, screenTips, Toast.LENGTH_SHORT).show();
                }

                //发送广播更新图库
                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri uri = Uri.fromFile(file);
                intent.setData(uri);
//                context.sendBroadcast(intent);
                activity.sendBroadcast(intent);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("账号截图异常 --> fileName --> " + fileName + " exception --> " + e.toString());
            }
        } else {
            System.out.println("设备没存储卡，账号截图无法保存 --> fileName --> " + fileName);
        }
    }
}
