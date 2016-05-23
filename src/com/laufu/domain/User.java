package com.laufu.domain;

import java.io.Serializable;


public class User implements Serializable {
 

	private static final long serialVersionUID = 1L;
	private Integer id=0;
    private String username;
    private String password;
    private String email;
    private Integer roleId=0;
    
	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}

