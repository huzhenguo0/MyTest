package com.controller;

import com.entity.Fruit;


//生产者
public class Producer implements Runnable{
	private Fruit fruit;
	public Producer(Fruit fruit){
		super();
		this.fruit=fruit;
	}
	@Override
	public void run() {
		while (true) {
			//同步锁
			synchronized (fruit) {
				if (fruit.isExist()) {
					try {
						//有存货
						System.err.println("还有存货，等待消费者购买"+fruit.getName());
						//线程等待..
						fruit.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//没有存货,则生产，并将存在属性变为true，并通知消费者购买 
				fruit.setExist(true);
				System.err.println(fruit.getName()+"新货生产出来！");
				//唤醒消费者
				fruit.notify();
			}
		}
	}
}
