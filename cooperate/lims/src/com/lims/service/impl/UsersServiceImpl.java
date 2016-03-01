package com.lims.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lims.dao.UsersDao;
import com.lims.service.impl.UsersServiceImpl;
import com.lims.entity.Users;
import com.lims.service.UsersService;

@Service(value="usersService")
public class UsersServiceImpl implements UsersService {

private static final Logger logger=LoggerFactory.getLogger(UsersServiceImpl.class);
	
	@Autowired
	private UsersDao usersDao;
	
	public Users getUsersByUsername(String username) {
		Users users= null;
		try 
		{
			users =usersDao.selectUsersByUserName(username);
		} catch (Exception ex) {
			logger.error("[UsersServiceImpl][getUsersByUserName] username: "+ username + "-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return users;
	}

	public void updateUsersLastAccessTime(Long id, Date date) {
		// TODO Auto-generated method stub
		
	}

}
