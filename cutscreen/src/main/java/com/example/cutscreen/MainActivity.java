package com.example.cutscreen;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Bitmap bitmap;
    private WebView wv;
    private ImageView imageView;
    private Button btnCut, btnshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv = findViewById(R.id.wv);
        imageView = findViewById(R.id.iv_show);
        imageView.setVisibility(View.GONE);
        wv.loadUrl("https://www.baidu.com/");

        btnCut = findViewById(R.id.click_to_cut);
        btnCut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getWindow().getDecorView().getRootView().findViewById(R.id.wv);
                bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                view.draw(canvas);
//                View decorView = getWindow().getDecorView().getRootView().findViewById(R.id.wv);
//                decorView.setDrawingCacheEnabled(true);
//                decorView.buildDrawingCache();
//                Rect rect = new Rect();
//                decorView.getWindowVisibleDisplayFrame(rect);
//                int i = rect.top;
//                WindowManager windowManager = getWindowManager();
//                DisplayMetrics displayMetrics = new DisplayMetrics();
//                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
//                bitmap = Bitmap.createBitmap(decorView.getDrawingCache(), 0, i, displayMetrics.widthPixels, displayMetrics.heightPixels);
//                decorView.destroyDrawingCache();
//                decorView.setDrawingCacheEnabled(false);
            }
        });

        btnshow = findViewById(R.id.clcik_to_intent);
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageBitmap(bitmap);
                btnCut.setVisibility(View.GONE);
                btnshow.setVisibility(View.GONE);
                wv.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
            }
        });
    }
}
