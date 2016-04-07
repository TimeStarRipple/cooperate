package com.labcontroller.service;

import java.util.List;

import com.labcontroller.entity.Instrument;

public interface AdminInstrService {

	public int getPageCount();

	public List<Instrument> listInstrByPage(int currentPageNum,
			int currentPageSize);

	public boolean addInstr(Instrument instr);

	public Instrument getInstrById(int id);

	public boolean updateInstr(Instrument instr);

	public boolean deleteInstrById(int id);

}
