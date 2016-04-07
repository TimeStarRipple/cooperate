package com.labcontroller.entity;

import java.io.Serializable;

public class TcAnn implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 编辑id
	 */
	private int id;
	/**
	 * 老师id
	 */
	private int user_id;
	
	/**
	 * 公告id
	 */
	private int ann_id;
	
	public TcAnn()
	{
		super();
	}

	public TcAnn(int id, int user_id, int ann_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.ann_id = ann_id;
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

	public int getAnn_id() {
		return ann_id;
	}

	public void setAnn_id(int ann_id) {
		this.ann_id = ann_id;
	}

	@Override
	public String toString() {
		return "TcAnn [id=" + id + ", user_id=" + user_id + ", ann_id="
				+ ann_id + "]";
	}

}
