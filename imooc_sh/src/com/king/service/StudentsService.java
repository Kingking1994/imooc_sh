package com.king.service;

import java.util.List;

import com.king.entity.Students;


/**
 * 学生服务接口
 * @author king
 *
 */
public interface StudentsService {
	
	public List<Students> queryAllStudents();
	
	public Students queryStudentBySid(String sid);
	
	public boolean addStudent(Students s);
	
	public boolean updateStudent(Students s);
	
	public void deleteSrudent(String sid);
	

}
