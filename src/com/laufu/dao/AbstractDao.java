package com.laufu.dao;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AbstractDao extends SqlMapClientDaoSupport {

	@Resource(name="sqlMapClient")
	public void setSuperSqlMapClientDaoSupport( ){
		
	}
}
