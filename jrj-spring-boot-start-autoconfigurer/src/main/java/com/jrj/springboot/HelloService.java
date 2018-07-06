package com.jrj.springboot;

public class HelloService {
	

	public HelloServiceProperties getHelloServiceProperties() {
		return helloServiceProperties;
	}

	public void setHelloServiceProperties(HelloServiceProperties helloServiceProperties) {
		this.helloServiceProperties = helloServiceProperties;
	}

	HelloServiceProperties helloServiceProperties;
	
	public void say(String name){
		System.out.println(helloServiceProperties.getPrefix()+"_"+
				name+"_"+helloServiceProperties.getSuffix());
	}
	

}
