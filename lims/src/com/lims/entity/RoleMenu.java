package com.lims.entity;

import java.io.Serializable;

public class RoleMenu implements Serializable {

	/**
	 * 考虑到兼容性
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 角色id
	 */
	private int role;
	
	/**
	 * 菜单id
	 */
	private int menuId;
	
	/**
	 * 父菜单id
	 */
	private int parentId;

	public RoleMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleMenu(int role, int menuId, int parentId) {
		super();
		this.role = role;
		this.menuId = menuId;
		this.parentId = parentId;
	}



	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
}
