package com.laufu.dao;

import java.util.List;


import com.laufu.domain.Pager;
import com.laufu.domain.User;

public interface UserDao {

	public int insert(User u);

	public int update(User u);

	public int delete(int id);

	public User getUserById(int id);
   
	public  User getUserByName(String  name);
	
	public List<User> getAll();
	
	public Pager getListPage(int page,int pageSize);

	public User LoginSys(User u);
}
