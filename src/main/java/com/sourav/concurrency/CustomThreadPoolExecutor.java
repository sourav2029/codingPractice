package com.sourav.concurrency;

import java.util.concurrent.*;

public class CustomThreadPoolExecutor {
    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(
                10,
                100,
                120, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(300));

        try {
            service.execute(new Task(1));
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
        }
    }



    private static class CustomRejectionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(Thread.currentThread().getName() + "handling Rejection Exception");
        }
    }
}
