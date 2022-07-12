package com.sourav.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i=0;i<1000; i++){
            service.execute(new Task(i));
        }
        System.out.println("Thread Name :" + Thread.currentThread().getName());
    }
}
