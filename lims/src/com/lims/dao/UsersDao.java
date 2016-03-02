package com.lims.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.lims.entity.Users;

public interface UsersDao {
	
	public Users selectUsersByUserName(@Param("username")String username);
	
	public Users selectUsersById(@Param("id")long id);
	
	public int updateUsersLastAccessTime(@Param("id") long id,@Param("lastAccessTime") Date date);
	
}
