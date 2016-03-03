package com.lims.condition;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class ConsumableCondition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 查询的耗材名
	 */
	private String consumableName;

	public ConsumableCondition() 
	{
		super();
	}

	public ConsumableCondition(String consumableName) 
	{
		super();
		this.consumableName = consumableName;
	}

	public String getConsumableName() {
		return consumableName;
	}

	public void setConsumableName(String consumableName) {
		this.consumableName = consumableName;
	}
	
	public String filterCondition()
	{
		StringBuilder condition=new StringBuilder();
		condition.append(" 1=1 ");
		
		if(StringUtils.isNotBlank(consumableName))
		{
			condition.append(" and consumable_name like '%").append(consumableName.trim());
			condition.append("%'");
		}
		return condition.toString();
	}
	

}
