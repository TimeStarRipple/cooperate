package com.lims.condition;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class InstrumentConditon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 搜索的仪器名称
	 */
	private String instrumentName;

	public InstrumentConditon() {
		super();
	}

	public InstrumentConditon(String instrumentName) {
		super();
		this.instrumentName = instrumentName;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}
	
	public String filterCondition()
	{
		StringBuilder condition=new StringBuilder();
		condition.append(" 1=1 ");
		
		if(StringUtils.isNotBlank(instrumentName))
		{
			condition.append(" and instrument_name like '%").append(instrumentName.trim());
			condition.append("%'");
		}
		return condition.toString();
	}

}
