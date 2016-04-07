package com.labcontroller.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labcontroller.dao.AddLabDao;
import com.labcontroller.dao.StudentLabDao;
import com.labcontroller.entity.OrderLab;
import com.labcontroller.service.StuLabService;

@Service(value="stuLabService")
public class StuLabServiceImpl implements StuLabService {

	private static final Logger logger=Logger.getLogger(StuLabServiceImpl.class);
	
	@Autowired
	private StudentLabDao studentLabDao;
	
	@Autowired
	private AddLabDao addLabDao;
	
	public int getPageCount(int user_id, int sort) {
		int result=0;
		try 
		{
			result =studentLabDao.selectPageCount(user_id,sort);
		}
		catch (Exception ex) {
			logger.error("[StuLabServiceImpl][getPageCount] "+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result;
	}

	public List<OrderLab> listStuLabByPage(int currentPageNum,
			int currentPageSize, int user_id, int sort) {
		if(currentPageNum!=0)
		{
			currentPageNum=(currentPageNum-1)*currentPageSize;
		}
		List<OrderLab> list= null;
		try 
		{
			list =addLabDao.selectStuLabByPage(currentPageNum, currentPageSize,user_id,sort);
		} catch (Exception ex) {
			logger.error("[AddLabServiceImpl][listAddLabByPage] pageNum: "+currentPageNum+"pageSize: "+currentPageSize+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
	}

	public boolean deleteLabById(int user_id, int id) {
		int result=0;
		OrderLab orderLab=null;
		try 
		{
			result =studentLabDao.deleteStuLabById(user_id,id);
			
			orderLab=addLabDao.selectOrderLabById(id);
			int number=orderLab.getNumber()-1;
			
			addLabDao.updateNumber(id, number);
		}
		catch (Exception ex) {
			logger.error("[StuLabServiceImpl][deleteLabById]user_id: "+user_id+"-id:"+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

}
