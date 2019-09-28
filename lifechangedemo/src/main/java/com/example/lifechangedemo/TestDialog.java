package com.example.lifechangedemo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * User : Blues
 * Date : 2019/4/1
 * Time : 14:40
 */

public class TestDialog extends Dialog {

    public TestDialog(@NonNull Context context) {
        this(context, 0);
    }

    public TestDialog(@NonNull Context context, int themeResId) {
        this(context, true, null);
    }

    protected TestDialog(@NonNull Context context, boolean cancelable, @Nullable DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_dialog);
    }
}
