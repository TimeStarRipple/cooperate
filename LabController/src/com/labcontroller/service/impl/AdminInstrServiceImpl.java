package com.labcontroller.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labcontroller.dao.InstrDao;
import com.labcontroller.entity.Instrument;
import com.labcontroller.service.AdminInstrService;

@Service(value="adminInstrService")
public class AdminInstrServiceImpl implements AdminInstrService {

	private static final Logger logger=Logger.getLogger(AdminInstrServiceImpl.class);
	
	@Autowired
	private InstrDao instrDao;
	
	public int getPageCount() {
		int result=0;
		try 
		{
			result =instrDao.selectPageCount();
		}
		catch (Exception ex) {
			logger.error("[AdminInstrServiceImpl][getPageCount] "+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result;
	}

	public List<Instrument> listInstrByPage(int currentPageNum,
			int currentPageSize) {
		if(currentPageNum!=0)
		{
			currentPageNum=(currentPageNum-1)*currentPageSize;
		}
		
		List<Instrument> list= null;
		try 
		{
			list =instrDao.selectInstrByPage(currentPageNum, currentPageSize);
		} 
		catch (Exception ex) {
			logger.error("[AdminInstrServiceImpl][listInstrByPage] pageNum: "+currentPageNum+"pageSize: "+currentPageSize+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return list;
	}

	public boolean addInstr(Instrument instr) {
		int result=0;
		try
		{
			result=instrDao.addInstr(instr);
		}
		catch(Exception ex){
			logger.error("[AdminInstrServiceImpl][addInstr] Instrument:"+instr+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

	public Instrument getInstrById(int id) {
		Instrument instr=null;
		try 
		{
			instr =instrDao.selectInstrById(id);
		} catch (Exception ex) {
			logger.error("[AdminInstrServiceImpl][updateInstr] id: "+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return instr;
	}

	public boolean updateInstr(Instrument instr) {
		int result=0;
		try 
		{
			result =instrDao.updateInstr(instr);
		} catch (Exception ex) {
			logger.error("[AdminInstrServiceImpl][updateInstr] instr: "+instr+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

	public boolean deleteInstrById(int id) {
		int result=0;
		try 
		{
			result =instrDao.deleteInstrById(id);
		} catch (Exception ex) {
			logger.error("[AdminInstrServiceImpl][deleteInstrById]id: "+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

}
