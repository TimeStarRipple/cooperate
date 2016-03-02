package com.lims.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lims.dao.UsersPermissionDao;
import com.lims.service.impl.PermissionServiceImpl;
import com.lims.entity.Permission;
import com.lims.service.PermissionService;

@Service(value="permissionService")
public class PermissionServiceImpl implements PermissionService {

	private static final Logger logger=LoggerFactory.getLogger(PermissionServiceImpl.class);
	
	@Autowired
	private UsersPermissionDao usersPermissionDao;
	
	public List<Permission> getUsersPermissionByRole(int role, int pid) {
		List<Permission> listPermission=new ArrayList<Permission>();
		try 
		{
			//拿一级菜单
			listPermission=this.usersPermissionDao.selectUsersPermissionByRole(role, pid);
			
			if(listPermission!=null&&listPermission.size()>0)
			{
				for(Permission permission:listPermission)
				{
					int menuId=permission.getMenuId();
					
					//拿二级菜单
					List<Permission> subPermission=this.usersPermissionDao.selectUsersPermissionByRole(role,menuId);
					
					if(subPermission!=null&&subPermission.size()>0)
					{
						//有子菜单
						permission.setHasMenu(true);
						permission.setSubMenu(subPermission);
						
						if(StringUtils.isBlank(permission.getMenuUrl()))
						{
							permission.setMenuUrl(null);
						}
						
						for(Permission finishPermission:subPermission)
						{
							int finishMenuId=finishPermission.getMenuId();
							
							List<Permission> finishPermissionList=this.usersPermissionDao.selectUsersPermissionByRole(role,finishMenuId);
							
							if(finishPermissionList!=null&&finishPermissionList.size()>0)
							{
								//有三级子菜单
								finishPermission.setHasMenu(true);
								finishPermission.setSubMenu(finishPermissionList);
								
								if(StringUtils.isBlank(finishPermission.getMenuUrl()))
								{
									finishPermission.setMenuUrl(null);
								}
							}
					    }
					}
				}
			}
			
		} catch (Exception ex) {
			logger.error("[PermissionServiceImpl][getUsersPermissionByRole] role: "+ role + "-"+ex.getLocalizedMessage()+":"+ex.getMessage(),ex.getCause());
		}
		return listPermission;
	}

}
