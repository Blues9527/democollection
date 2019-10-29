package com.example.customview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * User : Blues
 * Date : 2019/6/27
 * Time : 15:00
 */

public class CountDownView extends FrameLayout {

    public CountDownView(@NonNull Context context) {
        this(context, null);
    }

    public CountDownView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountDownView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout();
    }

    private void initLayout() {
        inflate(getContext(), R.layout.count_down_view, this);
        TextView textView = findViewById(R.id.cdb_tv);
        ProgressBar clpb = findViewById(R.id.cdv_pgb);

        clpb.setProgress(80);
    }

}
