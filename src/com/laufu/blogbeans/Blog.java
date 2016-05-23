package com.laufu.blogbeans;

import java.io.Serializable;
import java.util.Date;

import com.laufu.util.tools.StringUtil;
/**
 * 博客内容
 * @author Saturn
 *
 */
public class Blog  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 62717366001926512L;
	
	private int id ;
	/**
	 * 文章标题
	 */
	private String title ;
	/**
	 * 引用外部的url
	 */
	private String contextUrl = "" ;
	/**
	 * 引用外部的url
	 */
	private String imgUrl = "" ;
	/**
	 * 内容
	 */
	private String context ;
	/**
	 * 作者
	 */
	private String auther ;
	/**
	 * 用户id
	 */
	private int userId ;
	/**
	 * 文章分类
	 */
	private int category ;
	/**
	 * 角色（权限使用）
	 */
	private int roles;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 最后修改时间
	 */
	private Date lastModify;
	/**
	 * 描述信息
	 */
	private String describe;
	
	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Blog(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContextUrl() {
		return contextUrl;
	}
	public void setContextUrl(String contextUrl) {
		this.contextUrl = contextUrl;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getContext() {
		return StringUtil.specialcharsToHtml(context);
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getRoles() {
		return roles;
	}
	public void setRoles(int roles) {
		this.roles = roles;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastModify() {
		return lastModify;
	}
	public void setLastModify(Date lastModify) {
		this.lastModify = lastModify;
	}
}