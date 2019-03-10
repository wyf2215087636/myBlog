package com.blog.springboot.pojo;

import java.util.Date;

public class NewReply {

	private int id;
	private String username;
	private String useremail;
	private String reply_info;
	private Date time;
	private int posts_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
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
