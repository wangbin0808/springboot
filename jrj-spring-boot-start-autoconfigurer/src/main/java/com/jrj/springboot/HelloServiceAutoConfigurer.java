package com.jrj.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class) //这个的意思是加入这个类
@ConditionalOnWebApplication //这个表示只有在web环境下才会配置
public class HelloServiceAutoConfigurer {
	
	@Autowired
	HelloServiceProperties  helloServiceProperties;
	
	@Bean
	public HelloService createHelloService(){
		HelloService service = new HelloService();
		service.setHelloServiceProperties(helloServiceProperties);
		return service;
	}

}
