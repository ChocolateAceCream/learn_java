package com.di.async.tasks;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class Tasks{

    public static Random random = new Random();

    @Async
    public Future<String> doTaskOne() throws Exception {
        System.out.println("start task 1");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("task 1 done, time consumed: " + (end - start) + "ms");
        return new AsyncResult<>("task one done");
    }

    @Async
    public Future<String> doTaskTwo() throws Exception {
        System.out.println("start task 2");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("task 2 done, time consumed: " + (end - start) + "ms");
        return new AsyncResult<>("task two done");
    }

    @Async
    public Future<String> doTaskThree() throws Exception {
        System.out.println("start task 3");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("task 3 done, time consumed: "+ (end-start) + "ms");
        return new AsyncResult<>("task three done");
    }

}