package com.jrj.springboot.exception;

public class UserException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -726156702708334311L;

	public UserException() {
		super("用户不存在");
		
	}	
}
