package com.example.livedata;

import androidx.lifecycle.ViewModel;
import androidx.annotation.Nullable;

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
