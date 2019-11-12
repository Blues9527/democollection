package com.example.tranformanim;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

/**
 * User : Blues
 * Date : 2019/7/30
 * Time : 10:01
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void ClickToFirstPage(View view) {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.anim_zoom_out,0);
        finish();
    }
}
