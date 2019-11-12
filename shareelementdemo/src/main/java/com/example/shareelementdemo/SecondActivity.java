package com.example.shareelementdemo;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * User : Blues
 * Date : 2019/9/6
 * Time : 16:15
 */

public class SecondActivity extends AppCompatActivity {

    private ImageView ivSecond;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ivSecond = findViewById(R.id.iv_second);


        // 设置WindowTransition,除指定的ShareElement外，其它所有View都会执行这个Transition动画
//        getWindow().setEnterTransition(new Slide(Gravity.TOP));
//        getWindow().setExitTransition(new Slide(Gravity.BOTTOM));

        // 设置ShareElementTransition,指定的ShareElement会执行这个Transition动画
//        TransitionSet transitionSet = new TransitionSet();
//        transitionSet.addTransition(new ChangeBounds());
//        transitionSet.addTransition(new ChangeTransform());
//        transitionSet.addTarget(ivSecond);
//        getWindow().setSharedElementEnterTransition(transitionSet);
//        getWindow().setSharedElementExitTransition(transitionSet);
//        getWindow().setSharedElementReenterTransition(transitionSet);
//        getWindow().setSharedElementReturnTransition(transitionSet);
//        getWindow().setSharedElementsUseOverlay(true);
//        getWindow().setAllowEnterTransitionOverlap(true);
//        getWindow().setAllowReturnTransitionOverlap(true);
    }
}
