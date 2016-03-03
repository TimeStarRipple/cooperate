package com.lims.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lims.entity.Permission;
import com.lims.utils.EncryptUtil;
import com.lims.constants.JsonResult;
import com.lims.constants.ResultCode;
import com.lims.constants.UsersConstant;
import com.lims.constants.UsersStatus;
import com.lims.entity.Users;
import com.lims.service.PermissionService;
import com.lims.service.UsersService;

/***
 * 登陆
 * @author zhangyubin
 * 2016-2-27
 */
@Controller
public class LoginController extends BaseController{
	
	private static final Logger logger=LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private PermissionService permissionService;
	
	@ResponseBody
	@RequestMapping(value="/login",method={RequestMethod.POST})
	public Object login(HttpServletRequest request,HttpServletResponse response)
	{
		//基本参数检查
		String username=this.getNotNull("username", request);				
		String password=this.getNotNull("password", request);
		
		if(StringUtils.isBlank(username)||StringUtils.isBlank(password))
		{
			logger.info("[LoginController][login] username:" + username +" password: " + password );
			
			return new JsonResult(ResultCode.RETURN_FAILURE,"用户名或密码为空","");
		}
		
		Users users=usersService.getUsersByUsername(username);
		
		if(users.equals(null))
		{
			return new JsonResult(ResultCode.RETURN_FAILURE,"用户名不存在","");
		}
		if(users.getStatus()==UsersStatus.FORBIDDEN.getStatus())
		{
			return new JsonResult(ResultCode.RETURN_FAILURE,"账号已经被禁用,请联系系统管理员","");			
		}
		
		if(!EncryptUtil.getMD5(password).equalsIgnoreCase(users.getPassword()))
		{
			return new JsonResult(ResultCode.RETURN_FAILURE,"登陆的密码错误","");
		}
		
		//加载权限菜单
		int role=users.getRole();				                             
		int pid=0;
		
		List<Permission> listPermission=this.permissionService.getUsersPermissionByRole(role,pid);
		
		if(listPermission==null||listPermission.size()==0)
		{
			return new JsonResult(ResultCode.RETURN_FAILURE,"该用户没有权限,请先配置权限",""); 
		}
		
		//登录成功，创建session
		request.getSession().setAttribute(UsersConstant.LOGIN_SESSION_USERS,users);
				
		//登录成功,加载权限
		request.getSession().setAttribute(UsersConstant.LOGIN_SESSION_USERS_PERMISSION,listPermission);
		
		//更新用户访问最新时间
		this.usersService.updateUsersLastAccessTime(users.getId(),new Date());
		
		Map<String,String> paramMap=new HashMap<String,String>();		
		paramMap.put("url",request.getContextPath()+"/index");
		
		return new JsonResult(ResultCode.RETURN_SUCCESS,"登陆成功",paramMap);
	}
	
	@RequestMapping(value="/login",method={RequestMethod.GET})
	public String loginRequest(HttpServletRequest request,Model model)
	{
		return "/login";
	}
	
	/**
	 * 用户注销
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logout",method={RequestMethod.GET,RequestMethod.POST})
	public String logout(HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		//注销session
		session.removeAttribute(UsersConstant.LOGIN_SESSION_USERS);
		session.removeAttribute(UsersConstant.LOGIN_SESSION_USERS_PERMISSION);
		session.invalidate();
		return "redirect:/login.jsp";
	}
	
}
