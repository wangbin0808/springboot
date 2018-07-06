package com.jrj.springboot.exception;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

/**
 * 
 * @author bin.wang
 * 这个一定要交给容器管理才起作用的，默认的错误机制的DefaultErrorAttributes就不会注册了，而是会
 * 注入我们的DefaultErrorAttributuesMyself
 */
@Component
public class DefaultErrorAttributuesMyself extends DefaultErrorAttributes{

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

		Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
		map.put("company", "jrj");//这个就是自己定义的信息
		return map;
	}

	
}
