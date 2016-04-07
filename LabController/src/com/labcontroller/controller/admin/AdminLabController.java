package com.labcontroller.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.labcontroller.controller.BaseController;
import com.labcontroller.entity.Consumable;
import com.labcontroller.entity.Instrument;
import com.labcontroller.entity.OrderLab;
import com.labcontroller.service.AdminLabService;
import com.labcontroller.utils.PageUtil;

@Controller
@RequestMapping("/adminLab")
public class AdminLabController extends BaseController{
	
	@Autowired
	private AdminLabService adminLabService;
	
	@RequestMapping(value="/listTestLab",method={RequestMethod.GET,RequestMethod.POST})
	public String listTestLab(HttpServletRequest request,Model model)
	{
		
		int currentPageSize = this.getPageSize(request);
		int currentPageNum = this.getPageNum(request);
		
		List<OrderLab> listLab=this.adminLabService.listLabByPage(currentPageNum, currentPageSize,1);
		
		int totalLab=this.adminLabService.getPageCount(1);
		
		PageUtil paging_vo = new PageUtil(currentPageSize, totalLab, currentPageNum);
		
		paging_vo.setObject(listLab);
		
		List<Consumable> listCon=this.adminLabService.listConsum();
		List<Instrument> listInstr=this.adminLabService.listInstru();
		
		model.addAttribute("paging_vo",paging_vo);
		model.addAttribute("listInstr",listInstr);
		model.addAttribute("listCon",listCon);
		
		return "admin/admin-index";
	}
	
	@RequestMapping(value="/listPassLab",method={RequestMethod.GET,RequestMethod.POST})
	public String listPassLab(HttpServletRequest request,Model model)
	{
		
		int currentPageSize = this.getPageSize(request);
		int currentPageNum = this.getPageNum(request);
		
		List<OrderLab> listLab=this.adminLabService.listLabByPage(currentPageNum, currentPageSize,2);
		
		int totalLab=this.adminLabService.getPageCount(2);
		
		PageUtil paging_vo = new PageUtil(currentPageSize, totalLab, currentPageNum);
		
		paging_vo.setObject(listLab);
		
		model.addAttribute("paging_vo",paging_vo);
		
		return "admin/listPassLab";
	}
	
	@RequestMapping(value="/listOverLab",method={RequestMethod.GET,RequestMethod.POST})
	public String listOverLab(HttpServletRequest request,Model model)
	{
		
		int currentPageSize = this.getPageSize(request);
		int currentPageNum = this.getPageNum(request);
		
		List<OrderLab> listLab=this.adminLabService.listLabByPage(currentPageNum, currentPageSize,3);
		
		int totalLab=this.adminLabService.getPageCount(3);
		
		PageUtil paging_vo = new PageUtil(currentPageSize, totalLab, currentPageNum);
		
		paging_vo.setObject(listLab);
		
		model.addAttribute("paging_vo",paging_vo);
		
		return "admin/listOverLab";
	}
	
	@RequestMapping(value="/detail/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public String detailLab(@PathVariable("id") int id ,HttpServletRequest request)
	{
		boolean result=this.adminLabService.deleteLabById(id);
		
		if(result)
		{
			return "redirect:/adminLab/listTestLab";
		}
		else
		{
			return "redirect:/adminLab/listTestLab";
		}
	}
	
	@RequestMapping(value="/modify",method={RequestMethod.GET,RequestMethod.POST})
	public String modifyLab(HttpServletRequest request,Model model)
	{
		int id = Integer.parseInt(getNotNull("id", request));
		
		boolean result=this.adminLabService.modifyLabById(id);
		
		if(result)
		{
			return "redirect:/adminLab/listTestLab";
		}
		else
		{
			return "redirect:/adminLab/listTestLab";
		}
	}

}
