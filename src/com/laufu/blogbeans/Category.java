package com.laufu.blogbeans;

import java.util.Date;
/**
 * 分类表
 * @author Saturn
 *
 */
public class Category {

	private int id;
	
	private String name;
	
	private Date createTime;
	
	private int roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getRoles() {
		return roles;
	}

	public void setRoles(int roles) {
		this.roles = roles;
	}
}
