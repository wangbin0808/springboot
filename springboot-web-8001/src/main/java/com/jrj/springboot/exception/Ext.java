package com.jrj.springboot.exception;

import java.io.Serializable;

public class Ext implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	private String code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Ext(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}

	public Ext() {

	}

	@Override
	public String toString() {
		return "Ext [message=" + message + ", code=" + code + "]";
	}
	
}
