package com.labcontroller.entity;

import java.io.Serializable;

/**
 * 耗材表
 * @author zhangyubin
 */
public class Consumable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 耗材自动增加id
	 */
	private int id;
	
	/**
	 * 耗材数量
	 */
	private int number;
	
	/**
	 * 耗材名称
	 */
	private String name;
	
	public Consumable()
	{
		super();
	}

	public Consumable(int id, int number, String name) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Consumable [id=" + id + ", number=" + number + ", name=" + name
				+ "]";
	}
	
}
