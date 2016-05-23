package com.laufu.dao;

import java.util.List;

import com.laufu.blogbeans.Menu;

public interface MenuDao {
	
	List<Menu> getAllMenus();
	
	List<Menu> getMenuByParent(int parentId);
	
	Menu getMenuByName(String menuName);
	
	int addMenu(Menu menu);
	
	int updateMenu(Menu menu);
	
	int deleteMenu(int id );
}
