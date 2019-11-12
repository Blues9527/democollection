package com.example.danmu;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.BounceInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * User : Blues
 * Date : 2019/7/15
 * Time : 10:22
 */

public class DanMuView extends View {

    private AvatarView avatarView;
    private TextView tvUserName;
    private TextView tvDanMuContent;
    private LinearLayout llDanMu;

    public DanMuView(Context context) {
        this(context, null);
    }

    public DanMuView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DanMuView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
//        attachToActivity((Activity) context);
    }

    private void initView(Context context) {
        View container = LayoutInflater.from(context).inflate(R.layout.view_danmu, null);
        avatarView = container.findViewById(R.id.user_avatar);
        tvUserName = container.findViewById(R.id.user_name);
        tvDanMuContent = container.findViewById(R.id.danmu_content);
        llDanMu = container.findViewById(R.id.danmu_layout);
    }


    public void attachToActivity(Activity act) {
        ViewGroup rootView = (ViewGroup) act.findViewById(Window.ID_ANDROID_CONTENT);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rootView.removeAllViews();
        rootView.addView(this, params);

        startPlay(llDanMu);
    }

    private void startPlay(final View view) {
//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, height / 2);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int curValue = (int) animation.getAnimatedValue();
//                view.layout(view.getLeft(), curValue, view.getRight(), curValue + view.getHeight());
//            }
//        });
//        valueAnimator.setDuration(1000);
//        valueAnimator.setInterpolator(new BounceInterpolator());
//        valueAnimator.start();

        ValueAnimator va = ValueAnimator.ofFloat(0.0f, 1f).setDuration(2500);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedFraction = (int) animation.getAnimatedFraction();
                view.layout(view.getLeft(), animatedFraction, view.getRight(), animatedFraction + view.getHeight());
            }
        });
        va.setInterpolator(new BounceInterpolator());
        va.start();

    }

}
