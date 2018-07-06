package com.jrj.springboot.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrj.springboot.exception.UserException;

@Controller
public class TestController {
	
	@RequestMapping("/success")
	public String toSuccess(Map<String,String> map){
		map.put("user", "wangbin");
		return "success";
	}
	
	
	@RequestMapping("/user/login")
	public String toLogin(@RequestParam("username") String username,
			@RequestParam("password")String password,
			Map<String,String> map,
			HttpServletRequest request){
		if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
			request.getSession().setAttribute("loginUser", "登录");
			return "redirect:/main";
		}
		map.put("msg", "登录失败，密码或者用户名错误！！！");
		return "index";
	}
	
	@RequestMapping({"/index.html","/"})
	public String toIndex(){
		
		return "index";
	}
	

	@RequestMapping("exception")
	public String toException(){
		throw new UserException();
	}
	
}
