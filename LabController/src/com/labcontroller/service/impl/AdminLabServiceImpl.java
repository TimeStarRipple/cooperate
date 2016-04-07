package com.labcontroller.service.impl;

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
import com.labcontroller.service.AdminLabService;

@Service(value="adminLabService")
public class AdminLabServiceImpl implements AdminLabService {
	
	private static final Logger logger=Logger.getLogger(AdminLabServiceImpl.class);

	@Autowired
	private AddLabDao addLabDao;
	
	@Autowired
	private StudentLabDao studentLabDao;
	
	@Autowired
	private ConsumDao consumDao;
	
	@Autowired
	private InstrDao instrDao;
	
	public List<OrderLab> listLabByPage(int currentPageNum,
			int currentPageSize, int i) {
		if(currentPageNum!=0)
		{
			currentPageNum=(currentPageNum-1)*currentPageSize;
		}
		List<OrderLab> list= null;
		try 
		{
			list =addLabDao.selectOrderLabByPage(currentPageNum, currentPageSize,i);
		} catch (Exception ex) {
			logger.error("[AdminLabServiceImpl][listLabByPage] pageNum: "+currentPageNum+"pageSize: "+currentPageSize+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
	}

	public int getPageCount(int i) {
		int result=0;
		try 
		{
			result =addLabDao.getPageCount(i);
		}
		catch (Exception ex) {
			logger.error("[AdminLabServiceImpl][getPageCount] "+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result;
	}

	public boolean deleteLabById(int id) {
		int result1=0;
		int result2=0;
		OrderLab orderLab=null;
		Instrument instr=null;
		Consumable consum=null;
		try
		{
			result1=addLabDao.deleteLabById(id);
			result2=studentLabDao.deleteLabById(id);
			
			orderLab=addLabDao.selectOrderLabById(id);
			if(orderLab.getSort()==2)
			{
				instr=instrDao.selectInstrById(orderLab.getInstr_id());
				instr.setNumber(instr.getNumber()+orderLab.getInstr_number());
				instrDao.updateInstr(instr);
				
				consum=consumDao.selectConsumById(orderLab.getConsum_id());
				consum.setNumber(consum.getNumber()+orderLab.getConsum_number());
				consumDao.updateCon(consum);
			}
		}
		catch(Exception ex)
		{
			logger.error("[AdminLabServiceImpl][deleteAnnById] id: "+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		
		return (result1>0&&result2>0)?true:false;
	}

	public boolean modifyLabById(int id) {
		int result1=0;
		int result2=0;
		int result3=0;
		int consum_number,consum_id;
		int instr_number,instr_id;
		OrderLab orderLab=null;
		Consumable consum=new Consumable();
		Instrument instr=new Instrument();
		
		try
		{
			result1=addLabDao.modifySortById(id,2);
			
			orderLab=addLabDao.selectOrderLabById(id);
			
			consum_number=orderLab.getConsum_number();
			consum_id=orderLab.getConsum_id();
			consum_number=consumDao.selectConsumById(consum_id).getNumber()-consum_number;
			consum.setId(consum_id);
			consum.setName(consumDao.selectConsumById(consum_id).getName());
			consum.setNumber(consum_number);
			result2=consumDao.updateCon(consum);
			
			instr_number=orderLab.getInstr_number();
			instr_id=orderLab.getInstr_id();
			instr_number=instrDao.selectInstrById(instr_id).getNumber()-instr_number;
			instr.setId(instr_id);
			instr.setName(instrDao.selectInstrById(instr_id).getName());
			instr.setNumber(instr_number);
			result3=instrDao.updateInstr(instr);
		}
		catch(Exception ex)
		{
			logger.error("[AdminLabServiceImpl][modifyById] id: "+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return (result1>0&&result2>0&&result3>0)?true:false;
	}

	public List<OrderLab> getOrderLabBySort(int i) {
		List<OrderLab> list= null;
		try 
		{
			list =addLabDao.selectOrderLabBySort(i);
		} catch (Exception ex) {
			logger.error("[AdminLabServiceImpl][getOrderLabBySort] sort"+i+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
	}

	public void overLabById(int id) {
		OrderLab orderLab=null;
		Instrument instr=null;
		try
		{
			addLabDao.modifySortById(id,3);
			orderLab=addLabDao.selectOrderLabById(id);
			if(orderLab.getInstr_id()!=0)
			{
				instr=instrDao.selectInstrById(orderLab.getInstr_id());
				instr.setNumber(instr.getNumber()+orderLab.getInstr_number());
				instrDao.updateInstr(instr);
			}
		}
		catch(Exception ex)
		{
			logger.error("[AdminLabServiceImpl][overLabById] id"+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		
	}

	public List<Consumable> listConsum() {
		List<Consumable> list= null;
		try 
		{
			list =consumDao.selectConsum();
		} catch (Exception ex) {
			logger.error("[AdminLabServiceImpl][listConsum] -"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
	}

	public List<Instrument> listInstru() {
		List<Instrument> list= null;
		try 
		{
			list =instrDao.selectInstr();
		} catch (Exception ex) {
			logger.error("[AdminLabServiceImpl][listConsum] -"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
	}

}
