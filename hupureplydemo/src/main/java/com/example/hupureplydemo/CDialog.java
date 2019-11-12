package com.example.hupureplydemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

/**
 * User : Blues
 * Date : 2019/9/12
 * Time : 15:10
 */

public class CDialog extends Dialog {

    private Context mContext;

    public CDialog(@NonNull Context context) {
        super(context);
        mContext = context;
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View container = LayoutInflater.from(mContext).inflate(R.layout.dialog_test, null);

        setContentView(container);
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("Blues", " action down");
                break;

            case MotionEvent.ACTION_UP:
                Log.e("Blues", "action up");
                break;
        }

        return super.onTouchEvent(event);
    }
}
