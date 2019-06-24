package com.example.ijkplayerdemo;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

/**
 * User : Blues
 * Date : 2019/5/20
 * Time : 10:38
 */

public class CustomPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {

    private MediaPlayer mPlayer;
    private boolean prepared;

    private void init() {
        if (mPlayer == null) {
            mPlayer = new MediaPlayer();
            mPlayer.setOnPreparedListener(this);
            mPlayer.setOnErrorListener(this);
            mPlayer.setOnCompletionListener(this);
        }
    }


    @Override
    public void onCompletion(MediaPlayer mp) {
        prepared = false;
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        prepared = false;
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        prepared = true;
        start();
    }

    public void start() {
        if (mPlayer != null && prepared) {
            mPlayer.start();
        }
    }

    public void pause() {
        if (mPlayer != null) {
            mPlayer.pause();
        }
    }

    public void stop() {
        if (mPlayer != null) {
            mPlayer.stop();
        }
    }

    public void play(Context context, Uri uri) {
        prepared = false;
        init();

        try {
            mPlayer.reset();
            mPlayer.setDataSource(context, uri);
            mPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void seekTo(int position) {
        if (mPlayer != null) {
            mPlayer.seekTo(position);
        }
    }

    public void release() {
        if (mPlayer != null) {
            prepared = false;
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
    }
}
