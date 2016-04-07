package com.labcontroller.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labcontroller.dao.AddLabDao;
import com.labcontroller.dao.StudentLabDao;
import com.labcontroller.entity.OrderLab;
import com.labcontroller.entity.UserLab;
import com.labcontroller.service.AddLabService;

@Service(value="addLabService")
public class AddLabServiceImpl implements AddLabService {

	private static final Logger logger=Logger.getLogger(AddLabServiceImpl.class);
	
	@Autowired
	private AddLabDao addLabDao;
	
	@Autowired
	private StudentLabDao studentLabDao;
	
	public List<OrderLab> listAddLabByPage(int currentPageNum,
			int currentPageSize, int user_id) {
		
		if(currentPageNum!=0)
		{
			currentPageNum=(currentPageNum-1)*currentPageSize;
		}
		List<OrderLab> list= null;
		try 
		{
			list =addLabDao.selectAddOrderLabByPage(currentPageNum, currentPageSize,2,user_id);
		} catch (Exception ex) {
			logger.error("[AddLabServiceImpl][listAddLabByPage] pageNum: "+currentPageNum+"pageSize: "+currentPageSize+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
		
	}

	public int getPageCount() {
		
		int result=0;
		try 
		{
			result =addLabDao.selectPageCount();
		}
		catch (Exception ex) {
			logger.error("[AddLabServiceImpl][getPageCount] "+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result;
	}

	public boolean addNumber(int id,int number,UserLab userlab) {
		
		int result1=0;
		int result2=0;
		number++;
		
		try 
		{
			result1 =addLabDao.updateNumber(id, number);
			result2=studentLabDao.insertStudentLab(userlab);
		} 
		catch (Exception ex) {
			logger.error("[AddLabServiceImpl][addNumber] id: "+id+"number: "+number+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		
		return (result1>0&&result2>0)?true:false;
	}

}
