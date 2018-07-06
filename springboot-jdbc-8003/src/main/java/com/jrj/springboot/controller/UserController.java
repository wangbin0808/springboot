package com.jrj.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<Map<String, Object>> getList(){
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList("select * from department");
		return queryForList;
	}

}
