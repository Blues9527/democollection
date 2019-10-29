package com.example.mediaplayerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.shuyu.gsyvideoplayer.GSYVideoADManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

public class MainActivity extends Activity {

    private String videoUrl = "http://www.pearvideo.com/video_1554457";//这条url非食品连接。。。。
     String source1 = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";

    private StandardGSYVideoPlayer iPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iPlayer = findViewById(R.id.gsy_video);
        iPlayer.setUp(source1, true, null,  "标题");
        iPlayer.getTitleTextView().setVisibility(View.VISIBLE);
        iPlayer.getBackButton().setVisibility(View.VISIBLE);
        iPlayer.getFullscreenButton().setOnClickListener(v -> iPlayer.startWindowFullscreen(MainActivity.this, false, true));
        iPlayer.setReleaseWhenLossAudio(false);
        iPlayer.setAutoFullWithSize(true);
        iPlayer.setShowFullAnimation(true);
        iPlayer.setIsTouchWiget(false);
    }

    @Override
    protected void onStop() {
        super.onStop();
        GSYVideoADManager.releaseAllVideos();
    }

    @Override
    protected void onPause() {
        super.onPause();
        GSYVideoADManager.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        GSYVideoADManager.onResume();
    }

    @Override
    public void onBackPressed() {
        if (GSYVideoADManager.backFromWindowFull(this)) return;
        super.onBackPressed();
    }
}
