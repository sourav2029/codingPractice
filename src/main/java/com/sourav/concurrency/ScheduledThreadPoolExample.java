package com.sourav.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        service.schedule(new ScheduledTask(1, "Run after 10 seconds"), 10, SECONDS);
        service.scheduleAtFixedRate(new ScheduledTask(2, "Run every 15 seconds"), 5, 15, SECONDS);
        service.scheduleWithFixedDelay(new ScheduledTask(3, "Run after 10 seconds of finishing the task"), 0, 10, SECONDS);
    }
}
