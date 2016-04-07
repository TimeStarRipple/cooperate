package com.labcontroller.dao;

import org.apache.ibatis.annotations.Param;

import com.labcontroller.entity.Users;

public interface UserDao {

	public Users selectUserByUsername(@Param("usernumber")String usernumber,@Param("sort")int sort);
	
}
