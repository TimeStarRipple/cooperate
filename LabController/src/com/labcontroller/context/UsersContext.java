package com.labcontroller.context;

import com.labcontroller.constants.UsersConstant;
import com.labcontroller.entity.Users;


/**
 * 用户上下文
* @ClassName: UsersContext 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author 
* @date 2015年10月8日 上午10:10:53 
* @version 1.0
 */
public class UsersContext {
	
	/**
	 * 获得登录的用户对象 
	 * @return
	 */
	public static Users getLoginSys()
	{
		Users sysUsers=(Users)ServletActionContext.getRequest().getSession().getAttribute(UsersConstant.LOGIN_SESSION_USERS);
		return sysUsers;
	}
	
	/**
	 * 获得登录的管理员的ID
	 * @return
	 */
	public static int getLoginSysId()
	{
		return getLoginSys().getId();
	}
	
	public static String getLoginSysName()
	{
		return getLoginSys().getUsername();
	}
	
	/**
	 * 获得登录的用户类别
	 * @return int
	 */
	public static int getLoginSort()
	{
		Users sysUsers=(Users)ServletActionContext.getRequest().getSession().getAttribute(UsersConstant.LOGIN_SESSION_USERS);
		
		int sort=sysUsers.getSort();
		
		return sort;
	}
}