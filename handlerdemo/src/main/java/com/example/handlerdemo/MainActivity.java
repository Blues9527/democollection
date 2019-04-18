package com.example.handlerdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {

    private static int NBA = 0x00;
    private static int CBA = 0x01;

    private UIHandler mHandler;
    private TextView tv_content;
    private Button btn_click;
    private Button btn_click_again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_click = findViewById(R.id.btn_click);
        btn_click_again = findViewById(R.id.btn_click_again);
        tv_content = findViewById(R.id.tv_content);

        mHandler = new UIHandler();
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Looper.prepare();
                        Message msg = Message.obtain();
                        msg.what = NBA;
                        msg.obj = "nba";
                        mHandler.sendMessage(msg);
                    }
                }).start();
            }
        });

        btn_click_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Looper.prepare();
                        Message msg = Message.obtain();
                        msg.what = CBA;
                        msg.obj = "cba";
                        mHandler.sendMessage(msg);
                    }
                }).start();
            }
        });
    }

    class UIHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x00:
                    tv_content.setText((String) msg.obj);
                    break;
                case 0x01:
                    tv_content.setText((String) msg.obj);
                    break;
            }
        }
    }
}
