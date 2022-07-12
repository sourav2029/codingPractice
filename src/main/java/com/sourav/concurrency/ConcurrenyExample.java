package com.sourav.concurrency;


public class ConcurrenyExample {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Task(i));
            t.start();
        }
        System.out.println("Thread Name :" + Thread.currentThread().getName());
    }
}
