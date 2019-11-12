package com.example.valueanimator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.BounceInterpolator;

import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tryIt(final View view) {
//
//        WindowManager wm = getWindowManager();
//        DisplayMetrics dm = new DisplayMetrics();
//        wm.getDefaultDisplay().getMetrics(dm);
//        int width = dm.widthPixels;
//
//        int height = dm.heightPixels;
//
//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, height / 2);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int curValue = (int) animation.getAnimatedValue();
//                view.layout(view.getLeft(), curValue, view.getRight(), curValue + view.getHeight());
//            }
//        });
//        valueAnimator.setDuration(1000);
//        valueAnimator.setInterpolator(new BounceInterpolator());
//        valueAnimator.start();

        WindowManager wm = getWindowManager();
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        Path path = new Path();
        path.moveTo((float) width / 2, 0);
//        path.lineTo(0, (height-view.getHeight())/2);
//        path.lineTo(width - view.getRight(), height / 2 - view.getHeight());
        path.cubicTo(0,0,width/2,height/2,(height-width)/2,0);
//        path.quadTo(50, 500, 300, 700);
//        path.cubicTo(600, 600, 500, 250, 50, 800);
//        path.quadTo(500, 0, 0, 0);
//        path.close();

        ObjectAnimator animator = ObjectAnimator.ofFloat(view, View.X, View.Y, path);
        animator.setDuration(5000);
        animator.start();



    }
}
