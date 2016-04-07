package com.labcontroller.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labcontroller.dao.ConsumDao;
import com.labcontroller.entity.Consumable;
import com.labcontroller.service.AdminConsumService;

@Service(value="adConService")
public class AdminConsumServiceImpl implements AdminConsumService {
	
	private static final Logger logger=Logger.getLogger(AdminConsumServiceImpl.class);
	
	@Autowired
	private ConsumDao consumDao;

	public List<Consumable> listConByPage(int currentPageNum,
			int currentPageSize) {
		if(currentPageNum!=0)
		{
			currentPageNum=(currentPageNum-1)*currentPageSize;
		}
		
		List<Consumable> list= null;
		try 
		{
			list =consumDao.selectConsumByPage(currentPageNum, currentPageSize);
		} 
		catch (Exception ex) {
			logger.error("[AdminConsumServiceImpl][listConByPage] pageNum: "+currentPageNum+"pageSize: "+currentPageSize+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
	}

	public int getPageCount() {
		int result=0;
		try 
		{
			result =consumDao.selectPageCount();
		}
		catch (Exception ex) {
			logger.error("[AdminConsumServiceImpl][getPageCount] "+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result;
	}

	public boolean addCon(Consumable con) {
		int result=0;
		try
		{
			result=consumDao.addCon(con);
		}
		catch(Exception ex){
			logger.error("[AdminConsumServiceImpl][addCou] Consumable:"+con+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

	public Consumable getConsumById(int id) {
		Consumable consum=null;
		try 
		{
			consum =consumDao.selectConsumById(id);
		} catch (Exception ex) {
			logger.error("[AdminConsumServiceImpl][updateCon] id: "+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return consum;
	}

	public boolean updateConsum(Consumable consum) {
		int result=0;
		try 
		{
			result =consumDao.updateCon(consum);
		} catch (Exception ex) {
			logger.error("[AdminConsumServiceImpl][updateCon] consum: "+consum+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

	public boolean deleteConById(int id) {
		int result=0;
		try 
		{
			result =consumDao.deleteConById(id);
		} catch (Exception ex) {
			logger.error("[AdminConsumServiceImpl][deleteConById]id: "+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

}
