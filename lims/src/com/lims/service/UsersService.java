package com.lims.service;

import java.util.Date;

import com.lims.entity.Users;

public interface UsersService {

	public Users getUsersByUsername(String username);

	public void updateUsersLastAccessTime(Long id, Date date);

}
