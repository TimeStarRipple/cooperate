package com.labcontroller.controller.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.labcontroller.context.UsersContext;
import com.labcontroller.controller.BaseController;
import com.labcontroller.entity.Consumable;
import com.labcontroller.entity.Instrument;
import com.labcontroller.entity.OrderLab;
import com.labcontroller.service.TcLabService;
import com.labcontroller.utils.PageUtil;

@Controller
@RequestMapping("/tcLab")
public class TcLabController extends BaseController{
	
	@Autowired
	private TcLabService tcLabService;
	
	@RequestMapping(value="/listLab",method={RequestMethod.GET,RequestMethod.POST})
	public String listLab(HttpServletRequest request,Model model)
	{
		
		int currentPageSize = this.getPageSize(request);
		int currentPageNum = this.getPageNum(request);
		int user_id=UsersContext.getLoginSysId();
		int sort=UsersContext.getLoginSort();
		
		List<OrderLab> listLab=this.tcLabService.listLabByPage(currentPageNum, currentPageSize,user_id,sort);
		
		int totalLab=this.tcLabService.getPageCount(user_id,sort);
		
		PageUtil paging_vo = new PageUtil(currentPageSize, totalLab, currentPageNum);
		
		paging_vo.setObject(listLab);
		
		model.addAttribute("paging_vo",paging_vo);
		
		return "teacher/teh-lesson";
	}
	
	@RequestMapping(value="/create",method={RequestMethod.GET,RequestMethod.POST})
	public String createNews(HttpServletRequest request,OrderLab orderLab,Model model)
	{
		if(request.getMethod().equalsIgnoreCase("GET"))
		{
			List<Consumable> listCon=this.tcLabService.listConsum();
			List<Instrument> listInstr=this.tcLabService.listInstru();
			
			model.addAttribute("listInstr",listInstr);
			model.addAttribute("listCon",listCon);
			
			return "teacher/create-lesson";
		}
		else
		{
			orderLab.setTeacher(UsersContext.getLoginSysName());
			orderLab.setNumber(0);
			orderLab.setSort(1);
			
			int user_id=UsersContext.getLoginSysId();
			
			String date=orderLab.getDate();
			String time=orderLab.getTime();
			String over=date+" "+time.substring(6);
			orderLab.setOver(over);
			
			boolean result=this.tcLabService.addLab(orderLab,user_id);
			if(result)
			{
				return "redirect:/tcLab/listLab";
			}else{
				return "redirect:/tcLab/listLab";
			}
		}
	}
}
