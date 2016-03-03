package com.lims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lims.entity.Consumable;

public interface ConsumableDao {

	public int insertConsumable(Consumable consumable);
	
	public List<Consumable> selectConsumableByPage(@Param("query")String query,@Param("pageSize")int pageSize,@Param("pageNum")int pageNum);
	
	public int selectPageCount(@Param("query")String query);
	
	public Consumable selectConsumableById(@Param("id")int id);
	
	public int updateConsumable(Consumable consumable);
	
}
