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
import com.labcontroller.entity.Instrument;
import com.labcontroller.service.AdminInstrService;
import com.labcontroller.utils.PageUtil;

@Controller
@RequestMapping("/adminInstr")
public class AdminInstrController extends BaseController{
	
	@Autowired
	private AdminInstrService adminInstrService;
	
	@RequestMapping(value="/listInstr",method={RequestMethod.GET,RequestMethod.POST})
	public String listConsum(HttpServletRequest request,Model model)
	{
		
		int currentPageSize = this.getPageSize(request);
		int currentPageNum = this.getPageNum(request);
		
		List<Instrument> listInstr=this.adminInstrService.listInstrByPage(currentPageNum, currentPageSize);
		
		int totalInstr=this.adminInstrService.getPageCount();
		
		PageUtil paging_vo = new PageUtil(currentPageSize, totalInstr, currentPageNum);
		
		paging_vo.setObject(listInstr);
		
		model.addAttribute("paging_vo",paging_vo);
		
		return "admin/admin-device";
	}
	
	@RequestMapping(value="/create",method={RequestMethod.GET,RequestMethod.POST})
	public String createNews(HttpServletRequest request,Instrument instr)
	{
		if(request.getMethod().equalsIgnoreCase("GET"))
		{
			return "/admin/create-device";
		}
		else
		{
			boolean result=this.adminInstrService.addInstr(instr);
			if(result)
			{
				return "redirect:/adminInstr/listInstr";
			}else{
				return "redirect:/adminInstr/listInstr";
			}
		}
	}
	
	@RequestMapping(value="/modify",method={RequestMethod.GET,RequestMethod.POST})
	public String  modifyInstr(HttpServletRequest request,Instrument instr,Model model)
	{
		if(request.getMethod().equalsIgnoreCase("GET")){
			
			int id = Integer.parseInt(getNotNull("id", request));
			
			instr=this.adminInstrService.getInstrById(id);
			
			model.addAttribute("instr", instr);
			
			return "/admin/editInstr";
		}
		else
		{
			boolean result=this.adminInstrService.updateInstr(instr);
			if(result)
			{
				return "redirect:/adminInstr/listInstr";
			}
			else
			{
				return "redirect:/adminInstr/listInstr";
			}
		}
	}
	
	@RequestMapping(value="/detail/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public String detailInstr(@PathVariable("id") int id ,HttpServletRequest request)
	{
		boolean result=this.adminInstrService.deleteInstrById(id);
		
		if(result)
		{
			return "redirect:/adminInstr/listInstr";
		}
		else
		{
			return "redirect:/adminInstr/listInstr";
		}
	}

}
