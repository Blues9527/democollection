package com.example.tranformanim;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickToSecondPage(View view) {
        startActivity(new Intent(this, SecondActivity.class));
        overridePendingTransition(R.anim.anim_slide_to_bottom, 0);
        finish();
    }
}
