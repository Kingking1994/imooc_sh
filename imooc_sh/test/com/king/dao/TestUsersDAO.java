package com.king.dao;

import org.junit.Test;
import junit.framework.Assert;
import com.king.entity.Users;

public class TestUsersDAO {

	@Test
	public void testSave(){
		Users u = new Users("king", "123456");
		UsersDAO uDao = new UsersDAO();
		Users tmp = uDao.save(u);
		Assert.assertEquals(true, (tmp != null));
	}
	
	
	@Test
	public void testFindOne(){
		UsersDAO uDao = new UsersDAO();
		Users tmp = uDao.findOne(1);
		Assert.assertEquals(true, (tmp != null));
	}
	
	@Test
	public void testIsExist(){
		UsersDAO uDao = new UsersDAO();
		boolean exist = uDao.isExist(1);
		Assert.assertEquals(true, exist);
	}
	
	@Test
	public void testDelete(){
		UsersDAO uDao =new UsersDAO();
		Users u = new Users("king", "123456");
		u.setUid(2);
		uDao.delete(u);
	}
	
	@Test
	public void testUpdate(){
		UsersDAO uDao =new UsersDAO();
		Users u = new Users("king", "123456789");
		u.setUid(1);
		uDao.update(u);
	}
	
	@Test
	public void testFindByUsername(){
		UsersDAO uDao =new UsersDAO();
		Users u = uDao.findByUsername("king");
		Assert.assertEquals("123456789", u.getPassword());
	}
}
