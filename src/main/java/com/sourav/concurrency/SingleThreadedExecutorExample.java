package com.sourav.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadedExecutorExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10000; i++) {
            service.execute(new Task(i));
        }
        System.out.println("Thread Name :" + Thread.currentThread().getName());
    }
}
