package com.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class AAA {
	private boolean stop = false; 
	@Test
	public void main() {
		final HashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
		map.put("6", "6");
		map.put("7", "7");
		map.put("8", "8");
		System.err.println(map.values());
//		Thread thread = new Thread(){
//			public void run(){
//				while (!stop) {
//					Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
//					while (iterator.hasNext()) {
//						Map.Entry<String, String> entry = iterator.next();
//						iterator.remove();
//						if (map.size()<=0) {
//                    	System.err.println(map.size());
//                    	System.err.println(this.isInterrupted());
//							this.interrupt();
//						System.err.println(this.isInterrupted());
//						System.err.println(this.isInterrupted()+"   "+this.getName() +"   "+Thread.currentThread().getName());
//						}
//					}
//				}
//			}
//		};
//		thread.start();
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		stop = true;//终止线程
//		System.err.println("---------"+thread.isInterrupted() +"   "+thread.getName() +"   "+Thread.currentThread().getName());
//		
//		try {
//			Thread.sleep(10000);
//			System.err.println("------22---"+thread.isInterrupted() +"   "+thread.getName() +"   "+Thread.currentThread().getName());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

}
