package com.example.animationdemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTest = findViewById(R.id.tv_test);

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f,0.5f,1f);
        valueAnimator.setDuration(1500);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.start();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Path path = new Path();
                path.moveTo(500, 0);
                ObjectAnimator animator = ObjectAnimator.ofFloat(tvTest, View.X, View.Y, path);
                animator.setDuration(5000);
                animator.start();

                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f,0.5f,1f);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        ActivityOptionsCompat.makeSceneTransitionAnimation()
                    }
                });
                valueAnimator.setDuration(1500);
                valueAnimator.setInterpolator(new BounceInterpolator());
                valueAnimator.start();
            }
        }, 3000);

    }
}
