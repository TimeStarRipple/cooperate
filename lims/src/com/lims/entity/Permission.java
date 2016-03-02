package com.lims.entity;

import java.util.List;

/**
 * 系统用户权限
* @author wangfucai
* @date 2015年10月8日 下午6:05:48 
* @version 1.0
* Copyright © 2015 Egaotech Inc.All rights reserved.
 */
public class Permission implements java.io.Serializable{

	private static final long serialVersionUID = 1L; 
	
	/***
	 * 系统权限
	 */
	private String uid;
	
	/**
	 * 菜单ID
	 */
	private int menuId;
	
	/**
	 * 菜单名称
	 */
	private String menuName;
	
	/**
	 * 菜单URl
	 */
	private String menuUrl;
	
	/**
	 * 父类菜单
	 */
	private int parentId;
	
	private boolean hasMenu;
	
	public List<Permission> subMenu;
	
	public Permission() {
		super();
	}
	
	public Permission(String uid, int menuId, String menuName,
			String menuUrl, int parentId, boolean hasMenu,
			List<Permission> subMenu) {
		super();
		this.uid=uid;
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.parentId = parentId;
		this.hasMenu = hasMenu;
		this.subMenu = subMenu;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public boolean isHasMenu() {
		return hasMenu;
	}

	public void setHasMenu(boolean hasMenu) {
		this.hasMenu = hasMenu;
	}

	public List<Permission> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<Permission> subMenu) {
		this.subMenu = subMenu;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Permission [uid=");
		builder.append(uid);
		builder.append(", menuId=");
		builder.append(menuId);
		builder.append(", menuName=");
		builder.append(menuName);
		builder.append(", menuUrl=");
		builder.append(menuUrl);
		builder.append(", parentId=");
		builder.append(parentId);
		builder.append(", hasMenu=");
		builder.append(hasMenu);
		builder.append(", subMenu=");
		builder.append(subMenu);
		builder.append("]");
		return builder.toString();
	}
}