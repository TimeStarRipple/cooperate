package com.labcontroller.service;

import java.util.List;

import com.labcontroller.entity.OrderLab;

public interface StuLabService {

	public int getPageCount(int user_id, int sort);

	public List<OrderLab> listStuLabByPage(int currentPageNum, int currentPageSize, int user_id, int sort);

	public boolean deleteLabById(int user_id, int id);

}
