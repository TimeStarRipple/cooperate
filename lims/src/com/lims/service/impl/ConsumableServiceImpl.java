package com.lims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lims.dao.ConsumableDao;
import com.lims.entity.Consumable;
import com.lims.service.ConsumableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service(value="consumableService")
public class ConsumableServiceImpl implements ConsumableService {

	private static final Logger logger=LoggerFactory.getLogger(ConsumableServiceImpl.class);
	
	@Autowired
	private ConsumableDao consumableDao;
	
	public List<Consumable> listConsumableByPage(String filterCondition,
			int courrentPageNum, int courrentPageSize)
    {
		List<Consumable> listConsumable=null;
		try
		{
			listConsumable=consumableDao.selectConsumableByPage(filterCondition, courrentPageSize, courrentPageNum);
		}
		catch(Exception ex)
		{
			logger.error("[ConsumableServiceImpl][listConsumableByPage] filterCondition:"+filterCondition+" courrentPageSize:"+
		        courrentPageSize+" courrentPageNum:"+courrentPageNum+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return listConsumable;
	}

	public int getPageCount(String filterCondition) 
	{
		int result=0;
		try
		{
			result=consumableDao.selectPageCount(filterCondition);
		}
		catch(Exception ex)
		{
			logger.error("[ConsumableServiceImpl][getPageCount] filterCondition:"+filterCondition+"-"+ex.getLocalizedMessage()+":"+
		        ex.getMessage(),ex.getCause());
		}
		return result;
	}
}