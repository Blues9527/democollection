package com.example.nicevideoplayerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

public class MainActivity extends AppCompatActivity {

    private NiceVideoPlayer nvpGameVideo;
    private String videoUrl = "http://www.pearvideo.com/video_1554457";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nvpGameVideo = findViewById(R.id.nvp_game_video);
        nvpGameVideo.setPlayerType(NiceVideoPlayer.TYPE_NATIVE);
        nvpGameVideo.setBackgroundResource(R.drawable.shape_background_gamevideo_default);
        nvpGameVideo.setUp(videoUrl, null);
        TxVideoPlayerController controller = new TxVideoPlayerController(this);
        controller.setTitle("8岁拳击小魔女!一拳打到哥哥脑震荡");
        nvpGameVideo.setController(controller);

        //自动播放
        nvpGameVideo.post(new Runnable() {
            @Override
            public void run() {
                if (nvpGameVideo != null) {
                    nvpGameVideo.continueFromLastPosition(false);
                    if (nvpGameVideo.isIdle()) {
                        nvpGameVideo.start();
                    }
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }

}
