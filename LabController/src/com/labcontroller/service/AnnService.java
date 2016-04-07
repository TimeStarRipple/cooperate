package com.labcontroller.service;

import java.util.List;

import com.labcontroller.entity.Announcement;

public interface AnnService {

	public int getPageCount();

	public List<Announcement> listAnnByPage(int currentPageNum, int currentPageSize);

	public Announcement getAnnById(int id);

}
