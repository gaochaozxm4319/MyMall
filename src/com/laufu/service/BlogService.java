package com.laufu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laufu.blogbeans.Blog;
import com.laufu.dao.BlogDao;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	public List<Blog> getListBlog(Map<String, Object> map) {
		return blogDao.getListBlog(map);
	}

	public int insertBlog(Blog blog) {
		return blogDao.insertBlog(blog);
	}

	public int updateBlog(Blog blog) {
		return blogDao.updateBlog(blog);
	}

	public int deleteBlog(int id) {
		return blogDao.deleteBlog(id);
	}

	public Blog selectBlogById(int id) {
		return blogDao.selectBlogById(id);
	}

	public Blog getBlogByName(String name) {
		return blogDao.getBlogByName(name);
	}
}
