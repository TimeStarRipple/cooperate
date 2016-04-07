package com.labcontroller.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.labcontroller.constants.UsersConstant;
import com.labcontroller.entity.Users;
/**
 * 基本控制层
 * @author 
 * 2015-6-12
 */
public class BaseController {
	
	public Users getCurrentLoginUsers(HttpServletRequest request)
	{
		Users users=(Users)request.getSession().getAttribute(UsersConstant.LOGIN_SESSION_USERS);
		return users;
	}
	
	public int getCurrentLoginUsersId(HttpServletRequest request)
	{
		Users users=(Users)request.getSession().getAttribute(UsersConstant.LOGIN_SESSION_USERS);
		
		return users.getId();
	}
	
	public String getCurrentLoginUserName(HttpServletRequest request)
	{
		Users users=(Users)request.getSession().getAttribute(UsersConstant.LOGIN_SESSION_USERS);
		
		return users.getUsername();
	}
	
	public String getNotNull(String key, HttpServletRequest req) {
		String value = req.getParameter(key);
		return (value == null ? "" : value.trim());
	}
	
	//分页相关
	public int getPageNum(HttpServletRequest request) {
		int currentPageNum=0;
		try
		{
			String pageNum =this.getNotNull("page_num", request);
			if(StringUtils.isBlank(pageNum))
			{
				return currentPageNum;
			}
			currentPageNum=Integer.parseInt(pageNum);
		} catch (NumberFormatException ne)
		{
			return currentPageNum;
		}
		return currentPageNum;
	}
	
	public int getPageSize(HttpServletRequest request) 
	{
		int currentPageSize=10;
		
		String pageSize=this.getNotNull("page_size", request);
		
		if(StringUtils.isBlank(pageSize))
		{
			return currentPageSize;
		}
		try
		{
			return Integer.parseInt(pageSize);
		} catch (NumberFormatException ne) {
			return currentPageSize;
		}
	}

}
