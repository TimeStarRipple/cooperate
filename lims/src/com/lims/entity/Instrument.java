package com.lims.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 仪器表
 * @author zyb
 *
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
	
	/**
	 * 仪器描述
	 */
	private String desc;
	
	/**
	 * 仪器创建时间
	 */
	private Date createTime;
	
	public Instrument()
	{
		super();
	}
	
	public Instrument(int id, int number, String name, String desc,
			Date createTime) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.desc = desc;
		this.createTime = createTime;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Instrument [id=");
		builder.append(id);
		builder.append(", number=");
		builder.append(number);
		builder.append(", name=");
		builder.append(name);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}
}
