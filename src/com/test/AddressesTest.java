package com.test;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.utils.AddressUtils;

public class AddressesTest {
	AddressUtils addressUtils = new AddressUtils();
	/**
	 * 测试IP：111.121.72.101  中国贵州省贵阳市 电信
	 */
	@Test
	public void test(){
        String ip = "111.121.72.101";
        String address = "";
        try {
            address = addressUtils.getAddresses("ip=" + ip, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(address);//中国贵州省贵阳市 电信
	}
}
