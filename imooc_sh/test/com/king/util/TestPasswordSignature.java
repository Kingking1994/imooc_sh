package com.king.util;

import org.junit.Test;


public class TestPasswordSignature {
	
	@Test
	public void testSign(){
		String pw = "123456789";
		String s = PasswordSignature.sign(pw);
		System.out.println(s);
	}

}
