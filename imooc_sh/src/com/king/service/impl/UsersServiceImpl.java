package com.king.service.impl;

import com.king.dao.UsersDAO;
import com.king.entity.Users;
import com.king.service.UsersService;
import com.king.util.PasswordSignature;


/**
 * 服务接口实现类
 * @author king
 *
 */
public class UsersServiceImpl implements UsersService{

	@Override
	public boolean usersLogin(Users u) {
		UsersDAO uDao = new UsersDAO();
		Users tmp = uDao.findByUsername(u.getUsername());
		if(tmp != null && tmp.getPassword().equals(PasswordSignature.sign(u.getPassword()))){
			return true;
		}
		return false;
	}

}
