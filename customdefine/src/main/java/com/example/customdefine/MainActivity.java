package com.example.customdefine;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.IntDef;
import androidx.annotation.Nullable;
import androidx.core.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int ACTION_START = 200;
    private static final int ACTION_DOING = 500;
    private static final int ACTION_END = 999;

    private static final int SLEEP_TIME = 2500;

    @IntDef({ACTION_START, ACTION_DOING, ACTION_END})
    @Retention(RetentionPolicy.SOURCE)
    @interface states {
    }

    private @states
    int mState;

    public void setState(@states int state) {
        this.mState = state;
    }

    @states
    public int getState() {
        return this.mState;
    }

    private ViewPager viewPager;
    private ImagePagerAdapter mAdapter;
    private List<String> mDatas;
    private Context mContext;
    private int mCurrentPage = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_main2);
        setState(ACTION_START);
        initView();
    }

    private void initView() {
        mDatas = new ArrayList<>();
        mDatas.add("https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg");
        mDatas.add("https://ws1.sinaimg.cn/large/0065oQSqly1g04lsmmadlj31221vowz7.jpg");
        mDatas.add("https://ws1.sinaimg.cn/large/0065oQSqgy1fze94uew3jj30qo10cdka.jpg");
        mAdapter = new ImagePagerAdapter(mContext, mDatas);
        viewPager = findViewById(R.id.vp);
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(mCurrentPage);
        if (getState() == ACTION_START) {
            setState(ACTION_DOING);
            startPlay(mCurrentPage + 1, SLEEP_TIME);
        }

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                    if ( position < mDatas.size()) {
                        startPlay(position + 1, SLEEP_TIME);
                        Log.i("Blues", "==>1");
                    }
                    if (position == mDatas.size() - 1) {
                        startPlay(0, SLEEP_TIME);
                        Log.i("Blues", "==>2");
                    }
                }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void startPlay(final int currentItem, long mills) {
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem(currentItem);
            }
        }, mills);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setState(ACTION_END);
    }

    @Override
    protected void onPause() {
        super.onPause();
        setState(ACTION_END);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setState(ACTION_START);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setState(ACTION_START);
    }
}
