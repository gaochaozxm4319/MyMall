package com.laufu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.laufu.domain.Pager;

public abstract class BaseDao<T> {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	public Pager getListPage(int page, int pageSize,T o) {
		Pager p = new Pager();

		p.setCurrentPage(page);
		p.setPageSize(pageSize);
		// 总记录数
//		int size = blogMapper.getCount();
//		p.setTotalCount(size);
//		// Map方式传递多个参数
//		Map<String, Object> m = new HashMap<String, Object>();
//		m.put("start", p.getStart());
//		m.put("max", p.getPageSize());
//		List<T> list = blogMapper.getListBlog(m);
		// 直接传递多个参数
		// 数据
//		p.setItems(list);
		
		return p;
	}
	
//	public T 
}
