package com.blues.demo1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class VerticalRecyclerView extends RecyclerView {
    private float mFirstX, mLastX, mFirstY, mLastY;

    public VerticalRecyclerView(@NonNull Context context) {
        super(context);
    }

    public VerticalRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        float aX = e.getX(), aY = e.getY();
        boolean isIntercept = true;
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mFirstX = aX;
                mFirstY = aY;
                isIntercept = false;
                break;
            case MotionEvent.ACTION_MOVE:
                mLastX = aX;
                mLastY = aY;
                if (Math.abs(mLastX - mFirstX) > 20) {
                    isIntercept = false;
                } else if (Math.abs(mLastY - mFirstY) > 20) {
                    isIntercept = true;
                }
        }
        return isIntercept;
    }
}
