package com.sourav.concurrency.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(50);
        List<Future<Integer>> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<Integer> future = service.submit(new CallableTask(1));
            futureList.add(future);
        }
//        future is a place holder for some value which will arrive some time in the future.
//        here we can perform all the other tasks while one thread is executing the.
//        .get() is a blocking call
        for (int i = 0; i < 100; i++) {
            System.out.println("Result of future #" + i + "=" +futureList.get(i).get());
        }
    }
}
