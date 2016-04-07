package com.labcontroller.entity;

import java.io.Serializable;

/**
 * 用户信息基本表
 * @author zhangyubin
 * 2015-12-22
 */

public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 自动增加ID
	 */
	private int id;
	
	/**
	 * 用户名
	 */
	private String usernumber;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 中文名称
	 */
	private String username;
	
	/**
	 * 用户类型，1为学生，2为老师，3为管理员
	 */
	private int sort;

	public Users() {
		super();
	}
	
	public Users(int id, String usernumber, String password, String username,
			int sort) {
		super();
		this.id = id;
		this.usernumber = usernumber;
		this.password = password;
		this.username = username;
		this.sort = sort;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", usernumber=" + usernumber + ", password="
				+ password + ", username=" + username + ", sort=" + sort + "]";
	}
	
	
	
}
