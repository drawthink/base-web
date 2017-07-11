package com.drawthink.common.utils;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSAUtils {
	private static String RSAKeyStore = "e:/RSAKey.txt";
	private static String RSAPublicKeyStore = "e:/RSAPublicKey.txt";

	/**
	 * * 生成密钥对 *
	 * 
	 * @return KeyPair *
	 * @throws EncryptException
	 */
	public static KeyPair generateKeyPair() throws Exception {
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			final int KEY_SIZE = 1024;// 没什么好说的了，这个值关系到块加密的大小，可以更改，但是不要太大，否则效率会低
			keyPairGen.initialize(KEY_SIZE, new SecureRandom());
			KeyPair keyPair = keyPairGen.generateKeyPair();
			
			//将公钥对象持久化，给客户端
			saveKeyPair(keyPair);
			savePublicKey((RSAPublicKey)keyPair.getPublic());
			return keyPair;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static KeyPair getKeyPair() throws Exception {
		FileInputStream fis = new FileInputStream(RSAKeyStore);
		ObjectInputStream oos = new ObjectInputStream(fis);
		KeyPair kp = (KeyPair) oos.readObject();
		oos.close();
		fis.close();
		return kp;
	}

	public static void saveKeyPair(KeyPair kp) throws Exception {
		FileOutputStream fos = new FileOutputStream(RSAKeyStore);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		// 生成密钥
		oos.writeObject(kp);
		oos.close();
		fos.close();
	}
	
	public static void savePublicKey(RSAPublicKey rpk) throws Exception {
		FileOutputStream fos = new FileOutputStream(RSAPublicKeyStore);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		// 生成密钥
		oos.writeObject(rpk);
		oos.close();
		fos.close();
	}

	public static byte[] encrypt(RSAPublicKey publicKey, byte[] srcBytes) {
		if (publicKey != null) {
			try {
				// Cipher负责完成加密或解密工作，基于RSA
				Cipher cipher = Cipher.getInstance("RSA");
				// 根据公钥，对Cipher对象进行初始化
				cipher.init(Cipher.ENCRYPT_MODE, publicKey);

				// 加密，结果保存进resultBytes，并返回
				byte[] resultBytes = cipher.doFinal(srcBytes);
				return resultBytes;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static byte[] decrypt(RSAPrivateKey privateKey, byte[] encBytes) {
		if (privateKey != null) {
			try {
				Cipher cipher = Cipher.getInstance("RSA");

				// 根据私钥对Cipher对象进行初始化
				cipher.init(Cipher.DECRYPT_MODE, privateKey);

				// 解密并将结果保存进resultBytes
				byte[] decBytes = cipher.doFinal(encBytes);
				return decBytes;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
