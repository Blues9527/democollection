package com.example.hupureplydemo;

import android.content.Context;
import androidx.annotation.NonNull;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * User : Blues
 * Date : 2019/9/17
 * Time : 17:13
 */

public class CLayout extends LinearLayout {

    private LinearLayout llDrag;
    private ViewDragHelper dragHelper;
    int dragBtnHeight;
    private int autoBackViewOriginLeft, autoBackViewOriginTop;

    public CLayout(Context context) {
        this(context, null);
    }

    public CLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.layout_dragview, this);

        dragHelper = ViewDragHelper.create(this, 1f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return child == llDrag;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                // 底部边界
                return top < 0 ? 0 : top;
            }

            @Override
            public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
                return 0;
            }

            @Override
            public int getViewVerticalDragRange(View child) {
                return getMeasuredHeight() - child.getMeasuredHeight();
            }

            @Override
            public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
                if (releasedChild == llDrag) {
                    dragHelper.settleCapturedViewAt(autoBackViewOriginLeft, autoBackViewOriginTop);
                    invalidate();
                }
            }
        });
        // 设置左边缘可以被Drag
        dragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_LEFT);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        llDrag = findViewById(R.id.ll_drag);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return dragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        dragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        dragBtnHeight = llDrag.getMeasuredHeight();
    }

    @Override
    public void computeScroll() {
        if (dragHelper.continueSettling(true)) {
            invalidate();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        autoBackViewOriginLeft = llDrag.getLeft();
        autoBackViewOriginTop = llDrag.getTop();
    }
}
