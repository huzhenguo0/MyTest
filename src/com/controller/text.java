package com.controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.entity.Fruit;
public class text {
	public static void main(String[] args) {
		Fruit fruit = new Fruit();
		fruit.setName("小米6");
		fruit.setExist(true);
		//生产者
		Producer producer = new Producer(fruit);
		//消费者
		Consumer consumer = new Consumer(fruit);
		final Thread thread1 = new Thread(producer);
		final Thread thread2 = new Thread(consumer);
    	Runnable runnable = new Runnable() {  
    		public void run() {  
    			//启动线程
    			thread1.start();
    			thread2.start();
    		} 
    	};  
    	ScheduledExecutorService service = Executors  
    			.newSingleThreadScheduledExecutor();  
    	// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
    	service.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
	}
}
