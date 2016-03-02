package com.lims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lims.entity.Permission;

public interface UsersPermissionDao {

	public List<Permission> selectUsersPermissionByRole(@Param("role")int role,@Param("pid")int pid);
	
}
