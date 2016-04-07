package com.labcontroller.service;

import com.labcontroller.entity.Users;

public interface UserService {

	public Users getUsersByUserName(String username,int sort);
	
}
