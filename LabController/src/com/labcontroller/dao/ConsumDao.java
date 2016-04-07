package com.labcontroller.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.labcontroller.entity.Consumable;

public interface ConsumDao {

	public List<Consumable> selectConsumByPage(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

	public int selectPageCount();

	public int addCon(Consumable con);

	public int updateCon(Consumable consum);

	public int deleteConById(@Param("id")int id);

	public Consumable selectConsumById(@Param("id")int id);

	public List<Consumable> selectConsum();

}
