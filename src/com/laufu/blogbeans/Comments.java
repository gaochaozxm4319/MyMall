package com.laufu.blogbeans;

import java.util.Date;

/**
 * 评论表
 * @author Saturn
 *
 */
public class Comments {

	private int id ;
	/**
	 * 用户id
	 */
	private int userId ;
	/**
	 * 评论博客的id
	 */
	private int blogId ;
	/**
	 * 评论时间
	 */
	private Date commentTime;
	/**
	 * 引用的评论
	 */
	private String referenceComments ;
	/**
	 * 评论内容
	 */
	private String context ;
	/**
	 * 点赞数
	 */
	private int success;
	/**
	 * 踩
	 */
	private int failure;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public String getReferenceComments() {
		return referenceComments;
	}
	public void setReferenceComments(String referenceComments) {
		this.referenceComments = referenceComments;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public int getFailure() {
		return failure;
	}
	public void setFailure(int failure) {
		this.failure = failure;
	}
}
