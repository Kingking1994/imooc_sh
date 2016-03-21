package com.king.dao;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;
import org.junit.Test;
import com.king.entity.Students;

public class TestStudentsDAO {
	
	@Test
	public void testSave(){
		StudentsDAO sDao =new StudentsDAO();
		Students s = new Students("s0000003", "wecong", "男", new Date(), "华工");
		sDao.save(s);
	}
	
	@Test
	public void testFindOne(){
		StudentsDAO sDao = new StudentsDAO();
		Students tmp = sDao.findOne("s0000001");
		Assert.assertEquals(true, (tmp != null));
	}
	
	@Test
	public void testIsExist(){
		StudentsDAO sDao = new StudentsDAO();
		boolean exist = sDao.isExist("s0000003");
		Assert.assertEquals(true, exist);
	}
	
	@Test
	public void testUpdate(){
		StudentsDAO sDao = new StudentsDAO();
		Students s = new Students("s0000002", "张力", "男", new Date(), "大学城");
		sDao.update(s);
	}
	
	@Test
	public void testDelte(){
		StudentsDAO sDao = new StudentsDAO();
		sDao.delete("s0000003");
	}
	
	@Test
	public void testFindAll(){
		StudentsDAO sDao = new StudentsDAO();
		List<Students> list = sDao.findAll();
		Assert.assertEquals(3, list.size());
	}
	
//	@Test
//	public void testGetMaxSid(){
//		StudentsDAO sDao = new StudentsDAO();
//		String sid = sDao.getMaxSid();
//		System.out.println(sid);
//	}

}
