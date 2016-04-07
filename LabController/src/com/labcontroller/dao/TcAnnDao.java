package com.labcontroller.dao;

import org.apache.ibatis.annotations.Param;

import com.labcontroller.entity.TcAnn;

public interface TcAnnDao {

	public int selectPageCount(@Param("user_id")int user_id);
	
	public int deleteAnnById(@Param("id")int id);

	public int insertTcAnn(TcAnn tcAnn);
	
}
