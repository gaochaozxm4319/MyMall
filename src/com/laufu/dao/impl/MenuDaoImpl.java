package com.laufu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laufu.blogbeans.Menu;
import com.laufu.dao.MenuDao;
import com.laufu.mapper.MenuMapper;

@Repository
public class MenuDaoImpl implements MenuDao{

	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> getAllMenus() {
		return menuMapper.getAllMenus();
	}

	@Override
	public List<Menu> getMenuByParent(int parentId) {
		// TODO Auto-generated method stub
		return menuMapper.getMenuByParent(parentId);
	}

	@Override
	public Menu getMenuByName(String menuName) {
		// TODO Auto-generated method stub
		return menuMapper.getMenuByName(menuName);
	}

	@Override
	public int addMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuMapper.addMenu(menu);
	}

	@Override
	public int updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuMapper.updateMenu(menu);
	}

	@Override
	public int deleteMenu(int id) {
		// TODO Auto-generated method stub
		return menuMapper.deleteMenu(id);
	}

}
