package com.di.pool.config;

import java.util.concurrent.Executor;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class TaskPoolConfig {
    @Bean("taskExecutorCallerRuns")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //initial thread #
        executor.setCorePoolSize(2);
        //only when thread number exceeds queue capacity, threadpool size increased but max is set here
        executor.setMaxPoolSize(5);
        //used to cache req
        executor.setQueueCapacity(2);
        //when there's # of thread more than core thread pool size, when those threads are destroied when free for 60 seconds,
        executor.setKeepAliveSeconds(10);
        //used for helping us locate thread pool
        executor.setThreadNamePrefix("taskExecutor1-");
        //when thread pool out of capacity(reached max pool size and queue is full), new req will be rejected.
        //CallerRunsPolicy will be applied to rejected req.
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    /**
     * whole threadpool is terminated, all current running threads are aborted
     * @return
     */
    @Bean("taskExecutorAbortPolicy")
    public Executor taskExecutorAbortPolicy() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();  
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(2);
        executor.setKeepAliveSeconds(10);
        executor.setThreadNamePrefix("taskexecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }

    /**
     * DiscardPolicy means when full, discard new coming thread directly without throwing any exception
     * 
     * @return
     */
    @Bean("taskExecutorDiscardPolicy")
    public Executor taskExecutorDiscardPolicy() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();  
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(2);
        executor.setKeepAliveSeconds(10);
        executor.setThreadNamePrefix("taskExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        return executor;
    }

    @Bean("taskExecutorDiscardOldestPolicy")
    public Executor taskExecutorDiscardOldestPolicy() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();  
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(2);
        executor.setKeepAliveSeconds(10);
        executor.setThreadNamePrefix("taskExecutor4-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        return executor;
    }

}


