package com.lims.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lims.dao.MenuDao;
import com.lims.dao.RoleDao;
import com.lims.dao.RoleMenuDao;
import com.lims.entity.Menu;
import com.lims.entity.Role;
import com.lims.entity.RoleMenu;
import com.lims.service.RoleService;

@Service(value="roleService")
public class RoleServiceImpl implements RoleService {

	private static final Logger logger=LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private RoleMenuDao roleMenuDao;
	
	public List<Role> listRoleByPage(String filterCondition,
			int currentPageNum, int currentPageSize) 
	{
		List<Role> listRole=null;
		try
		{
			listRole=roleDao.selectRoleByPage(filterCondition, currentPageNum, currentPageSize);
		}
		catch(Exception ex)
		{
			logger.error("[RoleServiceImpl][listRoleByPage] filterCondition: "+filterCondition+"currentPageNum: "+currentPageNum+
					"currentPageSize: "+currentPageSize+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return listRole;
	}

	public int getPageCount(String filterCondition) 
	{
		int result=0;
		try
		{
			result=roleDao.selectPageCount(filterCondition);
		}
		catch(Exception ex)
		{
			logger.error("[RoleServiceImpl][getPageCount] filterCondition: "+filterCondition+"-"+ex.getLocalizedMessage()+":"+
		            ex.getMessage(),ex.getCause());
		}
		return result;
	}

	

	public Role getRoleById(int id) 
	{
		Role role=null;
		try
		{
			role=roleDao.selectRoleById(id);
		}
		catch(Exception ex)
		{
			logger.error("[RoleServiceImpl][getRoleById] id:"+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return role;
	}

	public boolean addRole(Role role) 
	{
		int result=0;		
		try
		{
			result=roleDao.insertRole(role);
		}
		catch(Exception ex)
		{
			logger.error("[RoleServiceImpl][addRole] role:"+role+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

	public boolean updateRole(Role role) 
	{
		int result=0;
		try
		{
			result=roleDao.updateRole(role);
		}
		catch(Exception ex)
		{
			logger.error("[RoleServiceImpl][updateRole] role:"+role+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getClass());
		}
		return result>0?true:false;
	}

	public List<Menu> listAllMenu() 
	{
		List<Menu> listMenu=null;
		try
		{
			listMenu=menuDao.selectAllMenu();
		}
		catch(Exception ex)
		{
			logger.error("[RoleServiceImpl][listAllMenu] "+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return listMenu;
	}

	public int getRoleMenuCount(int id) {
		int result=0;
		try
		{
			result=roleMenuDao.selectRoleMenuCount(id);
		}
		catch(Exception ex)
		{
			logger.error("[RoleServiceImpl][getRoleMenuCount] id:"+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result;
	}

	public List<Menu> listCheckedMenuByRole(int id) {
		List<Menu> listMenu=null;
		try
		{
			listMenu=roleMenuDao.selectRoleMenuByRole(id);
		}
		catch(Exception ex)
		{
			logger.error("[RoleServiceImpl][listCheckedMenuByRole] id:"+id+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return listMenu;
	}

	public boolean clearRoleMenu(int roleId) {
		int result=0;
		try
		{
			result=roleMenuDao.deleteRoleMenuByRole(roleId);
		}
		catch(Exception ex)
		{
			logger.error("[RoleServiceImpl][clearRoleMenu] role:"+roleId+"-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

	public boolean addRoleMenu(String menuId, int roleId) {
		int result=0;
		RoleMenu roleMenu=new RoleMenu();
		try
		{
			String[] str=null;
			str=menuId.split(",");
			if(roleId!=0)
			{
				for(String id:str)
				{
					roleMenu.setMenuId(Integer.valueOf(id));
					roleMenu.setRole(roleId);
					roleMenu.setParentId(menuDao.selectParentIdByMenuId(Integer.valueOf(id)));
					
					result=roleMenuDao.insertRoleMenu(roleMenu);
				}
			}
		}
		catch(Exception ex)
		{
			logger.error("[RoleServiceImpl][addRoleMenu] menuId:"+menuId+" roleId:"+roleId+"-"+ex.getLocalizedMessage()+":"+
		            ex.getMessage(),ex.getCause());
		}
		return result>0?true:false;
	}

}
