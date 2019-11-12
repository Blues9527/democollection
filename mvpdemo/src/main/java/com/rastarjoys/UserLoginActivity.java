package com.rastarjoys;

import android.app.ActivityManager;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rastarjoys.model.bean.User;
import com.rastarjoys.presenter.UserLoginPresenter;
import com.rastarjoys.view.IUserLoginView;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {

    private EditText mUsernameEt, mPasswordEt;
    private Button mLoginBtn, mClearBtn;
    private ProgressBar mProgressBar;
    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mUsernameEt = findViewById(R.id.mUsernameEt);
        mPasswordEt = findViewById(R.id.mPasswordEt);
        mLoginBtn = findViewById(R.id.mLoginBtn);
        mClearBtn = findViewById(R.id.mClearBtn);
        mProgressBar = findViewById(R.id.mProgressBar);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();
            }
        });

        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.clear();
            }
        });

    }

    @Override
    public String getUsername() {
        return mUsernameEt.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPasswordEt.getText().toString();
    }

    @Override
    public void showLoading() {

        mProgressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {

        mProgressBar.setVisibility(View.GONE);

    }

    @Override
    public void toMainActivity(User user) {

        Toast.makeText(this,"登录成功！",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showFailedError() {

        Toast.makeText(this, "登录失败！", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void clearUserName() {

        mUsernameEt.setText("");

    }

    @Override
    public void clearPassword() {

        mPasswordEt.setText("");

    }
}
