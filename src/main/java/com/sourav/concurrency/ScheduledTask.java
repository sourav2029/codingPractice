package com.sourav.concurrency;

import lombok.Getter;

public class ScheduledTask extends Task implements Runnable {
    @Getter
    private String message;

    public ScheduledTask(int id, String message) {
        super(id);
        this.message = message;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task" + this.getId() + " will " + this.message + "run from Thread name: " + Thread.currentThread().getName());
        System.out.println("Current Time : " + System.currentTimeMillis()/1000L);
    }
}
