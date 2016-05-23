package com.laufu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laufu.dao.UserDao;
import com.laufu.domain.User;

@Service
public class LoginService {

	@Autowired
	private UserDao userDao;
	
	public User loginSys(User u){
		return userDao.LoginSys(u);
	}
}
