package com.blog.springboot.util;

public class Data {
	private int code;
	private String message;
	private String muiscer;
	private String muisc_url;
	

	public String getMuiscer() {
		return muiscer;
	}



	public void setMuiscer(String muiscer) {
		this.muiscer = muiscer;
	}



	public String getMuisc_url() {
		return muisc_url;
	}



	public void setMuisc_url(String muisc_url) {
		this.muisc_url = muisc_url;
	}



	public Data(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	

	public Data(int code, String message, String muiscer, String muisc_url) {
		super();
		this.code = code;
		this.message = message;
		this.muiscer = muiscer;
		this.muisc_url = muisc_url;
	}



	public void init(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public Data() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
