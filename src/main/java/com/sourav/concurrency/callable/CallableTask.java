package com.sourav.concurrency.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {
    private final int id;

    public CallableTask(int id) {
        this.id = id;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        return new Random().nextInt();
    }
}
