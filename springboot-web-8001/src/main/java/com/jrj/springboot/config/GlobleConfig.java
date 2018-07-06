package com.jrj.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jrj.springboot.compone.MyLocaleResolver;
import com.jrj.springboot.interpter.MyInterpter;

@SuppressWarnings("deprecation")
@Configuration
public class GlobleConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/jrj").setViewName("success");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterpter())
		//.excludePathPatterns("/index.html","/","/user/login")
		.addPathPatterns("/main","/dashboard");
		//.addPathPatterns("/**");
	}
	@Bean
	public WebMvcConfigurerAdapter getWebMvcConfigurerAdapter(){
	 
		return new WebMvcConfigurerAdapter(){

			@Override
			public void addViewControllers(ViewControllerRegistry registry) {

//				registry.addViewController("/").setViewName("index");
//				registry.addViewController("/index.html").setViewName("index");
				registry.addViewController("/main").setViewName("dashboard");
			}


			
		};
	}
	

	
//	@Bean
//	public ViewResolver myselfViewResolver(){
//		return new MyViewResolver();
//	}
//	
//	private class MyViewResolver implements ViewResolver{
//
//		@Override
//		public View resolveViewName(String viewName, Locale locale) throws Exception {
//			return null;
//		}
//		
//	}

	
}
