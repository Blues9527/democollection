package com.example.circleview;

import android.graphics.BitmapFactory;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private CircleView circleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleView = findViewById(R.id.cv_bg);
        circleView.setBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.bd_logo));
    }
}
