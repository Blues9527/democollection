package com.example.nicevideoplayerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

public class MainActivity extends AppCompatActivity {

    private NiceVideoPlayer nvpGameVideo;
    private String videoUrl = "http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/09/1214846004_5b63fc88ca6648fdb65485c661827bf1_hd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a046360fc72b29635ea0d4a381f5dcc3e45e822117d840132767793f969aceceae3797b91e7852e20cf0d9e123d607c272f0db8ae77e29788836745b7125f174b3914";
//    private String videoUrl = "http://www.pearvideo.com/video_1554457";

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
//        nvpGameVideo.post(new Runnable() {
//            @Override
//            public void run() {
//                if (nvpGameVideo != null) {
//                    nvpGameVideo.continueFromLastPosition(false);
//                    if (nvpGameVideo.isIdle()) {
//                        nvpGameVideo.start();
//                    }
//                }
//            }
//        });
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
