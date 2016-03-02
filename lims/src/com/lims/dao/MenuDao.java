package com.lims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lims.entity.Menu;

public interface MenuDao {
	
	public List<Menu> selectAllMenu();

	public int selectParentIdByMenuId(@Param("menuId")int menuId);

}
