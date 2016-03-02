package com.lims.entity;  

import java.io.Serializable;
import java.util.Date;
/**   
 *
 * 学生信息表
 *
 * @ClassName: Student
 * @author Lanxu
 * @date 2015年12月22日 下午2:50:21 
 * @version V1.0   
 * Copyright © 2015 Egaotech Inc.All rights reserved.
 */
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	//学生姓名
	private String username;
	
	//登陆密码
	private String password;
	
	//中文姓名
	private String cnname;
	
	//登陆手机号码
	private String phone;
	
	//学生性别，默认男
	private String gender;
	
	//用户角色
	private int role;
	
	//学生状态，默认0表示可用，-1表示不可用。
	private int status;
	
	//创建时间
	private Date createTime;

	//上次访时间
	private Date lastAccessTime;

	public Users() {
		super();
	}

	public Users(long id, String username, String password, String cnname,
			String phone, String gender, int role, int status, Date createTime,
			Date lastAccessTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.cnname = cnname;
		this.phone = phone;
		this.gender = gender;
		this.role = role;
		this.status = status;
		this.createTime = createTime;
		this.lastAccessTime = lastAccessTime;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCnname() {
		return cnname;
	}

	public void setCnname(String cnname) {
		this.cnname = cnname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password="
				+ password + ", cnname=" + cnname + ", phone=" + phone
				+ ", gender=" + gender + ", role=" + role + ", status="
				+ status + ", createTime=" + createTime + ", lastAccessTime="
				+ lastAccessTime + "]";
	}
	
}