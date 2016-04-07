package com.labcontroller.vo;

import java.io.Serializable;

/**
 * 产品类别树，用的是ztree
 * 以下vo,是根据ztree要求写的
 * @author didala
 * 2015年11月24日18:13:24
 */

public class SortTree implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private int id;
	
    private int pId;
	
	private String name;
	
	private boolean open;
	
	public SortTree() {
		super();
	}

	public SortTree(int id, int pId, String name, boolean open) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
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

	@Override
	public String toString() {
		return "SortTree [id=" + id + ", pId=" + pId + ", name=" + name
				+ ", open=" + open + "]";
	}

}
