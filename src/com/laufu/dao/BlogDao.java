package com.laufu.dao;

import java.util.List;
import java.util.Map;

import com.laufu.blogbeans.Blog;

public interface BlogDao {
	
	List<Blog>getListBlog(Map<String, Object> map);
	
	int insertBlog(Blog blog );
	
	int updateBlog(Blog blog);
	
	int deleteBlog(int id);
	
	Blog selectBlogById(int id);
	
	Blog getBlogByName(String name);
}
