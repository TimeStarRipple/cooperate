package com.labcontroller.entity;

import java.io.Serializable;

/**
 * 预约实验表
 * @author zhangyubin
 */

public class OrderLab implements Serializable {
	
	private static final long serialVersionUID = 1L;


	/**
	 * 预约实验自动增加ID
	 */
	private int id;
	
	/**
	 * 预约实验名称
	 */
	private String name;
	
	/**
	 * 老师
	 */
	private  String teacher;
	
	/**
	 * 预约实验地点
	 */
	private String place;
	
	/**
	 * 预约实验的状态，1为待审核，2为通过，3为结束。
	 */
	private int sort;
	
	/**
	 * 实验日期
	 */
	private String date;
	
	/**
	 * 实验时间
	 */
	private String time;
	
	/**
	 * 实验结束时间
	 */
	private String over;
	
	/**
	 * 实验室最大人数
	 */
	private int max;
	
	/**
	 * 实验室现有报名人数
	 */
	private int number;
	
	/**
	 * 仪器id
	 */
	private int instr_id;
	
	/**
	 * 仪器名称
	 */
	private String instr_name;
	
	/**
	 * 仪器数量
	 */
	private int instr_number;
	
	/**
	 * 耗材id
	 */
	private int consum_id;
	
	/**
	 * 耗材数量
	 */
	private int consum_number;
	
	/**
	 * 耗材名称
	 */
	private String consum_name;
	
	public OrderLab() {
		super();
	}

	public OrderLab(int id, String name, String teacher, String place,
			int sort, String date, String time, String over, int max,
			int number, int instr_id, int instr_number, int consum_id,
			int consum_number) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.place = place;
		this.sort = sort;
		this.date = date;
		this.time = time;
		this.over = over;
		this.max = max;
		this.number = number;
		this.instr_id = instr_id;
		this.instr_number = instr_number;
		this.consum_id = consum_id;
		this.consum_number = consum_number;
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

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getOver() {
		return over;
	}

	public void setOver(String over) {
		this.over = over;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getInstr_id() {
		return instr_id;
	}

	public void setInstr_id(int instr_id) {
		this.instr_id = instr_id;
	}

	public int getInstr_number() {
		return instr_number;
	}

	public void setInstr_number(int instr_number) {
		this.instr_number = instr_number;
	}

	public int getConsum_id() {
		return consum_id;
	}

	public void setConsum_id(int consum_id) {
		this.consum_id = consum_id;
	}

	public int getConsum_number() {
		return consum_number;
	}

	public void setConsum_number(int consum_number) {
		this.consum_number = consum_number;
	}

	public String getInstr_name() {
		return instr_name;
	}

	public void setInstr_name(String instr_name) {
		this.instr_name = instr_name;
	}

	public String getConsum_name() {
		return consum_name;
	}

	public void setConsum_name(String consum_name) {
		this.consum_name = consum_name;
	}

	@Override
	public String toString() {
		return "OrderLab [id=" + id + ", name=" + name + ", teacher=" + teacher
				+ ", place=" + place + ", sort=" + sort + ", date=" + date
				+ ", time=" + time + ", over=" + over + ", max=" + max
				+ ", number=" + number + ", instr_id=" + instr_id
				+ ", instr_number=" + instr_number + ", consum_id=" + consum_id
				+ ", consum_number=" + consum_number + "]";
	}
	
}
