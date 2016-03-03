package com.lims.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lims.dao.InstrumentDao;
import com.lims.entity.Instrument;
import com.lims.service.InstrumentService;

@Service(value="instrumentService")
public class InstrumentServiceImpl implements InstrumentService {
	
	private static final Logger logger=LoggerFactory.getLogger(InstrumentServiceImpl.class);

	@Autowired
	private InstrumentDao instrumentDao;
	
	public List<Instrument> listInstrumentByPage(String filterCondition,
			int courrentPageNum, int courrentPageSize) 
	{
		List<Instrument> listInstrument=null;
		try
		{
			listInstrument=instrumentDao.selectInstrumentByPage(filterCondition, courrentPageSize, courrentPageNum);
		}
		catch(Exception ex)
		{
			logger.error("[InstrumentServiceImpl][listInstrumentByPage] filterCondition:"+filterCondition+" courrentPageNum:"+
		        courrentPageNum+" courrentPageSize:"+courrentPageSize+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return listInstrument;
	}

	public int getPageCount(String filterCondition) 
	{
		int result=0;
		try
		{
			result=instrumentDao.selectPageCount(filterCondition);
		}
		catch(Exception ex)
		{
			logger.error("[InstrumentServiceImpl][getPageCount] filterCondition:"+filterCondition+"-"+ex.getLocalizedMessage()+":"+
		        ex.getMessage(),ex.getCause());
		}
		return result;
	}

	public boolean createInstrument(Instrument instrument) 
	{
		int result=0;
		try
		{
			result=instrumentDao.insertInstrument(instrument);
		}
		catch(Exception ex)
		{
			logger.error("[InstrumentServiceImpl][createInstrument] instrument:"+instrument+"-"+ex.getLocalizedMessage()+":"+
		        ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

	public boolean modifyInstrument(Instrument instrument) 
	{
		int result=0;
		try
		{
			result=instrumentDao.updateInstrument(instrument);
		}
		catch(Exception ex)
		{
			logger.error("[InstrumentServiceImpl][modifyInstrument] instrument:"+instrument+"-"+ex.getLocalizedMessage()+":"+
		        ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

	public Instrument getInstrumentById(int id) 
	{
		Instrument instrument=null;
		try
		{
			instrument=instrumentDao.selectInstrumentById(id);
		}
		catch(Exception ex)
		{
			logger.error("[InstrumentServiceImpl][getInstrumentById] id:"+id+"-"+ex.getLocalizedMessage()+":"+
		        ex.getMessage(),ex.getCause());
		}
		
		return instrument;
	}

}
