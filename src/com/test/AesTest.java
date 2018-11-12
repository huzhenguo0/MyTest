package com.test;

import java.util.Map;

import org.junit.Test;

import com.utils.AESUtils;
import com.utils.DESUtils;
import com.utils.RSAUtils;

public class AesTest {
	@Test
	public void DEStext(){
		String keyStr="9cc9b11a7a0747d4b19d30a324a84dc5";
        System.out.println("keyStr:"+keyStr);
        DESUtils desUtils=new DESUtils(keyStr);
        String sourceStr="DES测试";
        System.out.println("加密前的Str："+sourceStr);
        String encryptString = desUtils.encryptString(sourceStr);
        System.out.println("加密之后："+encryptString);
         String decryptString = desUtils.decryptString(encryptString);
        System.out.println("解密之后："+decryptString);
	}
	@Test
	public void AEStext(){
		try { 
            Map<String, String> keys = RSAUtils.getKeys();
            String publicKey = keys.get("publicKey");
            String privateKey = keys.get("privateKey");
            String key = AESUtils.generateKey();
            System.out.println("aes密钥："+key);
            String plainText = "AES测试";
            plainText = AESUtils.encryptData(key, plainText);
            System.out.println("aes加密后: " + plainText );
            plainText = AESUtils.decryptData(key, plainText);
            System.out.println("aes解密后: " + plainText );
            String encrypt = RSAUtils.encryptByPublicKey(key,publicKey);
            System.out.println("RSA加密："+encrypt);
            String decrypt = RSAUtils.decryptByPrivateKey(encrypt,privateKey);
            System.out.println("RSA解密："+decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        } 
	}
	@Test
	public void RSAtext(){
		try {
			Map<String, String> keys = RSAUtils.getKeys();
			String publicKey = keys.get("publicKey");
			String privateKey = keys.get("privateKey");
			String content = "RSA测试";
			String encrypt = RSAUtils.encryptByPublicKey(content, publicKey);
			String decrypt = RSAUtils.decryptByPrivateKey(encrypt, privateKey);
			System.out.println("加密之后："+encrypt);
			System.out.println("解密之后："+decrypt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
