package com.labcontroller.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户日志
* @ClassName: SysUsersLog 
* @author wangfucai
* @date 2015年9月29日 下午3:39:54 
* @version 1.0
* Copyright © 2015 Egaotech Inc.All rights reserved.
 */
public class UsersLog implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 自动增加ID
	 */
	private int id;
	
	/**
	 *  用户的ID
	 */
	private int usersid;
	
	/**
	 * 用户名称
	 */
	private String username;
	
	/**
	 * 中文名称
	 */
	private String cnname;
	
	/**
	 * IP地址
	 */
	private String ip;
	
	/**
	 * 浏览器
	 */
	private String browser;
	
	/**
	 * 操作系统
	 */
	private String os;
	/**
	 * 省
	 */
	private String province;
	
	/**
	 * 市
	 */
	private String city;
	
	/**
	 * 登录状态
	 */
	private int status;
	
	/**
	 * 记录创建时间
	 */
	private Date createtime;

	public UsersLog() {
		super();
	}

	public UsersLog(int id, int usersid, String username, String cnname,
			String ip, String browser, String os, String province, String city,
			int status, Date createtime) {
		super();
		this.id = id;
		this.usersid = usersid;
		this.username = username;
		this.cnname = cnname;
		this.ip = ip;
		this.browser = browser;
		this.os = os;
		this.province = province;
		this.city = city;
		this.status = status;
		this.createtime = createtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsersid() {
		return usersid;
	}

	public void setUsersid(int usersid) {
		this.usersid = usersid;
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SysUsersLog [id=");
		builder.append(id);
		builder.append(", usersid=");
		builder.append(usersid);
		builder.append(", username=");
		builder.append(username);
		builder.append(", cnname=");
		builder.append(cnname);
		builder.append(", ip=");
		builder.append(ip);
		builder.append(", browser=");
		builder.append(browser);
		builder.append(", os=");
		builder.append(os);
		builder.append(", province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append(", status=");
		builder.append(status);
		builder.append(", createtime=");
		builder.append(createtime);
		builder.append("]");
		return builder.toString();
	}
}
