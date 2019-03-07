package com.blog.springboot.pojo;

import java.util.Date;

public class Reply {
	private int id;
	private String reply_info;
	private Date time;
	private int posts_id;
	private int reply_user_id;
	private User user;

	public int getReply_user_id() {
		return reply_user_id;
	}

	public void setReply_user_id(int reply_user_id) {
		this.reply_user_id = reply_user_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReply_info() {
		return reply_info;
	}

	public void setReply_info(String reply_info) {
		this.reply_info = reply_info;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getPosts_id() {
		return posts_id;
	}

	public void setPosts_id(int posts_id) {
		this.posts_id = posts_id;
	}

}
