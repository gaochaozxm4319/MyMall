package com.laufu.mapper;

import java.util.List;

import com.laufu.blogbeans.Menu;

public interface MenuMapper {

	List<Menu> getAllMenus();
	
	List<Menu> getMenuByParent(int parentId);
	
	Menu getMenuByName(String menuName);
	
	int addMenu(Menu menu);
	
	int updateMenu(Menu menu);
	
	int deleteMenu(int id );
	
}
