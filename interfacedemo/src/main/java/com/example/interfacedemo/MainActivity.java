package com.example.interfacedemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.interfacedemo.login.LoginManager;

public class MainActivity extends AppCompatActivity {

    private EditText etAccount, etPassword;
    private Button btnLogin;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);


        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString();
                String password = etPassword.getText().toString();
                printLog(account, password);
                LoginManager.getInstance().login(account, password, new LoginManager.LoginCallBack() {
                    @Override
                    public void onSuccess() {
                        startActivity(new Intent(MainActivity.this, SecondActivity.class));
                    }

                    @Override
                    public void onFailure(String msg) {
                        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void printLog(String... strings) {
        for (String str : strings)
            Log.i("Blues", str);
    }
}
