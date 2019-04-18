package com.blues.demo1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class HorizationRecyclerView extends RecyclerView {

    public HorizationRecyclerView(@NonNull Context context) {
        super(context);
    }

    public HorizationRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizationRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {

        ((ViewGroup)getParent()).requestDisallowInterceptTouchEvent(true);
        return true;
    }


}
