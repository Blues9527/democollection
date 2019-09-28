package com.example.endlessbanner;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BannerView bannerView;

    String url1 = "https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg";
    String url2 = "https://ws1.sinaimg.cn/large/0065oQSqly1g04lsmmadlj31221vowz7.jpg";
    String url3 = "https://ws1.sinaimg.cn/large/0065oQSqgy1fze94uew3jj30qo10cdka.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bannerView = findViewById(R.id.banner_view);

        final List<String> urls = new ArrayList<>();
        urls.add(url1);
        urls.add(url2);
        urls.add(url3);

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                bannerView.setPlayDelay(3000);
                bannerView.setAnimationDuration(1500);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, bannerView.dp2px(185));
                layoutParams.setMargins(bannerView.dp2px(15f), bannerView.dp2px(10f), bannerView.dp2px(15f), 0);
                bannerView.setAdapter(new BannerAdapter(MainActivity.this, urls, bannerView));
            }
        });


    }

}
