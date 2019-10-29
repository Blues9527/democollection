package com.example.ijkplayerdemo;

import android.os.Bundle;
import android.view.View;

import com.shuyu.gsyvideoplayer.GSYVideoADManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

//    private FRVideoPlayer mPlayer;
    private String videoUrl = "http://www.pearvideo.com/video_1554457";

    private StandardGSYVideoPlayer iPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mPlayer = findViewById(R.id.frv_video);
//
//        FRVideoPlayerController controller = new FRVideoPlayerController(this);
//        mPlayer.setController(controller);
//        mPlayer.setUp(videoUrl, null);


        iPlayer = findViewById(R.id.gsy_video);
        iPlayer.setUpLazy(videoUrl, true, null, null, "标题");
        iPlayer.getTitleTextView().setVisibility(View.GONE);
        iPlayer.getBackButton().setVisibility(View.GONE);
        iPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iPlayer.startWindowFullscreen(MainActivity.this, false, true);
            }
        });
        iPlayer.setReleaseWhenLossAudio(false);
        iPlayer.setAutoFullWithSize(true);
        iPlayer.setShowFullAnimation(true);
        iPlayer.setIsTouchWiget(false);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        FRVideoPlayerManager.instance().releaseVideoPlayer();
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
//        if (FRVideoPlayerManager.instance().onBackPressed()) return;
        if (GSYVideoADManager.backFromWindowFull(this)) return;
        super.onBackPressed();
    }

}
