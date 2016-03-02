package com.lims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lims.entity.Role;

/**
 * 
 * @author zyb
 *
 */
public interface RoleDao {

	public List<Role> selectRoleByPage(@Param("query")String query, @Param("pageNum")int pageNum, @Param("pageSize")int pageSize);
	
	public int selectPageCount(@Param("query")String query);
	
	public int insertRole(Role role);
	
	public int insertRoleMenu(@Param("role")int role,@Param("menuId")int menuId,@Param("parentId")int parentId);

	public Role selectRoleById(@Param("id")int id);

	public int updateRole(Role role);
}
