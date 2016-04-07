package com.labcontroller.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.labcontroller.constants.JsonResult;
import com.labcontroller.constants.ResultCode;
import com.labcontroller.constants.UsersConstant;
import com.labcontroller.entity.Users;
import com.labcontroller.service.UserService;
/***
 * 登陆
 * @author  zhangyubin
 * 2015-12-22
 */
@Controller
public class LoginController extends BaseController
{

	private static final Logger logger=Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService usersService;
	
	/***
	 * 用户的登陆
	 * @param user
	 * @param request
	 * @return json格式的对象
	 */
	
	@RequestMapping(value="/login",method={RequestMethod.GET})
	public String showLogin(HttpServletRequest request,HttpServletResponse response) 
	{
		return "login";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/login",method={RequestMethod.POST})
	public Object login(HttpServletRequest request,HttpServletResponse response) 
	{
		//基本参数检查
		String username=this.getNotNull("username", request);
				
		String password=this.getNotNull("password", request);
		
		String sortString=request.getParameter("userkind");
		
		int sort = 0;
		
		if(sortString.equals("student"))
		{
			sort = 1;
		}
		else if(sortString.equals("teacher"))
		{
			sort = 2;
		}
		else
		{
			sort = 3;
		}
			
				
		//String code=this.getNotNull("code", request);
				
		if(StringUtils.isBlank(username) || StringUtils.isBlank(password))//|| StringUtils.isBlank(code))
		{
			logger.info("[LoginController][login] username:" +username +" password: " +password);// +" code:" +code);
			return new JsonResult(ResultCode.RETURN_FAILURE,"用户名或者密码为空","");
		}
				
		/*比对验证码
		String sessionCode=(String)request.getSession().getAttribute(UsersConstant.SESSION_SECURITY_CODE);
				
		if(!code.equalsIgnoreCase(sessionCode))
		{
			return new JsonResult(ResultCode.RETURN_FAILURE,"验证码不正确","");
		}
		*/		
		Users users=this.usersService.getUsersByUserName(username,sort);
			
		if(users==null)
		{
			return new JsonResult(ResultCode.RETURN_FAILURE,"用户名不存在","");
		}
				
		if(!users.getPassword().equals(password))
		{
			return new JsonResult(ResultCode.RETURN_FAILURE,"登陆的密码错误","");
		}
				
		//登录成功，创建session
		request.getSession().setAttribute(UsersConstant.LOGIN_SESSION_USERS,users);
			
		Map<String,String> paramMap=new HashMap<String,String>();
		
		if(sort==1)
		{
			paramMap.put("url",request.getContextPath()+"/stuAnn/listAnn");
		}
		else if(sort==2)
		{
			paramMap.put("url",request.getContextPath()+"/tcAnn/listAnn");
		}
		else if(sort==3)
		{
			paramMap.put("url",request.getContextPath()+"/adminLab/listTestLab");
		}

		return new JsonResult(ResultCode.RETURN_SUCCESS,"登陆成功",paramMap);
	}
	
	/**
	 * 用户注销
	 * @param session
	 * @return
	 */
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.removeAttribute(UsersConstant.LOGIN_SESSION_USERS);
		return "redirect:/login.html"; 
	}
	
}
