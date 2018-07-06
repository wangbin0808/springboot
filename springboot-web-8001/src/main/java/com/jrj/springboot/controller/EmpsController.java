package com.jrj.springboot.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrj.springboot.dao.EmployeeDao;
import com.jrj.springboot.entities.Employee;

@Controller
public class EmpsController {
	
	@Autowired
	private EmployeeDao employeeDao;
	@RequestMapping("/list")
	public String list(Model model){
		Collection<Employee> collection = employeeDao.getAll();
		model.addAttribute("emps", collection);
		return "emps/list";
	}

}
