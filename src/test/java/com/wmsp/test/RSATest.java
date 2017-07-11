package com.wmsp.test;

import com.drawthink.common.utils.RSAUtils;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSATest {
	protected static RSAPrivateKey privateKey;
    protected static RSAPublicKey publicKey;
    protected static byte[] resultBytes; 
    
	public static void main(String[] args) {
		 try{
	            String message = "I am drawthink";
	            
	            System.out.println("明文是:" + message);
	            RSAUtils.generateKeyPair();
	            //得到私钥和公钥
	            privateKey =(RSAPrivateKey) RSAUtils.getKeyPair().getPrivate();
	            publicKey = (RSAPublicKey)RSAUtils.getKeyPair().getPublic();
	            
	            //用公钥加密
	            byte[] srcBytes = message.getBytes();
	            resultBytes = RSAUtils.encrypt(publicKey, srcBytes);
	            String result = new String(resultBytes);
	            System.out.println("用公钥加密后密文是:" + result);
	            
	            //用私钥解密
	            byte[] decBytes = RSAUtils.decrypt(privateKey,resultBytes);
	            String dec = new String(decBytes);
	            System.out.println("用私钥解密后的结果是:" + dec);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	}

}
