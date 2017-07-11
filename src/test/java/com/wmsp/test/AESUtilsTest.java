package com.wmsp.test;

import com.drawthink.common.utils.AESUtils;

public class AESUtilsTest {
	
	public static void main(String[] args) {
		String oriStr = "I am drawthink";
		String aesStr = AESUtils.AESEncode("qweasd", oriStr);
		System.out.println("加密后:"+aesStr);
		System.out.println("解密后:"+AESUtils.AESDncode("qweasd", aesStr));
	}

}
