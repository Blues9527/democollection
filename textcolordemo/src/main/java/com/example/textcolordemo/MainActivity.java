package com.example.textcolordemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextClockView text_clock;
    private TextClockExtendView text_clock_extend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_clock = findViewById(R.id.text_clock);
        text_clock_extend = findViewById(R.id.text_clock_extend);

        text_clock.startTimerSafely();
        text_clock_extend.startTimerSafely();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        text_clock.release();
        text_clock_extend.release();
    }
}
