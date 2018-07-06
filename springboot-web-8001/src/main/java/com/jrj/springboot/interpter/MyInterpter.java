package com.jrj.springboot.interpter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterpter implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("---MyInterpter");
		Object name= request.getSession().getAttribute("loginUser");
		if(name==null){
			request.getSession().setAttribute("msg", "你还没有登录，请登录后在访问");
			request.setAttribute("msg", "你还没有登录，请登录后在访问");
			request.getRequestDispatcher("/index.html").forward(request, response);

//			
//			response.sendRedirect("http://localhost:8001/"+"/index.html");
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
