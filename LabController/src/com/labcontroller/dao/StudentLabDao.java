package com.labcontroller.dao;

import org.apache.ibatis.annotations.Param;

import com.labcontroller.entity.UserLab;

public interface StudentLabDao {
	
	public int insertStudentLab(UserLab userlab);

	public int selectPageCount(@Param("user_id") int user_id,@Param("sort") int sort);

	public int deleteLabById(@Param("id")int id);

	public int deleteStuLabById(@Param("user_id")int user_id, @Param("id")int id);

}
