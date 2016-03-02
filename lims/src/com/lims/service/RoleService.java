package com.lims.service;

import java.util.List;

import com.lims.entity.Menu;
import com.lims.entity.Role;

public interface RoleService {

	public List<Role> listRoleByPage(String filterCondition, int currentPageNum,
			int currentPageSize);

	public int getPageCount(String filterCondition);

	public Role getRoleById(int id);

	public boolean addRole(Role role);

	public boolean updateRole(Role role);

	public List<Menu> listAllMenu();

	public int getRoleMenuCount(int id);

	public List<Menu> listCheckedMenuByRole(int id);

	public boolean clearRoleMenu(int roleId);

	public boolean addRoleMenu(String menuId, int roleId);

}
