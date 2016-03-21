package com.king.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.util.encoders.Hex;



/**
 * 用户密码的签名与验证工具类
 * @author king
 *
 */
public class PasswordSignature {
	
	public static String sign(String password){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] md5Bytes = md.digest(password.getBytes());
			String signature = Hex.toHexString(md5Bytes);
			return signature;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
