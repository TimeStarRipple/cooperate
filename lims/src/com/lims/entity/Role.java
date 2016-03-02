package com.lims.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author zyb
 *
 */
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 角色编号
	 */
	private int role;
	
	/**
	 * 角色名
	 */
	private String roleName;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 角色类型
	 */
	private int roleType;
	
	/**
	 * 角色描述
	 */
	private String roleDesc;
	
	public Role() {
		super();
	}
	
	public Role(int role, String roleName, Date createDate, int roleType,
			String roleDesc) {
		super();
		this.role = role;
		this.roleName = roleName;
		this.createDate = createDate;
		this.roleType = roleType;
		this.roleDesc = roleDesc;
	}

	public int getRoleType() {
		return roleType;
	}

	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [role=");
		builder.append(role);
		builder.append(", roleName=");
		builder.append(roleName);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", roleType=");
		builder.append(roleType);
		builder.append(", roleDesc=");
		builder.append(roleDesc);
		builder.append("]");
		return builder.toString();
	}

}