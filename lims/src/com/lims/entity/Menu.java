package com.lims.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 菜单信息表
 * @author wangfucai
 * 2015-6-4
 */
public class Menu implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 自动增加ID
	 */
	private int id;
	
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
	/*
	 * 显示的顺序
	 */
	private int displayOrder;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Menu() {
		super();
	}
	
	public Menu(int id, String menuName, String menuUrl, int parentId,
			int displayOrder, Date createTime) {
		super();
		this.id = id;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.parentId = parentId;
		this.displayOrder = displayOrder;
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SysMenu [id=");
		builder.append(id);
		builder.append(", menuName=");
		builder.append(menuName);
		builder.append(", menuUrl=");
		builder.append(menuUrl);
		builder.append(", parentId=");
		builder.append(parentId);
		builder.append(", displayOrder=");
		builder.append(displayOrder);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Menu m=(Menu)obj;
		return id==m.id?true:false;
	}
}