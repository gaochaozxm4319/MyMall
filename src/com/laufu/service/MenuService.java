package com.laufu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laufu.blogbeans.Menu;
import com.laufu.dao.MenuDao;

@Service
public class MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	public List<Menu> getAllMenus() {
		return menuDao.getAllMenus();
	}

	public List<Menu> getMenuByParent(int parentId) {
		// TODO Auto-generated method stub
		return menuDao.getMenuByParent(parentId);
	}

	public Menu getMenuByName(String menuName) {
		// TODO Auto-generated method stub
		return menuDao.getMenuByName(menuName);
	}

	public int addMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.addMenu(menu);
	}

	public int updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.updateMenu(menu);
	}

	public int deleteMenu(int id) {
		// TODO Auto-generated method stub
		return menuDao.deleteMenu(id);
	}
}
