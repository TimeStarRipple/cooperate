package com.labcontroller.entity;

import java.io.Serializable;

/**
 * 公告表
 * @author zhangyubin
 */
public class Announcement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 公告自动增加id
	 */
	private int id;
	
	/**
	 * 公告名称
	 */
	private String name;
	
	/**
	 * '老师
	 */
	private  String teacher;
	
	/**
	 * 内容
	 */
	private  String text;
	
	/**
	 * 公告时间
	 */
	private String time;
	
	public Announcement()
	{
		super();
	}

	public Announcement(int id, String name, String teacher, String text,
			String time) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.text = text;
		this.time = time;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Announcement [id=" + id + ", name=" + name + ", teacher="
				+ teacher + ", text=" + text + ", time=" + time + "]";
	}
}
