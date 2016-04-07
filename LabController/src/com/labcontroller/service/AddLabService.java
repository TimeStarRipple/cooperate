package com.labcontroller.service;

import java.util.List;
import com.labcontroller.entity.OrderLab;
import com.labcontroller.entity.UserLab;

public interface AddLabService {

	public List<OrderLab> listAddLabByPage(int currentPageNum, int currentPageSize, int user_id);

	public int getPageCount();

	public boolean addNumber(int id,int number,UserLab userlab);
	
}
