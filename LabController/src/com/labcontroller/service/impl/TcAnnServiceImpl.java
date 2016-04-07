package com.labcontroller.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labcontroller.dao.AnnDao;
import com.labcontroller.dao.TcAnnDao;
import com.labcontroller.entity.Announcement;
import com.labcontroller.entity.TcAnn;
import com.labcontroller.service.TcAnnService;

@Service(value="tcAnnService")
public class TcAnnServiceImpl implements TcAnnService {
	
	private static final Logger logger=Logger.getLogger(TcAnnServiceImpl.class);
	
	@Autowired
	private AnnDao annDao;
	
	@Autowired
	private TcAnnDao tcAnnDao;

	public List<Announcement> listAnnByPage(int currentPageNum,
			int currentPageSize, int user_id) {
		
		if(currentPageNum!=0)
		{
			currentPageNum=(currentPageNum-1)*currentPageSize;
		}
		List<Announcement> list= null;
		
		try 
		{
			list =annDao.selectTcAnnByPage(currentPageNum, currentPageSize,user_id);
		} catch (Exception ex) {
			logger.error("[TcAnnServiceImpl][listAnnByPage] pageNum: "+currentPageNum+"pageSize: "+currentPageSize+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
	}

	public int getPageCount(int user_id) {
		int result=0;
		try 
		{
			result =tcAnnDao.selectPageCount(user_id);
		}
		catch (Exception ex) {
			logger.error("[TcAnnServiceImpl][getPageCount] "+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result;
	}

	public Announcement getAnnById(int id) {
		Announcement ann=null;
		
		try 
		{
			ann =annDao.selectAnnById(id);
		} 
		catch (Exception ex) {
			logger.error("[TcAnnServiceImpl][getAnnById] id: "+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return ann;
	}

	public boolean addAnn(Announcement ann,int user_id) {
		int result1=0;
		int result2=0;
		int id=0;
		TcAnn tcAnn=new TcAnn();
		try
		{
			result1=annDao.insertAnn(ann);
			
			id=annDao.getMaxId();
			tcAnn.setUser_id(user_id);
			tcAnn.setAnn_id(id);
			
			result2=tcAnnDao.insertTcAnn(tcAnn);
		}
		catch(Exception ex)
		{
			logger.error("[TcAnnServiceImpl][addAnn] Announcement: "+ann+"-id"+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		
		return (result1>0&&result2>0)?true:false;
	}

	public boolean updateAnn(Announcement ann) {
		int result=0;
		try 
		{
			result =annDao.updateAnn(ann);
		} catch (Exception ex) {
			logger.error("[TcAnnServiceImpl][updateAnn] ann: "+ann+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

	public boolean deleteAnnById(int id) {
		int result1=0;
		int result2=0;
		
		try
		{
			result1=annDao.deleteAnnById(id);
			result2=tcAnnDao.deleteAnnById(id);
		}
		catch(Exception ex)
		{
			logger.error("[TcAnnServiceImpl][deleteAnnById] id: "+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		
		return (result1>0&&result2>0)?true:false;
	}

}
