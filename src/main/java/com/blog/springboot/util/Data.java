package com.blog.springboot.util;

public class Data {
	private int code;
	private String message;

	public Data(int code, String message) {
		super();
		this.code = code;
		this.message = message;
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
