package com.labcontroller.service;

import java.util.List;

import com.labcontroller.entity.Announcement;

public interface TcAnnService {

	public List<Announcement> listAnnByPage(int currentPageNum, int currentPageSize,
			int user_id);

	public int getPageCount(int user_id);

	public Announcement getAnnById(int id);

	public boolean addAnn(Announcement ann, int user_id);

	public boolean updateAnn(Announcement ann);

	public boolean deleteAnnById(int id);

}
