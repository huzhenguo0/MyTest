package com.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Emp;
import com.entity.TypeEnum;
import com.service.EmpService;
import com.utils.Base64Utils;
import com.utils.MD5Util;

public class MyTest {
	private int number;
    private String name;
    private enum SimpleEnum {  
        SPRING,  
        SUMMER,  
        AUTUMN,  
        WINTER  
    } 
    /**
     * 初始化块
     */
    {
        number = 5;
    }

    public MyTest(){
        name = "Kelsen";
    }

	@Test
	public void test1(){
//		System.err.println(number);
		System.err.println(MD5Util.entryptByMD5("hzg"));
//		int number = 10;
//		String binaryString = Integer.toBinaryString(number);//二进制
//		number = number >>> 1;
//		System.err.println(number);
//		System.err.println(binaryString);
//		System.err.println(Integer.toBinaryString(number));
	}
	//获取IP地址
	@Test
	public void test2(){
		try {
			//获取本机IP
			InetAddress ip = InetAddress.getLocalHost();
			System.out.println(ip);   //win7-PC/192.168.0.38
			String sip = ip.getHostAddress();
			String name = ip.getHostName();
			System.out.println(name+"  "+ sip);//win7-PC  192.168.0.38
			//获取其他主机信息
			ip = InetAddress.getByName("www.cnblogs.com");
			System.out.println(ip);//www.baidu.com/61.135.169.125
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test3(){
		String entryptByMD5 = MD5Util.entryptByMD5("薛洋");
		System.err.println(entryptByMD5);
	}
	
	@Test
	public void test4(){
		String string = "1";
		String[] split = string.split("&");
		for (String string2 : split) {
			System.err.println(string2);
		}
	}
	
	@Test
	public void test5(){
		int[] str = new int[]{3,1,2};
		int temp;
		int minIndex;
		for (int i = 0; i < str.length; i++) {
			minIndex = i;
			for (int j = i+1; j < str.length; j++) {
				if (str[minIndex] > str[j]) {
					minIndex = j;
				}
			}
			temp = str[i];
			str[i] = str[minIndex];
			str[minIndex] = temp;
		}
		for (int i : str) {
			System.err.println(i);
		}
	}
	//枚举
	@Test
	public void test6(){
//		SimpleEnum[] values = SimpleEnum.values();
//		for (SimpleEnum simpleEnum : values) {
//			System.err.println(simpleEnum);
//		}
		TypeEnum typeEnum = TypeEnum.TEXT;
		int value = typeEnum.getValue();
		System.err.println(value);
	}
	
	@Test
	public void test7(){
		//String property = System.getProperty("java.class.path");
		int processors = Runtime.getRuntime().availableProcessors();
		System.err.println(processors);
	}
	@Test
	public void test8(){
		Map<String,String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        //返回同步的容器
        Map<String, String> synMap = Collections.synchronizedMap(map);
        System.err.println("1"+synMap);
        
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        //返回同步的容器
        List<String> synList = Collections.synchronizedList(list);
        System.err.println("2"+synList);
        
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        //返回同步的容器
        Set<String> synSet = Collections.synchronizedSet(set);
        System.err.println("3"+synSet);
	}
	@Test
	public void test9(){
		String PlateNumMatch = "^(([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z](([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]))$";
        boolean m1 = "闽D12345".matches(PlateNumMatch);
        System.out.println(m1);//true
        boolean m2 = "闽d12345".matches(PlateNumMatch);
        System.out.println(m2);//false
	}
	
	@Test
	public void test10(){
		System.err.println(5/(24*60));
	}
	
	@Test
	public void test11(){
	   Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for(String q : queue){
            System.out.println(q);
        }
	}
	@Test
	public void test12(){
		String a = "hello2"; 
        final String b = "hello";
        String d = "hello";
        String c = b + 2; 
        String e = d + 2;
        System.err.println(e);
        System.out.println((a == c));
        System.out.println((a.equals(e)));
	}
}
