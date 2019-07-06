package com.example.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CustomProgressBar cpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cpb = findViewById(R.id.cpb);
        cpb.setCountDownTimerCallBack(new CustomProgressBar.CountDownTimerCallBack() {
            @Override
            public void onFinish() {
                cpb.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onResume() {
        cpb.countDownResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        cpb.countDownCancel();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        cpb.countDownCancel();
        super.onDestroy();
        System.gc();
    }
}
