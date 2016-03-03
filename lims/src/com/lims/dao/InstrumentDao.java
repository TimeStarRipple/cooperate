package com.lims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lims.entity.Instrument;

public interface InstrumentDao {
	
	public List<Instrument> selectInstrumentByPage(@Param("query")String query,@Param("pageSize")int pageSize,@Param("pageNum")int pageNum);
	
	public int selectPageCount(@Param("query")String query);
	
	public int insertInstrument(Instrument instrument);
	
	public int updateInstrument(Instrument instrument);

}
