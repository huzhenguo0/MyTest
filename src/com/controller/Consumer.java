package com.controller;

import com.entity.Fruit;


//消费者
public class Consumer implements Runnable{
	private Fruit fruit;
	public Consumer(Fruit fruit){
		super();
		this.fruit=fruit;
	}
	@Override
	public void run() {
		while (true) {
			//同步锁
			synchronized (fruit) {
				if (!fruit.isExist()) {
					try {
						//没货
						System.err.println("货已卖完，等待生产者生产"+fruit.getName());
						//线程等待..
						fruit.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//有货,则购买，并将存在属性变为false，并通知生产者生产 
				fruit.setExist(false);
				System.err.println(fruit.getName()+"被买走了！");
				//唤醒生产者
				fruit.notify();
			}
		}
	}

}
