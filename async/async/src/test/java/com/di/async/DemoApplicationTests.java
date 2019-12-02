package com.di.async;

import java.util.concurrent.Future;

import com.di.async.tasks.Tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private Tasks task;

	@Test
	public void contextLoads() throws Exception {
		long start = System.currentTimeMillis();

		Future<String> task2 = task.doTaskTwo();
		Future<String> task3 = task.doTaskThree();
		Future<String> task1 = task.doTaskOne();
		
		while(true) {
			if(task1.isDone() && task2.isDone() && task3.isDone()) {
				break;

			}
			Thread.sleep(1000);
		}
		long end = System.currentTimeMillis();
		System.out.println("all tasks done, total time consumtion: "+(end-start)+"ms");
	}

}
