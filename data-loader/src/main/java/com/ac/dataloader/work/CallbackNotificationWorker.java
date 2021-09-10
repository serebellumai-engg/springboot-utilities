package com.ac.dataloader.work;

import com.ac.dataloader.entity.orm.Job;

public class CallbackNotificationWorker implements Runnable {
    private Job job;

    public CallbackNotificationWorker(Job job) {
        this.job = job;
    }

    @Override
    public void run() {

    }
}
