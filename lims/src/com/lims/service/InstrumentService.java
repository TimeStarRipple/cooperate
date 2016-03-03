package com.lims.service;

import java.util.List;

import com.lims.entity.Instrument;

public interface InstrumentService {

	public List<Instrument> listInstrumentByPage(String filterCondition,
			int courrentPageNum, int courrentPageSize);

	public int getPageCount(String filterCondition);

	public boolean createInstrument(Instrument instrument);

	public boolean modifyInstrument(Instrument instrument);

	public Instrument getInstrumentById(int id);

}
