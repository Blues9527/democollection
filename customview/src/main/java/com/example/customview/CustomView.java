package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * User : Blues
 * Date : 2019/3/13
 * Time : 11:28
 */

public class CustomView extends View {

    private Paint mPaint;
    private RectF oval;
    private float sweepAngle;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.percent);
        sweepAngle = array.getFloat(R.styleable.percent_sweep_angle, 0f);
        Log.i("Blues", sweepAngle + "");
        array.recycle();
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);//抗锯齿
        oval = new RectF();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.i("Blues", "onMeasure");

        Log.i("Blues", "widthMode: " + widthMode);
        Log.i("Blues", "widthSize: " + widthSize);
        Log.i("Blues", "heightMode: " + heightMode);
        Log.i("Blues", "heightSize: " + heightSize);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i("Blues", "onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i("Blues", "onDraw");
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);//填充加描边
        int width = getWidth();
        int height = getHeight();
        Log.i("Blues", "width: " + width);
        Log.i("Blues", "height: " + height);

        float radius = width / 4;
        canvas.drawCircle(width / 2, width / 2, radius, mPaint);
        mPaint.setColor(Color.BLUE);
        oval.set(width / 2 - radius, width / 2 - radius, width / 2 + radius, width / 2 + radius);
        canvas.drawArc(oval, 270, sweepAngle, true, mPaint);
    }
}
