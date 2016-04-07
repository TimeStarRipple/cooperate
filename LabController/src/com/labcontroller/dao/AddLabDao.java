package com.labcontroller.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.labcontroller.entity.OrderLab;

/**   
* 加入预约实验的dao层
* @ClassName: AddLabDao
* @date 2015年12月25日
* @version V1.0   
*/
public interface AddLabDao {

	public List<OrderLab> selectOrderLabByPage(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize, @Param("sort")int sort);
	
	public int selectPageCount();
	
	public int updateNumber(@Param("id")int id,@Param("number")int number);

	public List<OrderLab> selectStuLabByPage(@Param("pageNum")int pageNum,
			@Param("pageSize")int pageSize,@Param("user_id") int user_id,@Param("sort") int sort);

	public int insertLab(OrderLab orderLab);

	public int getMaxId();

	public int getPageCount(@Param("sort")int sort);

	public int deleteLabById(@Param("id")int id);

	public List<OrderLab> selectOrderLabBySort(@Param("sort")int sort);

	public int modifySortById(@Param("id")int id,@Param("sort")int sort);

	public OrderLab selectOrderLabById(@Param("id")int id);

	public List<OrderLab> selectTcLabByPage(@Param("pageNum")int currentPageNum,
			@Param("pageSize")int currentPageSize, @Param("user_id")int user_id, @Param("sort")int sort);

	public List<OrderLab> selectAddOrderLabByPage(@Param("pageNum")int currentPageNum,
			@Param("pageSize")int currentPageSize, @Param("sort")int sort, @Param("user_id")int user_id);
	
}
