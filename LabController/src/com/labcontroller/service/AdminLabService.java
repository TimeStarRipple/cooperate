package com.labcontroller.service;

import java.util.List;

import com.labcontroller.entity.Consumable;
import com.labcontroller.entity.Instrument;
import com.labcontroller.entity.OrderLab;

public interface AdminLabService {

	public List<OrderLab> listLabByPage(int currentPageNum, int currentPageSize, int i);

	public int getPageCount(int i);

	public boolean deleteLabById(int id);

	public boolean modifyLabById(int id);

	public List<OrderLab> getOrderLabBySort(int i);

	public void overLabById(int id);

	public List<Instrument> listInstru();

	public List<Consumable> listConsum();

}
