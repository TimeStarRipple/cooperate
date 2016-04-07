package com.labcontroller.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labcontroller.service.impl.UserServiceImpl;
import com.labcontroller.dao.UserDao;
import com.labcontroller.entity.Users;
import com.labcontroller.service.UserService;

@Service(value="usersService")
public class UserServiceImpl implements UserService {

	private static final Logger logger=Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao usersDao;
	
	public Users getUsersByUserName(String username, int sort) {
		
		Users users= null;
		try 
		{
			users =usersDao.selectUserByUsername(username,sort);
		} 
		catch (Exception ex) {
			logger.error("[UsersServiceImpl][getUsersByUserName] username: "+ username + "sort:"+sort+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return users;
	}

}
