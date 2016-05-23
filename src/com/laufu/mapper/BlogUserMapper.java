package com.laufu.mapper;

import com.laufu.blogbeans.BlogUser;

public interface BlogUserMapper {

//	@Select("select * from blog_user ")
	BlogUser loginBlog(BlogUser blogUser);
	
	
}
        