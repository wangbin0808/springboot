package com.jrj.springboot.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import com.jrj.springboot.compone.MyLocaleResolver;
import com.jrj.springboot.filter.MyFilter;
import com.jrj.springboot.listen.MyListence;
import com.jrj.springboot.servlet.MyServlet;

@Configuration
public class BeanConfig {
	
	//注册三大组件
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean getServlet(){
		ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet(),"/myservlet");
		bean.setOrder(1);//这里可以注册启动优先级
		return bean;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean<MyFilter> getFilter(){
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new MyFilter());
		bean.setUrlPatterns(Arrays.asList("/hello","/myfilter"));
		return bean;
	}
	
	@Bean
	public ServletListenerRegistrationBean<MyListence> getListener(){
		
		return new ServletListenerRegistrationBean<MyListence>(new MyListence());
	}
	
	
	
	@Bean 
	public LocaleResolver getLocaleResolver(){
		return new MyLocaleResolver();
	}

}
