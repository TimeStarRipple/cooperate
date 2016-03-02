package com.lims.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
/***
 *  Servlet上下文工具类
 * @ClassName: ServletActionContext 
 * @author wangfucai
 *  @date 2015年10月8日 上午10:00:06 
 * @version 1.0
 * Copyright © 2015 Egaotech Inc.All rights reserved.
 */
public class ServletActionContext {
	
	/**
	 * 获得请求request
	 * @return HttpServletRequest
	 */
	public static HttpServletRequest getRequest()
	{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		return request;
	}
	
	/**
	 * 获得response
	 * @return HttpServletRequest
	 */
	public static HttpServletResponse getResponse()
	{
		HttpServletResponse response = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
		
		return response;
	}
	
	/**
	 * 获得session
	 * @return HttpServletRequest
	 */
	public static HttpSession getSession()
	{
		return getRequest().getSession();
	}
}