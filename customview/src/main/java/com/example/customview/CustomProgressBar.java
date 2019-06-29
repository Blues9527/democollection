package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


/**
 * User : Blues
 * Date : 2019/6/27
 * Time : 17:09
 */

public class CustomProgressBar extends View {

    //view的中心点X坐标
    private int centerX;

    //view中心点的Y坐标
    private int centerY;

    private int max = 100;

    private float progress = 0;

    private int radius = dp2px(15);

    //画笔
    private Paint mPaint;

    //进度颜色
    private int progressColor;

    //进度背景颜色
    private int progressBgColor;

    //倒计时颜色
    private int countDownTextColor;

    //是否显示倒计时
    private boolean showCountText;

    //倒计时字体大小
    private float countDownTextSize;

    //progress宽度
    private float strokeWidth;

    //倒计时
    private int countDownText;

    //形状,默认圆形
    private int progressShape;

    public CustomProgressBar(Context context) {
        this(context, null);
    }

    public CustomProgressBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
        //抗锯齿
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    private void initAttrs(Context context, AttributeSet attrs) {

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar);

        //是否显示倒数文字
        showCountText = ta.getBoolean(R.styleable.CustomProgressBar_showCountText, true);

        //倒计时
        countDownText = ta.getInt(R.styleable.CustomProgressBar_countDownTime, 6);

        //倒数字体默认20sp
        countDownTextSize = ta.getDimension(R.styleable.CustomProgressBar_countDownTextSize, 20);

        //倒计时颜色，默认黑色
        countDownTextColor = ta.getColor(R.styleable.CustomProgressBar_countDownTextColor, 0xff000000);

        //进度条宽度默认 5dp
        strokeWidth = ta.getFloat(R.styleable.CustomProgressBar_strokeWidth, 5);

        //进度条进度默认蓝色
        progressColor = ta.getColor(R.styleable.CustomProgressBar_progressColor, 0xff4b749d);

        //背景默认灰色
        progressBgColor = ta.getColor(R.styleable.CustomProgressBar_progressBgColor, 0xffededed);

        //默认圆形
        progressShape = ta.getInt(R.styleable.CustomProgressBar_mode, 1);

        ta.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {

        centerX = getWidth() / 2;
        centerY = getHeight() / 2;

        radius = centerX - dp2px(strokeWidth) / 2;

        if (progressShape == 0) {
            drawLinearProgressBar(canvas, mPaint);
        } else {
            drawRoundProgressBar(canvas, mPaint);
        }

    }

    /**
     * 绘制圆形progressbar
     *
     * @param canvas
     * @param paint
     */
    private void drawRoundProgressBar(Canvas canvas, Paint paint) {
        paint.setColor(progressBgColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dp2px(strokeWidth));

        canvas.drawCircle(centerX, centerY, radius, paint);

        paint.setColor(progressColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dp2px(strokeWidth));
        RectF oval = new RectF(centerX - radius, centerY - radius, radius + centerX, radius + centerY);
        canvas.drawArc(oval, -90, getProgress(), false, paint);

        if (showCountText) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(countDownTextColor);
            paint.setTextSize(px2sp(countDownTextSize));

            Rect rect = new Rect();

            paint.getTextBounds(String.valueOf(countDownText), 0, String.valueOf(countDownText).length(), rect);
            float textWidth = rect.width();
            float textHeight = rect.height();
            if (textWidth >= radius * 2) {
                textWidth = radius * 2;
            }

            canvas.drawText(String.valueOf(countDownText), centerX - textWidth / 2, centerY + textHeight / 2, paint);
        }
    }

    /**
     * 绘制线型的progressbar
     *
     * @param canvas
     * @param paint
     */
    private void drawLinearProgressBar(Canvas canvas, Paint paint) {

    }

    /**
     * 手动设置倒计时text
     *
     * @param countDownText
     */
    public void setCountDownText(int countDownText) {
        this.countDownText = countDownText;
        postInvalidate();
    }

    public void setProgress(float progress) {
        sendLog("percent2 ==> " + progress);
        if (progress > 100)
            this.progress = max;
        else {
            this.progress = progress;
            postInvalidate();
        }
    }

    public float getProgress() {
        float percent = 360 * (max - progress) / max;
        if (percent > 360)
            percent = 360;
        percent = 360 - percent;
        sendLog("progress ==> " + percent);
        return percent;
    }


    int dp2px(float dp) {
        return (int) (getResources().getDisplayMetrics().density * dp);
    }

    int px2sp(float px) {
        return (int) (getResources().getDisplayMetrics().scaledDensity * px);
    }

    void sendLog(String msg) {
        Log.i("Blues", msg);
    }
}
