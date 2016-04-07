package com.labcontroller.constants;


/**
 * 主要记录一些日志状态
* @ClassName: StatusEnum 
* @author wangfucai
* @date 2015年9月30日 上午9:02:01 
* @version 1.0
* Copyright © 2015 Egaotech Inc.All rights reserved.
 */
public enum StatusEnum {

	SUCCESS(1,"成功"),
	FAILURE(0,"失败");
	
	private int status;
	
	private String desc;
	
	private StatusEnum(int status,String desc) 
	{
		this.status=status;
		this.desc=desc;
	}
	
	public int getStatus() {
		return status;
	}

	public String getDesc() {
		return desc;
	}
	
	public static void main(String[] args) {
		System.out.println(StatusEnum.SUCCESS.status);
	}
}
