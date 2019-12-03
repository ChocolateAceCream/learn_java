package com.di.pool.tasks;

import java.util.Random;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Tasks{
    public static Random random = new Random();

    //point to thread pool name
    @Async("taskExecutorCallerRuns")
    public void doTask1(Integer i) throws Exception {
        log.info("start task"+i);
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("task "+ i +" done, time consumed: " + (end-start)+"ms");
    }

    @Async("taskExecutorAbortPolicy")
    public void doTask2(Integer i) throws Exception {
        log.info("start task"+i);
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        log.info("task "+ i +" done, time consumed: " + (end-start)+"ms");
    }

    @Async("taskExecutorDiscardOldestPolicy")
    public void doTask4(Integer i) throws Exception {
        log.info("start task"+i);
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        log.info("task "+ i +" done, time consumed: " + (end-start)+"ms");
    }

    @Async("taskExecutorDiscardPolicy")
    public void doTask3(Integer i) throws Exception {
        log.info("start task"+i);
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(100));
        long end = System.currentTimeMillis();
        log.info("task "+ i +" done, time consumed: " + (end-start)+"ms");
    }



}