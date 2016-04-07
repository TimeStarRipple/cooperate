package com.labcontroller.entity;

import java.io.Serializable;

/**
 * 实验室表
 * @author zhangyubin
 */
public class LabPlace implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 实验室ID自动增加
	 */
	private int id;
	
	/**
	 * 实验室名称
	 */
	private String name;
	
	/**
	 * 实验室最大人数
	 */
	private int max;
	
	public LabPlace()
	{
		super();
	}

	public LabPlace(int id, String name, int max) {
		super();
		this.id = id;
		this.name = name;
		this.max = max;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	@Override
	public String toString() {
		return "LabPlace [id=" + id + ", name=" + name + ", max=" + max + "]";
	}
	
}
