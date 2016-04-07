package com.labcontroller.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labcontroller.dao.AnnDao;
import com.labcontroller.entity.Announcement;
import com.labcontroller.service.AnnService;

@Service(value="annService")
public class AnnServiceImpl implements AnnService {
	
	private static final Logger logger=Logger.getLogger(AnnServiceImpl.class);
	
	@Autowired
	private AnnDao annDao;

	public int getPageCount() {
		int result=0;
		try 
		{
			result =annDao.selectPageCount();
		}
		catch (Exception ex) {
			logger.error("[AnnServiceImpl][getPageCount] "+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result;
	}

	public List<Announcement> listAnnByPage(int currentPageNum,
			int currentPageSize) {
		
		if(currentPageNum!=0)
		{
			currentPageNum=(currentPageNum-1)*currentPageSize;
		}
		List<Announcement> list= null;
		
		try 
		{
			list =annDao.selectAnnByPage(currentPageNum, currentPageSize);
		} catch (Exception ex) {
			logger.error("[AnnServiceImpl][listAnnByPage] pageNum: "+currentPageNum+"pageSize: "+currentPageSize+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
	}

	public Announcement getAnnById(int id) {
		Announcement ann=null;
		
		try 
		{
			ann =annDao.selectAnnById(id);
		} 
		catch (Exception ex) {
			logger.error("[AnnServiceImpl][getAnnById] id: "+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return ann;
	}

}
