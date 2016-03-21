package com.king.service.impl;

import java.util.List;

import com.king.dao.StudentsDAO;
import com.king.entity.Students;
import com.king.service.StudentsService;

public class StudentsServiceImpl implements StudentsService{

	@Override
	public List<Students> queryAllStudents() {
		// TODO Auto-generated method stub
		StudentsDAO sDao = new StudentsDAO();
		return sDao.findAll();
	}

	@Override
	public Students queryStudentBySid(String sid) {
		if(" ".equals(sid) && sid == null){
			return null;
		}else{
			StudentsDAO sDao = new StudentsDAO();
			return sDao.findOne(sid);
		}
	}

	@Override
	public boolean addStudent(Students s) {
		// TODO Auto-generated method stub
		if(s !=null){
			StudentsDAO sDao = new StudentsDAO();
			Students tmp = sDao.save(s);
			if(tmp != null){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateStudent(Students s) {
		// TODO Auto-generated method stub
		if(s != null){
			StudentsDAO sDao = new StudentsDAO();
			sDao.update(s);
			return true;
		}
		return false;
	}

	@Override
	public void deleteSrudent(String sid) {
		// TODO Auto-generated method stub
		StudentsDAO sDao = new StudentsDAO();
		sDao.delete(sid);
	}
	
}
