package com.laufu.blogbeans;

import java.io.Serializable;
/**
 * 博客用户
 * @author Samsung
 *
 */
public class BlogUser implements Serializable{

	/**
	 * 序列码
	 */
	private static final long serialVersionUID = 1L;
	
	private int id ; 
	/**
	 * 登录名
	 */
	private String account ;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 用户昵称
	 */
	private String userName ;
	/**
	 * 是否启用
	 */
	private int isEnable ;
	/**
	 * 注册邮箱
	 */
	private String email ;
	/**
	 * 兴趣爱好
	 */
	private String intresst ;
	/**
	 * 用户好友
	 */
	private String userFriend ;
	/**
	 * 用户角色（权限使用）
	 */
	private int roles ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIntresst() {
		return intresst;
	}
	public void setIntresst(String intresst) {
		this.intresst = intresst;
	}
	public String getUserFriend() {
		return userFriend;
	}
	public void setUserFriend(String userFriend) {
		this.userFriend = userFriend;
	}
	public int getRoles() {
		return roles;
	}
	public void setRoles(int roles) {
		this.roles = roles;
	}
}
/*
 * `account` varchar(128) NOT NULL,
  `user_name` varchar(128) NOT NULL,
  `isenable` int(11) NOT NULL,
  `create_time` date DEFAULT NULL,
  `roles` int(11) DEFAULT NULL,
  `passwords` varchar(56) NOT NULL,
  `email` varchar(56) DEFAULT NULL,
  `intresst` varchar(128) DEFAULT NULL,
  `user_friend` varchar(256) DEFAULT NULL COMMENT '用户好友',
  PRIMARY KEY (`id`)*/