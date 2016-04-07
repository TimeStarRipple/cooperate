package com.labcontroller.service;

import java.util.List;

import com.labcontroller.entity.Consumable;
import com.labcontroller.entity.Instrument;
import com.labcontroller.entity.OrderLab;

public interface TcLabService {

	public List<OrderLab> listLabByPage(int currentPageNum, int currentPageSize,
			int user_id, int sort);

	public int getPageCount(int user_id, int sort);

	public boolean addLab(OrderLab orderLab, int user_id);

	public List<Consumable> listConsum();

	public List<Instrument> listInstru();

}
