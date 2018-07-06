package com.jrj.springboot.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class GlobleConfig {
	
	@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	public DataSource getDataSource(){
		return new DruidDataSource();
	}
	
    //配置Druid的监控
    //1、配置一个管理后台的Servlet
	@Bean
	public ServletRegistrationBean<StatViewServlet> createStatViewServlet(){
		ServletRegistrationBean servlet
			=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		Map<String, String> map=new HashMap<>();
		map.put("loginUsername", "wangbin");
		map.put("loginPassword", "123456");
		map.put("allow", "");//默认就是允许所有访问
		map.put("deny", "localhost");
		servlet.setInitParameters(map);
		return servlet;
		
	}
	
	/**
	 * 注册拦截器
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<Filter> create(){
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new WebStatFilter());
		Map<String, Object> initParameters=new HashMap<>();
		initParameters.put("exclusions", "/druid/*");
		bean.setInitParameters(initParameters);
		bean.setUrlPatterns(Arrays.asList("/*"));
		return bean;
	}

}
