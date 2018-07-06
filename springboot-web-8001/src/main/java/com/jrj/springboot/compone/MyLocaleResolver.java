package com.jrj.springboot.compone;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
/**
 * 
 * @author bin.wang
 * 自定义，国际化的localeResolver
 * 也需要注册到容器里面，如果自己实现了的话，就不会使用springboot的
 *
 */
public class MyLocaleResolver implements LocaleResolver{

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String name = request.getParameter("local");
		Locale local=Locale.getDefault();
		if(!StringUtils.isEmpty(name)){//不为空的话
			String names[]=name.split("_");
			local=new Locale(names[0],names[1]);
		}
		return local;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		
	}

}
