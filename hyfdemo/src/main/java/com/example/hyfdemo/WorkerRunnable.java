package com.example.hyfdemo;

import java.util.concurrent.Callable;

/**
 * User : Blues
 * Date : 2019/10/21
 * Time : 09:57
 */

public class WorkerRunnable {

    private WorkerRunnable.WorkerRunnableImple worker;

    public WorkerRunnable(){
        worker = new WorkerRunnableImple() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
    }


    public static abstract class WorkerRunnableImple implements Callable {

    }
}
