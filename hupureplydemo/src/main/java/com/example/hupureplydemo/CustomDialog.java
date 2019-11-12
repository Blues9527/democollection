package com.example.hupureplydemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

/**
 * User : Blues
 * Date : 2019/5/5
 * Time : 11:18
 */

public class CustomDialog extends Dialog {

    private Context mContext;

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
        mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View containView = LayoutInflater.from(mContext).inflate(R.layout.dialog_main, null);
//        EditText etName = containView.findViewById(R.id.et_name);
//        EditText etPwd = containView.findViewById(R.id.et_pwd);

//        软键盘不要遮挡输入框
//        etName.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
//        etPwd.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
        //一下设置都失败
//        Window win = getWindow();
//        WindowManager.LayoutParams params = win.getAttributes();
//        win.setSoftInputMode(params.SOFT_INPUT_ADJUST_RESIZE);
//
        setContentView(containView);
//        if (getWindow() != null) {
//            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//            openKeybord(etName, mContext);
//            openKeybord(etPwd, mContext);
//        }

    }
}
