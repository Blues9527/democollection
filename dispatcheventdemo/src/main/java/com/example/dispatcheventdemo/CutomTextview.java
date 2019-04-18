package com.example.dispatcheventdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class CutomTextview extends android.support.v7.widget.AppCompatTextView {

    public CutomTextview(Context context) {
        this(context, null);
    }

    public CutomTextview(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CutomTextview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.i("Blues", "view -> on Touch Event");
        }
//        getParent().requestDisallowInterceptTouchEvent(false);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.i("Blues", "view -> dispatch Touch Event");
        }

        return super.dispatchTouchEvent(event);
    }
}
