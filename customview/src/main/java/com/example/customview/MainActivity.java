package com.example.customview;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private CustomProgressBar cpb;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cpb = findViewById(R.id.cpb);
        countDownTimer = new CountDownTimerImpl(6000, 1000);
        countDownTimer.start();
    }

    private class CountDownTimerImpl extends CountDownTimer {

        private long millisInFuture;

        private CountDownTimerImpl(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            this.millisInFuture = millisInFuture;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            cpb.setCountDownText((int) (millisUntilFinished / 1000));
            Log.i("Blues", "percent1 ==> " + (float) (millisUntilFinished - 1000) / millisInFuture * 100);
            cpb.setProgress((float) (millisUntilFinished - 1000) / millisInFuture * 100);
        }

        @Override
        public void onFinish() {
//            cpb.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onResume() {
        if (countDownTimer != null) {
            countDownTimer.start();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onDestroy();
        System.gc();
    }
}
