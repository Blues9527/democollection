package com.example.textcolordemo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * User : Blues
 * Date : 2019/7/24
 * Time : 10:16
 */

public class TextClockView extends View {

    private float mWidth, mHeight;

    private float mHourR, mMinuteR, mSecondR;

    private float mHourDeg, mMinuteDeg, mSecondDeg;

    private ValueAnimator mAnimator;

    private Paint mPaint;
    private Paint mHelperPaint;
    private Calendar mCalendar;

    private Paint.FontMetrics fontMetrics;

    private String[] texts = {"日", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
    private List<String> NUMBER_TEXT_LIST = new ArrayList<>(Arrays.asList(texts));

    public TextClockView(Context context) {
        this(context, null);
    }

    public TextClockView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        mPaint = createPaint(null, 0);
        mHelperPaint = createPaint(null, Color.RED);
        fontMetrics = new Paint.FontMetrics();
    }

    public void init() {
        mCalendar = Calendar.getInstance();

        mAnimator = ValueAnimator.ofFloat(6f, 0f);
        mAnimator.setDuration(150);
        mAnimator.setInterpolator(new LinearInterpolator());
        doInvalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //在layout方法中计算view去除padding后的宽高
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        mWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        mHeight = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();

        mHourR = mWidth * 0.143f;
        mMinuteR = mWidth * 0.35f;
        mSecondR = mWidth * 0.35f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas == null) return;
        //黑色背景
        canvas.drawColor(Color.BLACK);
        canvas.save();
        //将圆点移到中心点
        canvas.translate(mWidth / 2, mHeight / 2);

        drawCenterInfo(canvas);
        drawHour(canvas, mHourDeg);
        drawMinute(canvas, mMinuteDeg);
        drawSecond(canvas, mSecondDeg);

        //辅助线
//        canvas.drawLine(0f, 0f, mWidth, 0f, mHelperPaint);

        canvas.restore();
    }

    //绘制中心信息
    private void drawCenterInfo(Canvas canvas) {
        int hour = mCalendar.get(Calendar.HOUR_OF_DAY);
        int minute = mCalendar.get(Calendar.MINUTE);

        mPaint.setTextSize(mHourR * 0.4f);
        mPaint.setAlpha(255);
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(String.format("%s:%s", hour, minute), 0f, getBottomedY(), mPaint);

        String month = String.valueOf(mCalendar.get(Calendar.MONTH) + 1);

        if (Integer.parseInt(month) < 10) {
            month = String.format("0%s", month);
        }

        int day = mCalendar.get(Calendar.DAY_OF_MONTH);

        String dayOfWeek = toText(mCalendar.get((Calendar.DAY_OF_WEEK)) - 1);

        mPaint.setTextSize(mHourR * 0.16f);
        mPaint.setAlpha(255);
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(String.format("%s.%s 星期%s", month, day, dayOfWeek), 0f, getCenteredY(mPaint), mPaint);
    }

    private void drawHour(Canvas canvas, float degrees) {
        mPaint.setTextSize(mHourR * 0.16f);

        canvas.save();
        canvas.rotate(degrees);

        for (int i = 0; i < 12; i++) {
            canvas.save();

            float iDeg = 360 / 12f * i;
            canvas.rotate(iDeg);

            mPaint.setAlpha((iDeg + degrees == 0f) ? 255 : (int) (0.6f * 255));
            mPaint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(String.format("%s点", toText(i + 1)), mHourR, getCenteredY(mPaint), mPaint);
            canvas.restore();
        }
        canvas.restore();
    }

    /**
     * 绘制分
     */
    private void drawMinute(Canvas canvas, float degrees) {
        mPaint.setTextSize(mHourR * 0.16f);
        //处理整体旋转
        canvas.save();
        canvas.rotate(degrees);

        for (int i = 0; i < 60; i++) {
            canvas.save();

            float iDeg = 360 / 60f * i;
            canvas.rotate(iDeg);

            mPaint.setAlpha((iDeg + degrees == 0f) ? 255 : (int) (0.6f * 255));
            mPaint.setTextAlign(Paint.Align.RIGHT);

            if (i < 59) {
                canvas.drawText(String.format("%s分", toText(i + 1)), mMinuteR, getCenteredY(mPaint), mPaint);
            }
            canvas.restore();
        }

        canvas.restore();
    }

    /**
     * 绘制秒
     */
    private void drawSecond(Canvas canvas, float degrees) {
        mPaint.setTextSize(mHourR * 0.16f);

        //处理整体旋转
        canvas.save();
        canvas.rotate(degrees);

        for (int i = 0; i < 60; i++) {
            canvas.save();

            float iDeg = 360 / 60f * i;
            canvas.rotate(iDeg);

            mPaint.setAlpha((iDeg + degrees == 0f) ? 255 : (int) (0.6f * 255));
            mPaint.setTextAlign(Paint.Align.LEFT);

            if (i < 59) {
                canvas.drawText(String.format("%s秒", toText(i + 1)), mSecondR, getCenteredY(mPaint), mPaint);
            }
            canvas.restore();
        }

        canvas.restore();
    }


    /**
     * 创建一个画笔
     *
     * @param colorStr
     * @param color
     */
    private Paint createPaint(@Nullable String colorStr, int color) {

        color = color == 0 ? Color.WHITE : color;

        Paint mPaint = new Paint();
        mPaint.setColor(colorStr != null ? Color.parseColor(colorStr) : color);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        return mPaint;
    }

    public void doInvalidate() {
        int hour = mCalendar.get(Calendar.HOUR);
        final int minute = mCalendar.get(Calendar.MINUTE);
        final int second = mCalendar.get(Calendar.SECOND);

        mHourDeg = -360 / 12f * (hour - 1);
        mMinuteDeg = -360 / 60f * (minute - 1);
        mSecondDeg = -360 / 60f * (second - 1);

        final float hd = mHourDeg;
        final float md = mMinuteDeg;
        final float sd = mSecondDeg;

        mAnimator.removeAllUpdateListeners();

        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float av = (float) animation.getAnimatedValue();

                if (minute == 0 && second == 0) {
                    mHourDeg = hd + av * 5;
                }

                if (second == 0) {
                    mMinuteDeg = md + av;
                }

                mSecondDeg = sd + av;

                invalidate();
            }
        });
        mAnimator.start();
    }

    private float getCenteredY(Paint paint) {
        return paint.getFontMetrics(null) / 2 - fontMetrics.bottom + 10;
    }

    private float getBottomedY() {
        return -fontMetrics.bottom - 10;
    }

    private String toText(int num) {

        String result = "";
        List list = null;

        String str = String.valueOf(num);

        if (str != null) {
            char[] chars = str.toCharArray();

            list = new ArrayList(chars.length);

            for (int len = chars.length, i = 0; i < len; ++i) {
                list.add(Integer.parseInt(String.valueOf(chars[i])));
            }
        }

        if (list.size() > 1) {
            if ((int) list.get(0) != 1) {
                result += NUMBER_TEXT_LIST.get((int) list.get(0));
            }

            result += "十";
            if ((int) list.get(1) > 0) {
                result += NUMBER_TEXT_LIST.get((int) list.get(1));
            }
        } else {
            result = NUMBER_TEXT_LIST.get((int) list.get(0));
        }

        return result;
    }
}
