package com.example.launchmodedemo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Blues", "on_create--->main_activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Blues", "on_resume--->main_activity");

        List<ActivityManager.AppTask> appTasks = ((ActivityManager) getSystemService(ACTIVITY_SERVICE)).getAppTasks();

        for (ActivityManager.AppTask appTask : appTasks) {
            Log.i("Blues", "main_activity_id ---> " + appTask.getTaskInfo().id);
            Log.i("Blues","main_activity_top_activity ---> " + appTask.getTaskInfo().topActivity);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Blues", "on_destroy--->main_activity");
    }

    public void ToSecond(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void ToThird(View view) {
        startActivity(new Intent(this, ThirdActivity.class));
    }

    public void ToFirst(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void ToFour(View view) {
        startActivity(new Intent(this, FourActivity.class));
    }
}
