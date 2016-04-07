package com.labcontroller.entity;

import java.io.Serializable;

/**
 * 用户的实验表，老师或者是学生的
 * @author zhangyubin
 */
public class UserLab implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 编辑id
	 */
	private int id;
	
	/**
	 * 用户id
	 */
	private int user_id;
	
	/**
	 * 实验id
	 */
	private int experiment_id;
	
	/**
	 * 用户类别，1为学生，2为老师，3为管理员
	 */
	private int sort;
	
	public UserLab()
	{
		super();
	}

	public UserLab(int id, int user_id, int experiment_id, int sort) {
		super();
		this.id=id;
		this.user_id = user_id;
		this.experiment_id = experiment_id;
		this.sort = sort;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getExperiment_id() {
		return experiment_id;
	}

	public void setExperiment_id(int experiment_id) {
		this.experiment_id = experiment_id;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "UserLab [id=" + id + ", user_id=" + user_id
				+ ", experiment_id=" + experiment_id + ", sort=" + sort + "]";
	}

}
