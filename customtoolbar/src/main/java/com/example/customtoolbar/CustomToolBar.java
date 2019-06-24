package com.example.customtoolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * User : Blues
 * Date : 2019/6/19
 * Time : 11:40
 */

public class CustomToolBar extends RelativeLayout {

    private int leftTextId, rightTextId, titleTextId;
    private int leftTextSize, rightTextSize, titleTextSize;
    private int leftTextColor, rightTextColor, titleTextColor;
    private int leftIcon, rightIcon, midLogo;
    private int backgroundColor;


    private ImageView leftIconIv, rightIconIv, logoIconIv;
    private TextView leftTextTv, rightTextTv, titleTextTv;
    private LinearLayout leftLl, rightLl;
    private FrameLayout titleLl;

    private boolean isShowLeftText, isShowRightText;
    private RelativeLayout toolBarRL;


    public CustomToolBar(Context context) {
        this(context, null);
    }

    public CustomToolBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initAttr(attrs);
        initDefault();
    }

    private void initView(Context context) {

        View layout = LayoutInflater.from(context).inflate(R.layout.custom_toolbar, this);

        leftIconIv = layout.findViewById(R.id.ctb_left_img);
        rightIconIv = layout.findViewById(R.id.ctb_right_img);
        logoIconIv = layout.findViewById(R.id.ctb_mid_img);

        leftTextTv = layout.findViewById(R.id.ctb_left_text);
        rightTextTv = layout.findViewById(R.id.ctb_right_text);
        titleTextTv = layout.findViewById(R.id.ctb_mid_title);

        leftLl = layout.findViewById(R.id.ctb_left);
        rightLl = layout.findViewById(R.id.ctb_right);
        titleLl = layout.findViewById(R.id.ctb_mid);

        toolBarRL = layout.findViewById(R.id.ctb_toolbar_rl);
    }

    private void initAttr(AttributeSet attrs) {

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.CustomToolBar);

        leftTextId = ta.getResourceId(R.styleable.CustomToolBar_leftText, -1);
        rightTextId = ta.getResourceId(R.styleable.CustomToolBar_rightText, -1);
        titleTextId = ta.getResourceId(R.styleable.CustomToolBar_titleText, -1);

        leftTextSize = ta.getDimensionPixelSize(R.styleable.CustomToolBar_leftTextSize, dp2px(12));
        rightTextSize = ta.getDimensionPixelSize(R.styleable.CustomToolBar_rightTextSize, dp2px(14));
        titleTextSize = ta.getDimensionPixelSize(R.styleable.CustomToolBar_titleTextSize, dp2px(12));

        leftTextColor = ta.getColor(R.styleable.CustomToolBar_leftTextColor, getResources().getColor(R.color.black, null));
        rightTextColor = ta.getColor(R.styleable.CustomToolBar_rightTextColor, getResources().getColor(R.color.black, null));
        titleTextColor = ta.getColor(R.styleable.CustomToolBar_titleTextColor, getResources().getColor(R.color.black, null));

        leftIcon = ta.getResourceId(R.styleable.CustomToolBar_leftIcon, R.mipmap.ic_back);
        rightIcon = ta.getResourceId(R.styleable.CustomToolBar_rightIcon, -1);
        midLogo = ta.getResourceId(R.styleable.CustomToolBar_midLogo, -1);

        isShowLeftText = ta.getBoolean(R.styleable.CustomToolBar_isShowLeftText, false);
        isShowRightText = ta.getBoolean(R.styleable.CustomToolBar_isShowRightText, false);

        backgroundColor = ta.getColor(R.styleable.CustomToolBar_backgroundColor, getResources().getColor(R.color.white, null));
        ta.recycle();
    }

    private void initDefault() {

        leftTextTv.setText(leftTextId);
        rightTextTv.setText(rightTextId);
        titleTextTv.setText(titleTextId);

        leftTextTv.setTextSize(leftTextSize);
        rightTextTv.setTextSize(rightTextSize);
        titleTextTv.setTextSize(titleTextSize);

        leftTextTv.setTextColor(leftTextColor);
        rightTextTv.setTextColor(rightTextColor);
        titleTextTv.setTextColor(titleTextColor);

        leftIconIv.setBackground(leftIcon != -1 ? getResources().getDrawable(leftIcon, null) : null);
        rightIconIv.setBackground(rightIcon != -1 ? getResources().getDrawable(rightIcon, null) : null);
        logoIconIv.setBackground(midLogo != -1 ? getResources().getDrawable(midLogo, null) : null);

        leftTextTv.setVisibility(isShowLeftText ? VISIBLE : GONE);
        rightTextTv.setVisibility(isShowRightText ? VISIBLE : GONE);

        toolBarRL.setBackgroundColor(backgroundColor);
    }


    /**
     * 转换像素
     *
     * @param dp
     * @return
     */
    int dp2px(float dp) {
        return (int) (getResources().getDisplayMetrics().density * dp);
    }

    /**
     * 设置左icon
     *
     * @param iconId
     */
    public CustomToolBar setLeftIcon(int iconId) {
        leftIconIv.setBackground(iconId != -1 ? getResources().getDrawable(iconId, null) : null);
        return this;
    }

    /**
     * 设置logo
     *
     * @param iconId
     */
    public CustomToolBar setLogoIcon(int iconId) {
        logoIconIv.setBackground(iconId == -1 ? null : getResources().getDrawable(iconId, null));
        return this;
    }

    /**
     * 设置右icon,默认为-1不显示
     *
     * @param iconId
     */
    public CustomToolBar setRightIcon(int iconId) {
        rightIconIv.setBackground(iconId == -1 ? null : getResources().getDrawable(iconId, null));
        return this;
    }

    /**
     * 设置左text
     *
     * @param textId
     */
    public CustomToolBar setLeftText(int textId) {

        if (isShowLeftText) {
            if (textId != -1) {
                leftTextTv.setText(textId);
            }
        }

        return this;
    }

    /**
     * 设置标题
     *
     * @param textId
     */
    public CustomToolBar setTitleText(int textId) {
        if (textId != -1) {
            titleTextTv.setText(textId);
        }
        return this;
    }

    /**
     * 设置右text
     *
     * @param textId
     */
    public CustomToolBar setRightText(int textId) {
        if (isShowRightText) {
            if (textId != -1) {
                rightTextTv.setText(textId);
            }
        }
        return this;
    }

    /**
     * 设置左边字体大小
     *
     * @param size
     */
    public CustomToolBar setLeftTextSize(int size) {
        leftTextTv.setTextSize(size);
        return this;
    }

    /**
     * 设置标题字体大小
     *
     * @param size
     */
    public CustomToolBar setTitleTextSize(int size) {
        titleTextTv.setTextSize(size);
        return this;
    }

    /**
     * 设置右边字体大小
     *
     * @param size
     */
    public CustomToolBar setRightTextSize(int size) {
        rightTextTv.setTextSize(size);
        return this;
    }

    /**
     * 设置左边文本颜色
     *
     * @param color
     */
    public CustomToolBar setLeftTextColor(int color) {
        leftTextTv.setTextColor(color);
        return this;
    }

    /**
     * 设置标题颜色
     *
     * @param color
     */
    public CustomToolBar setTitleTextColor(int color) {
        titleTextTv.setTextColor(color);
        return this;
    }


    /**
     * 设置右边文本颜色
     *
     * @param color
     */
    public CustomToolBar setRightTextColor(int color) {
        rightTextTv.setTextColor(color);
        return this;
    }


    /**
     * 左边有时候用不到，可隐藏
     *
     * @param isShowLeft
     * @return
     */
    public CustomToolBar showLeftSide(boolean isShowLeft) {

        leftLl.setVisibility(isShowLeft ? VISIBLE : GONE);

        return this;
    }

    /**
     * 右边大多数用不到，可隐藏
     *
     * @param isShowRight
     * @return
     */
    public CustomToolBar showRightSide(boolean isShowRight) {
        rightLl.setVisibility(isShowRight ? VISIBLE : GONE);
        return this;
    }

    /**
     * 显示Logo或者title
     *
     * @param isShowMid
     * @return
     */
    public CustomToolBar showMid(boolean isShowMid) {

        titleLl.setVisibility(isShowMid ? VISIBLE : GONE);

        return this;
    }

    /**
     * 业务需要隐藏左icon
     *
     * @param hide
     * @return
     */
    public CustomToolBar hideLeftIcon(boolean hide) {
        leftIconIv.setVisibility(hide ? GONE : VISIBLE);
        return this;
    }

    /**
     * 业务需要要隐藏右icon
     *
     * @param hide
     * @return
     */
    public CustomToolBar hideRightIcon(boolean hide) {
        rightIconIv.setVisibility(hide ? GONE : VISIBLE);
        return this;
    }

    /**
     * 一般左边只留一个back icon
     *
     * @param hide
     * @return
     */
    public CustomToolBar hideLeftText(boolean hide) {
        leftTextTv.setVisibility(hide ? GONE : VISIBLE);
        return this;
    }

    /**
     * 特殊需要隐藏文字
     *
     * @param hide
     * @return
     */
    public CustomToolBar hideRightText(boolean hide) {

        rightTextTv.setVisibility(hide ? GONE : VISIBLE);

        return this;
    }

    /**
     * 隐藏logo，logo和title二者选一
     *
     * @param hide
     * @return
     */
    public CustomToolBar hideLogo(boolean hide) {

        logoIconIv.setVisibility(hide ? GONE : VISIBLE);

        return this;
    }

    /**
     * 隐藏title，logo和title二者选一
     *
     * @param hide
     * @return
     */
    public CustomToolBar hideTitle(boolean hide) {

        titleTextTv.setVisibility(hide ? GONE : VISIBLE);
        return this;
    }
}
