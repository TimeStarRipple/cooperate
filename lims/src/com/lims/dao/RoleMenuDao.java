package com.lims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lims.entity.Menu;
import com.lims.entity.RoleMenu;

public interface RoleMenuDao {

	public int selectRoleMenuCount(@Param("id")int id);

	public List<Menu> selectRoleMenuByRole(@Param("id")int id);

	public int deleteRoleMenuByRole(@Param("roleId")int roleId);

	public int insertRoleMenu(RoleMenu roleMenu);
	
}
