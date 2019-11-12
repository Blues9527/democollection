package com.example.customview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

//    private CustomProgressBar cpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExplosionField explosionField = new ExplosionField(MainActivity.this, new FallingParticleFactory());
        explosionField.addListener(findViewById(R.id.iv_test));

//        cpb = findViewById(R.id.cpb);
//        cpb.setCountDownTimerCallBack(new CustomProgressBar.CountDownTimerCallBack() {
//            @Override
//            public void onFinish() {
//                ExplosionField explosionField = new ExplosionField(MainActivity.this, new FallingParticleFactory());
//                explosionField.addListener(cpb);
////                cpb.setVisibility(View.GONE);
//            }
//        });
    }

    @Override
    protected void onResume() {
//        cpb.countDownResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
//        cpb.countDownCancel();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
//        cpb.countDownCancel();
        super.onDestroy();
//        System.gc();
    }
}
