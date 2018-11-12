package com.test;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.junit.Test;

public class ScoketTest {
	//服务端
	@Test
	public void Scoketser () throws Exception{
		// 1:serverscoket 进行端口的监听
		ServerSocket ss = new ServerSocket(6666);
		Socket sc = ss.accept();
        //2从输出流中读取数据
		InputStream is = sc.getInputStream();
		//3 对数据进行处理（数据读入到buffer中，转换字符串）
		byte[] buffer=new byte[1024];
		int len=-1;
		len=is.read(buffer);
		String getData=new String(buffer, 0, len);
		System.out.println("从客户端获取的数据:"+getData);
		//4 业务处理 大小写转化
		String outPutData=getData.toUpperCase();
		//5 写入到输入流中返回给客户端
		OutputStream os = sc.getOutputStream();
		os.write(outPutData.getBytes("UTF-8"));
		//6 关闭资源
		os.close();
		is.close();
		sc.close();
        ss.close();
	}
	//客户端
	@Test
	public void ScoketCli () throws Exception{
		//1 获取用户输入的数据
		Scanner input=new Scanner(System.in);
		System.out.println("请输入数据:");
		String inputData=input.nextLine();
		
		//2 开启一个Socket端口:将用户的输入的数据写入输出流，发给端口
		Socket sc=new Socket("127.0.0.1", 6666);
		OutputStream os=sc.getOutputStream();
		os.write(inputData.getBytes());
		
		//3：获取服务端回传的数据，打开输入流从输入流中读取数据，然后将数据写到字节数组中
		InputStream is = sc.getInputStream(); 
		byte[] buffer=new byte[1024];
		int len=-1;
		len=is.read(buffer);
		String getData=new String(buffer, 0, len);
		System.out.println("从服务端获取的数据:"+getData);
		//关闭资源
		is.close();
		os.close();
		sc.close();
	}
}
