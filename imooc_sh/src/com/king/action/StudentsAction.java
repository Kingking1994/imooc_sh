package com.king.action;

import java.util.List;

import com.king.entity.Students;
import com.king.service.StudentsService;
import com.king.service.impl.StudentsServiceImpl;
import com.opensymphony.xwork2.ModelDriven;

public class StudentsAction extends SuperAction implements ModelDriven<Students>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Students student = new Students();
	
	/**
	 * 获取所有学生
	 * @return
	 */
	public String query(){
		
		StudentsService sService = new StudentsServiceImpl();
		List<Students> list = sService.queryAllStudents();
		if(list != null && list.size() > 0){
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}
	
	/**
	 * 删除学生动作
	 * @return
	 */
	public String delete(){	
		String sid = request.getParameter("sid");
		StudentsService sService = new StudentsServiceImpl();
		sService.deleteSrudent(sid);
		return "delete_success";
	}

	/**
	 * 添加学生动作
	 * @return
	 */
	public String add(){
		StudentsService sService = new StudentsServiceImpl();
		sService.addStudent(student);
		return "add_success";
	}
	
	/**
	 * 修改学生动作
	 * @return
	 */
	public String modify(){
		String sid = request.getParameter("sid");
		StudentsService sService = new StudentsServiceImpl();
		Students s = sService.queryStudentBySid(sid);
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	
	/**
	 * 保存修改信息动作
	 * @return
	 */
	public String save(){
		StudentsService sService = new StudentsServiceImpl();
		sService.updateStudent(student);
		return "save_success";
	}
	
	
	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return student;
	}

	
}
