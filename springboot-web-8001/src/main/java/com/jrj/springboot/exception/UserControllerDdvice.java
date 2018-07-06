package com.jrj.springboot.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UserControllerDdvice {
	
/*	@ResponseBody
	@ExceptionHandler(UserException.class)
	public Map<String, Object> handler(Exception e){
		Map<String, Object> map =new HashMap<>();
		Ext etx=new Ext("ext_有错误","etc_code");
		map.put("username", "abinuu");
		map.put("error", "UserException");
		map.put("ext", etx);
		map.put("message", e.getMessage());
		return map;
	}*/
	
	
	@ExceptionHandler(UserException.class)
	public String handler(Exception e,HttpServletRequest request){
		Map<String, Object> map =new HashMap<>();
		Ext etx=new Ext("ext_有错误","etc_code");
		map.put("username", "abinuu");
		map.put("error", "UserException");
		map.put("ext", etx);
		map.put("message", e.getMessage());
		/**
		 * 一定自己设置状态码，才会走哪个错误的处理机制的，
		 */
		request.setAttribute("map", map);
		request.setAttribute("javax.servlet.error.status_code", 500);
		return "forward:/error";
	}

}
