package com.king.service.impl;

import org.junit.Test;

import junit.framework.Assert;
import com.king.entity.Users;
import com.king.service.UsersService;


public class TestUsersServiceImpl {
	
	
	@Test
	public void testUsersLogin(){
		Users u = new Users("king", "123456789");
		UsersService uService = new UsersServiceImpl();
		Assert.assertEquals(true,uService.usersLogin(u) );
	}

}
