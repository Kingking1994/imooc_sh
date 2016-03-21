package com.king.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.king.entity.Users;
import com.king.service.UsersService;
import com.king.service.impl.UsersServiceImpl;
import com.opensymphony.xwork2.ModelDriven;

public class UsersAction extends SuperAction implements ModelDriven<Users>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	
	
	/**
	 * 用户登录动作
	 * @return
	 */
	public String login(){
		UsersService uService = new UsersServiceImpl();
		if(uService.usersLogin(user)){
			//在session中保存成功登录的用户名
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		}else{
			return "login_failure";
		}
	}
	
	/**
	 * 用户注销动作
	 * @return
	 */
	@SkipValidation  //跳过错误检测
	public String logout(){
		if(session.getAttribute("loginUserName") != null){
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	
	
	
	@Override
	public void validate() {
		
		//用户名不能为空
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError", "用户不能为空");
		}
		//密码长度不少于6位
		if(user.getPassword().length() < 6){
			this.addFieldError("passwordError", "密码长度不少于6位");
		}
	}

	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
