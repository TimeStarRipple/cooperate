package com.lims.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lims.entity.Menu;
import com.lims.entity.MenuTree;
import com.lims.entity.Role;
import com.lims.condition.RoleCondition;
import com.lims.constants.JsonResult;
import com.lims.constants.ResultCode;
import com.lims.controller.BaseController;
import com.lims.service.RoleService;
import com.lims.utils.PageUtil;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

	@Autowired
	public RoleService roleService;
	
	@RequestMapping(value="/listAllRole",method={RequestMethod.POST,RequestMethod.GET})
	public String listAllRole(HttpServletRequest request,Model model,RoleCondition condition)
	{
		int currentPageSize = this.getPageSize(request);
		int currentPageNum = this.getPageNum(request);
		
		List<Role> listRole=this.roleService.listRoleByPage(condition.filterCondition(), currentPageNum, currentPageSize);
		
		int totalRole=this.roleService.getPageCount(condition.filterCondition());
		
		PageUtil page_vo=new PageUtil(currentPageSize,totalRole,currentPageNum);
		page_vo.setObject(listRole);
		
		model.addAttribute("page_vo", page_vo);
		model.addAttribute("queryCondition", condition);
		return "role/role_list";
	}
	
	/**
	 * 编辑角色
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/edit/{id}",method={RequestMethod.POST,RequestMethod.GET})
	public Object editRole(@PathVariable("id") int id,HttpServletRequest request)
	{
		Role role=this.roleService.getRoleById(id);
		return role;
	}
	
	@ResponseBody
	@RequestMapping(value="/modify",method={RequestMethod.POST,RequestMethod.GET})
	public Object modifyRole(HttpServletRequest request,Role role,Model model)
	{
		boolean result=this.roleService.updateRole(role);
		
		if(result)
		{
			Map<String,String> paramMap=new HashMap<String,String>();
			
			paramMap.put("url", request.getContextPath()+"/role/listAllRole");
			
			return new JsonResult(ResultCode.RETURN_SUCCESS,"修改成功",paramMap);
		}
		else
		{
			return new JsonResult(ResultCode.RETURN_FAILURE,"修改失败","");
		}
	}
	
	/**
	 * 创建角色
	 * @param request
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/create",method={RequestMethod.POST,RequestMethod.GET})
	public Object createRole(HttpServletRequest request,Role role)
	{
		role.setCreateDate(new Date());
		
		boolean result=roleService.addRole(role);
		
		if(result)
		{
			Map<String,String> paramMap=new HashMap<String,String>();
			
			paramMap.put("url", request.getContextPath()+"/role/listAllRole");
			
			return new JsonResult(ResultCode.RETURN_SUCCESS,"保存成功",paramMap);
		}
		else
		{
			return new JsonResult(ResultCode.RETURN_FAILURE,"保存失败","");
		}
		
	}
	
	//初始化ztree
	@ResponseBody
	@RequestMapping(value = "/listAllTree", method = { RequestMethod.GET,RequestMethod.POST })
	public Object listMenuAllTree(HttpServletRequest request)
	{
        List<MenuTree> listMenuTree = new ArrayList<MenuTree>();
		
		List<Menu> listMenu = roleService.listAllMenu();
		
		if (listMenu!=null && listMenu.size()>0) {
			for (Menu m : listMenu) {
				MenuTree menuTree = new MenuTree();
				menuTree.setId(m.getId());
				menuTree.setName(m.getMenuName());
				menuTree.setOpen(false);
				menuTree.setpId(m.getParentId());
				listMenuTree.add(menuTree);
			}
		}
		return listMenuTree;
	}
	
	 /*
	 *树形图的数据
	 */
	@ResponseBody
	@RequestMapping(value = "/listTree/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public Object listMenuTree(@PathVariable("id") int id,HttpServletRequest request) 
	{
		List<MenuTree> listMenuTree = new ArrayList<MenuTree>();
		
		List<Menu> listMenu = roleService.listAllMenu();
		
		int count = this.roleService.getRoleMenuCount(id);
		
		if(count<=0)
		{
			if (listMenu!=null && listMenu.size()>0)
			{
				for (Menu m : listMenu) 
				{
					MenuTree menuTree = new MenuTree();
					menuTree.setId(m.getId());
					menuTree.setName(m.getMenuName());
					menuTree.setOpen(false);
					menuTree.setpId(m.getParentId());
					listMenuTree.add(menuTree);
				}
			}
			return listMenuTree;
		}
		else
		{
			List<Menu> listMenu1 = roleService.listCheckedMenuByRole(id);
			
			if (listMenu!=null && listMenu.size()>0 && listMenu1!=null && listMenu1.size()>0) 
			{
				for (Menu m : listMenu) 
				{
					MenuTree menuTree = new MenuTree();
					menuTree.setId(m.getId());
					menuTree.setName(m.getMenuName());
					menuTree.setOpen(true);
					menuTree.setpId(m.getParentId());
					
					if(listMenu1.contains(m))
					{
						menuTree.setChecked(true);
					}
					else
					{
						menuTree.setChecked(false);
					}
					listMenuTree.add(menuTree);
				}
				
			}
			return listMenuTree;
		}
	}
	
	/*
	 * 为角色修改权限
	 */
	@ResponseBody
	@RequestMapping(value="/modifyRoleMenu",method={RequestMethod.POST,RequestMethod.GET})
	public Object modifyRoleMenu(String menuId,int roleId,HttpServletRequest request)
	{
		if(menuId==null||menuId=="")
		{
			int resultCount=this.roleService.getRoleMenuCount(roleId);
			
			if(resultCount>0)
			{
				this.roleService.clearRoleMenu(roleId);
			}
			
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("url", request.getContextPath() + "/role/list");
			
			return new JsonResult(ResultCode.RETURN_SUCCESS, "保存成功", paramMap);
		}
		else
		{
			int resultCount=this.roleService.getRoleMenuCount(roleId);
			
			boolean clean=true;
			
			if(resultCount>0)
			{
				clean = this.roleService.clearRoleMenu(roleId);
			}
			
			if (clean)
			{
				boolean result = this.roleService.addRoleMenu(menuId,roleId);
				
				if (result) 
				{
					Map<String, String> paramMap = new HashMap<String, String>();					
					paramMap.put("url", request.getContextPath() + "/role/list");
					
					return new JsonResult(ResultCode.RETURN_SUCCESS, "保存成功", paramMap);
					
				} 
				else 
				{
					return new JsonResult(ResultCode.RETURN_FAILURE, "保存失败", "");
				}
			}
		    else 
			{
				return new JsonResult(ResultCode.RETURN_FAILURE, "保存失败", "");
			}
		}
	}

	
}
