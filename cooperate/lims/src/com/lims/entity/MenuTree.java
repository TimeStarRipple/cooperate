package com.lims.entity;  

import java.io.Serializable;
/**   
 *  角色树，用的是ztree
 * 以下vo,是根据ztree要求写的
 * 
 * @ClassName: MenuTree
 * @author Jincan
 * @date 2016-1-14 下午2:16:58 
 * @version V1.0   
 * Copyright  2015 Egaotech Inc.All rights reserved.
 */
public class MenuTree implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private int pId;
	
	private String name;
	
	private boolean open;
	
	private boolean checked;

	public MenuTree() {
		super();
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public MenuTree(int id, int pId, String name, boolean open, boolean checked) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.checked = checked;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeptTree [id=");
		builder.append(id);
		builder.append(", pId=");
		builder.append(pId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", open=");
		builder.append(open);
		builder.append(", checked=");
		builder.append(checked);
		builder.append("]");
		return builder.toString();
	}
}
