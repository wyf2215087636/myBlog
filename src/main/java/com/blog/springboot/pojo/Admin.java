package com.blog.springboot.pojo;

import java.util.Date;

public class Admin {
	private String adminname;
	private String adminpass;
	private Date login_time;
	private String admin_img;
	
	public String getAdmin_img() {
		return admin_img;
	}
	public void setAdmin_img(String admin_img) {
		this.admin_img = admin_img;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpass() {
		return adminpass;
	}
	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}
	
	
}
