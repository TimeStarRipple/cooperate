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
import com.labcontroller.service.AdminConsumService;
import com.labcontroller.utils.PageUtil;

@Controller
@RequestMapping("/adminConsum")
public class AdminConsumController extends BaseController{
	
	@Autowired
	private AdminConsumService adConService;
	
	@RequestMapping(value="/listConsum",method={RequestMethod.GET,RequestMethod.POST})
	public String listConsum(HttpServletRequest request,Model model)
	{
		
		int currentPageSize = this.getPageSize(request);
		int currentPageNum = this.getPageNum(request);
		
		List<Consumable> listCon=this.adConService.listConByPage(currentPageNum, currentPageSize);
		
		int totalCon=this.adConService.getPageCount();
		
		PageUtil paging_vo = new PageUtil(currentPageSize, totalCon, currentPageNum);
		
		paging_vo.setObject(listCon);
		
		model.addAttribute("paging_vo",paging_vo);
		
		return "admin/admin-item";
	}
	
	@RequestMapping(value="/create",method={RequestMethod.POST})
	public String createConsum(HttpServletRequest request,Consumable consum)
	{
		boolean result=this.adConService.addCon(consum);
		if(result)
		{
			return "redirect:/adminConsum/listConsum";
		}
		else
		{
			return "redirect:/adminConsum/listConsum";
		}
		
	}
	
	@RequestMapping(value="/create",method={RequestMethod.GET})
	public String createNews(HttpServletRequest request,Consumable consum)
	{
		return "/admin/create-item";
	}
	
	@RequestMapping(value="/modify",method={RequestMethod.GET,RequestMethod.POST})
	public String  modifyNews(HttpServletRequest request,Consumable consum,Model model)
	{
		if(request.getMethod().equalsIgnoreCase("GET")){
			
			int id = Integer.parseInt(getNotNull("id", request));
			
			consum=this.adConService.getConsumById(id);
			
			model.addAttribute("consum", consum);
			
			return "/admin/editConsum";
		}
		else
		{
			boolean result=this.adConService.updateConsum(consum);
			if(result)
			{
				return "redirect:/adminConsum/listConsum";
			}
			else
			{
				return "redirect:/adminConsum/listConsum";
			}
		}
	}
	
	@RequestMapping(value="/detail/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public String detailNews(@PathVariable("id") int id ,HttpServletRequest request)
	{
		boolean result=this.adConService.deleteConById(id);
		
		if(result)
		{
			return "redirect:/adminConsum/listConsum";
		}
		else
		{
			return "redirect:/adminConsum/listConsum";
		}
	}
	
}
