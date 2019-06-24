package com.example.launchmodedemo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import java.util.List;

/**
 * User : Blues
 * Date : 2019/4/17
 * Time : 15:45
 */

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i("Blues", "on_create--->second_activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Blues", "on_resume--->second_activity");

        List<ActivityManager.AppTask> appTasks = ((ActivityManager) getSystemService(ACTIVITY_SERVICE)).getAppTasks();

        for (ActivityManager.AppTask appTask : appTasks) {
            Log.i("Blues", "second_activity_id ---> " + appTask.getTaskInfo().id);
            Log.i("Blues","second_activity_top_activity ---> " + appTask.getTaskInfo().topActivity);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Blues", "on_destroy--->second_activity");
    }

    public void ToFirst(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void ToThird(View view) {
        startActivity(new Intent(this, ThirdActivity.class));
    }

    public void ToSecond(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void ToFour(View view) {
        startActivity(new Intent(this, FourActivity.class));
    }
}
