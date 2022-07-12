package com.sourav.concurrency;

import lombok.Getter;

public class Task implements Runnable {
    @Getter
    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task" + this.getId() + "run from Thread name: " + Thread.currentThread().getName());
        System.out.println("Current Time : " + System.currentTimeMillis()/1000L);
    }
}
