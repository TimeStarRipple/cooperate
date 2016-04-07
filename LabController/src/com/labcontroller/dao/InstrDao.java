package com.labcontroller.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.labcontroller.entity.Instrument;

public interface InstrDao {

	public int selectPageCount();

	public List<Instrument> selectInstrByPage(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

	public int addInstr(Instrument instr);

	public Instrument selectInstrById(@Param("id")int id);

	public int updateInstr(Instrument instr);

	public int deleteInstrById(@Param("id")int id);

	public List<Instrument> selectInstr();

}
