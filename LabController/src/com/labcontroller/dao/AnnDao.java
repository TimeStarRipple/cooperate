package com.labcontroller.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.labcontroller.entity.Announcement;

public interface AnnDao {

	public List<Announcement> selectAnnByPage(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);
	
	public int selectPageCount();
	
	public Announcement selectAnnById(@Param("id")int id);
	
	public List<Announcement> selectTcAnnByPage(@Param("pageNum")int pageNum,
			@Param("pageSize")int pageSize,@Param("user_id")int user_id);
	
	public int updateAnn(Announcement ann);
	
	public int deleteAnnById(@Param("id")int id);
	
	public int insertAnn(Announcement ann);
	
	public int getMaxId();
	
}
