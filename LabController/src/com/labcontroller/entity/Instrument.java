package com.labcontroller.entity;

import java.io.Serializable;

/**
 * 仪器表
 * @author zhangyubin
 */
public class Instrument implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 仪器自动增加id
	 */
	private int id;
	
	/**
	 * 仪器数量
	 */
	private int number;
	
	/**
	 * 仪器名称
	 */
	private String name;
	
	public Instrument()
	{
		super();
	}

	public Instrument(int id, int number, String name) {
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
