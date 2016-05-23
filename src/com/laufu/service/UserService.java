package com.laufu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laufu.dao.UserDao;
import com.laufu.domain.Pager;
import com.laufu.domain.User;
@Service
public class UserService {
    @Autowired
	UserDao dao;
	
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return dao.getUserById(id);
	}

	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return dao.getUserByName(name);
	}
	
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}
	public Pager getList(int page,int pageSize) {
		// TODO Auto-generated method stub
		return dao.getListPage(page, pageSize);
	}

	public int insert(User u) {
		// TODO Auto-generated method stub
		return dao.insert(u);
	}

	public int update(User u) {
		// TODO Auto-generated method stub
		return dao.update(u);
	}
	
	public User loginSys(User u){
		return dao.LoginSys(u);
	}
}
