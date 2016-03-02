package com.lims.condition;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author zyb
 *
 */
public class RoleCondition implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String roleName;
	
	public RoleCondition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleCondition(String roleName) {
		super();
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String filterCondition(){
		StringBuilder sb=new StringBuilder();
		sb.append(" 1=1 ");
		
		if (StringUtils.isNotBlank(roleName)) {
			sb.append(" and role_name like '%").append(roleName.trim());
			sb.append("%'");
		}
		
		return sb.toString();
	}

}
