package com.laufu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laufu.blogbeans.Blog;
import com.laufu.dao.BlogDao;
import com.laufu.domain.Pager;
import com.laufu.mapper.BlogMapper;

@Repository
public class BlogDaoImpl implements BlogDao {

	@Autowired
	private BlogMapper blogMapper;

	@Override
	public List<Blog> getListBlog(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return blogMapper.getListBlog(map);
	}

	@Override
	public int insertBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogMapper.insertBlog(blog);
	}

	@Override
	public int updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogMapper.updateBlog(blog);
	}

	@Override
	public int deleteBlog(int id) {
		// TODO Auto-generated method stub
		return blogMapper.deleteBlog(id);
	}

	@Override
	public Blog selectBlogById(int id) {
		// TODO Auto-generated method stub
		return blogMapper.selectBlogById(id);
	}

	@Override
	public Blog getBlogByName(String name) {
		// TODO Auto-generated method stub
		return blogMapper.getBlogByName(name);
	}
	
//	public Blog getBlog(){
////		return getSqlSession().
//	}

	/**
	 * 返回页面对象
	 * @param page 当前页数
	 * @param pageSize 每页显示的数据量
	 * @return
	 */
	public Pager getListPage(int page, int pageSize) {
		Pager p = new Pager();

		p.setCurrentPage(page);
		p.setPageSize(pageSize);
		// 总记录数
		int size = blogMapper.getCount();
		p.setTotalCount(size);
		// Map方式传递多个参数
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("start", p.getStart());
		m.put("max", p.getPageSize());
		List<Blog> list = blogMapper.getListBlog(m);
		// 直接传递多个参数
		// 数据
		p.setItems(list);

		return p;
	}
}
