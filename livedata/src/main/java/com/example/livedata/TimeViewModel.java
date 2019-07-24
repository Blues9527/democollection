package com.example.livedata;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

/**
 * User : Blues
 * Date : 2019/7/22
 * Time : 10:05
 */

public class TimeViewModel extends ViewModel {

    @Nullable
    private Long mStartTime;

    @Nullable
    public Long getStartTime() {
        return mStartTime;
    }

    public void setStartTime(long startTime) {
        this.mStartTime = startTime;
    }
}
