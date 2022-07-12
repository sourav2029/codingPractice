package com.sourav.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors()*10;
        System.out.println("available cores "+ coreCount);
//        there are four kinds of thread pools which are available in java
//        fixed, cached, scheduled, singleThreaded
//        fixed thread pool will create a poll of n threads passed as arguments.
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        for (int i = 0; i < 10000; i++) {
            service.execute(new Task(i));
        }
        System.out.println("Thread Name :" + Thread.currentThread().getName());
    }
}
