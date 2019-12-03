package com.di.pool;

import com.di.pool.tasks.Tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PoolTest {
    @Autowired
    private Tasks tasks;

    /**
     * for testing CallerRunsPolicy
     */
    @Test
    public void test() throws Exception {
        for(int i =0; i < 10; i++){
            tasks.doTask1(i);
        }
        Thread.currentThread().join();
    }

    @Test
    public void test3() throws Exception {
        for(int i=0; i<10; i++){
            tasks.doTask3(i);
        }
        Thread.currentThread().join();
    }

    @Test
    public void test4() throws Exception {
        for(int i=0; i<10; i++){
            tasks.doTask4(i);
        }
        Thread.currentThread().join();
        
    }

    @Test
    public void test2() throws Exception {
        for(int i=0; i<10; i++){
            tasks.doTask2(i);
        }
        Thread.currentThread().join();
    }
}


