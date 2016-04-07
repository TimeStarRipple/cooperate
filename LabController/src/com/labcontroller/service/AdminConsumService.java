package com.labcontroller.service;

import java.util.List;

import com.labcontroller.entity.Consumable;

public interface AdminConsumService {

	public List<Consumable> listConByPage(int currentPageNum, int currentPageSize);

	public int getPageCount();

	public boolean addCon(Consumable consum);

	public Consumable getConsumById(int id);

	public boolean updateConsum(Consumable consum);

	public boolean deleteConById(int id);

}
