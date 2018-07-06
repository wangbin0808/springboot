package com.jrj.springboot.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListence implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized---web启动");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed---web销毁");
		
	}

}
