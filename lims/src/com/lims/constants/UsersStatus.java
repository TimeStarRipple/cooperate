package com.lims.constants;

/**
 * 管理员状态
 * @ClassName: UsersStatus 
 * @author wangfucai
 * @date 2015年10月8日 下午4:26:34 
 * @version 1.0
 * Copyright © 2015 Egaotech Inc.All rights reserved.
 */
public enum UsersStatus {

		ENABLE(0,"启用"),
		FORBIDDEN(-1,"禁用");
		
		private int status;
		
		private String desc;
		
		private UsersStatus(int status,String desc) 
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
}