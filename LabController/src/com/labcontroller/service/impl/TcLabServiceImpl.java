package com.labcontroller.service.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labcontroller.dao.AddLabDao;
import com.labcontroller.dao.ConsumDao;
import com.labcontroller.dao.InstrDao;
import com.labcontroller.dao.StudentLabDao;
import com.labcontroller.entity.Consumable;
import com.labcontroller.entity.Instrument;
import com.labcontroller.entity.OrderLab;
import com.labcontroller.entity.UserLab;
import com.labcontroller.service.TcLabService;

@Service(value="tcLabService")
public class TcLabServiceImpl implements TcLabService {

	private static final Logger logger=Logger.getLogger(TcLabServiceImpl.class);
	
	@Autowired
	private AddLabDao addLabDao;
	
	@Autowired
	private StudentLabDao studentLabDao;
	
	@Autowired
	private ConsumDao consumDao;
	
	@Autowired
	private InstrDao instrDao;
	
	public List<OrderLab> listLabByPage(int currentPageNum,
			int currentPageSize, int user_id, int sort) {
		if(currentPageNum!=0)
		{
			currentPageNum=(currentPageNum-1)*currentPageSize;
		}
		List<OrderLab> list= null;
		try 
		{
			list =addLabDao.selectTcLabByPage(currentPageNum, currentPageSize,user_id,sort);
			
			Iterator<OrderLab> iterator=list.iterator();
			while(iterator.hasNext())
			{
				OrderLab orderLab = iterator.next();
				
				String instr_name=instrDao.selectInstrById(orderLab.getInstr_id()).getName();
				orderLab.setInstr_name(instr_name);
				
				String consum_name=consumDao.selectConsumById(orderLab.getConsum_id()).getName();
				orderLab.setConsum_name(consum_name);
			}
			
		} catch (Exception ex) {
			logger.error("[TcLabServiceImpl][listAddLabByPage] pageNum: "+currentPageNum+"pageSize: "+currentPageSize+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
	}

	public int getPageCount(int user_id, int sort) {
		int result=0;
		try 
		{
			result =studentLabDao.selectPageCount(user_id,sort);
		}
		catch (Exception ex) {
			logger.error("[TcLabServiceImpl][getPageCount] "+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result;
	}

	public boolean addLab(OrderLab orderLab, int user_id) {
		int result1=0;
		int result2=0;
		int id;
		try
		{
			result1=addLabDao.insertLab(orderLab);
			id=addLabDao.getMaxId();
			
			 UserLab userLab=new UserLab();
			 userLab.setSort(2);
			 userLab.setUser_id(user_id);
			 userLab.setExperiment_id(id);
			 
			result2=studentLabDao.insertStudentLab(userLab);
		}
		catch(Exception ex)
		{
			logger.error("[TcLabServiceImpl][addLab] user_id: "+user_id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		
		return (result1>0&&result2>0)?true:false;
	}

	public List<Consumable> listConsum() {
		List<Consumable> list= null;
		try 
		{
			list =consumDao.selectConsum();
		} catch (Exception ex) {
			logger.error("[TcLabServiceImpl][listConsum] -"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
	}

	public List<Instrument> listInstru() {
		List<Instrument> list= null;
		try 
		{
			list =instrDao.selectInstr();
		} catch (Exception ex) {
			logger.error("[TcLabServiceImpl][listConsum] -"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
	}

}
