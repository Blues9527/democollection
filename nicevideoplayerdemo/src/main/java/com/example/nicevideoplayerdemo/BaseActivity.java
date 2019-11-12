package com.example.nicevideoplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

/**
 * User : Blues
 * Date : 2019/3/5
 * Time : 14:59
 * Email : huajianlan@rastar.com
 */

public abstract class BaseActivity extends AppCompatActivity {

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
