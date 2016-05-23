package com.laufu.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;




import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laufu.dao.UserDao;
import com.laufu.domain.Pager;
import com.laufu.domain.User;
import com.laufu.mapper.UserMapper;


@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	
	@Autowired
	private UserMapper mapper;  

	public int delete(int id) {
		// TODO Auto-generated method stub
		return   mapper.deleteUser(id);
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		
		return  mapper.getUserById(id);
	}

	public List<User> getAll() {
		// TODO Auto-generated method stub
		return mapper.getAllUser();
	}

	public int insert(User u) {
		// TODO Auto-generated method stub
		return mapper.addUser(u);
	}

	public int update(User u) {
		// TODO Auto-generated method stub
		return mapper.updateUser(u);
	}

	@SuppressWarnings("unchecked")
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		List<User> list= (List<User>) mapper.getUserByName(name);
		
		if (list.isEmpty()) return null;
		return list.get(0);

	}
	 
	public Pager getListPage(int page,int pageSize){
		
		Pager p=new Pager();
		
		p.setCurrentPage(page);
		p.setPageSize(pageSize);	
		//总记录数
		int size=mapper.getCount();
		p.setTotalCount(size);
		//Map方式传递多个参数
		Map<String,Integer> m=new HashMap<String,Integer>();
		m.put("start", p.getStart());
		m.put("max", p.getPageSize());
		List<User> list=mapper.getListUser(m);	
	     //直接传递多个参数 
		//List<User> list=mapper.getListUser(p.getStart(), p.getPageSize());
		//数据
		p.setItems(list);
		
		return p;
	}

	@Override
	public User LoginSys(User u) {
		return mapper.loginSys(u);
	}
}
