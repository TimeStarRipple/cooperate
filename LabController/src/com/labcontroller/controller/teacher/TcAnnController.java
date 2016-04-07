package com.labcontroller.controller.teacher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.labcontroller.context.UsersContext;
import com.labcontroller.controller.BaseController;
import com.labcontroller.entity.Announcement;
import com.labcontroller.service.TcAnnService;
import com.labcontroller.utils.PageUtil;

@Controller
@RequestMapping("/tcAnn")
public class TcAnnController extends BaseController{

	@Autowired
	private TcAnnService tcAnnService;
	
	@RequestMapping(value="/listAnn",method={RequestMethod.GET,RequestMethod.POST})
	public String listAnn(HttpServletRequest request,Model model)
	{
		
		int currentPageSize = this.getPageSize(request);
		int currentPageNum = this.getPageNum(request);
		int user_id=UsersContext.getLoginSysId();
		
		List<Announcement> listAnn=this.tcAnnService.listAnnByPage(currentPageNum, currentPageSize,user_id);
		
		int totalAnn=this.tcAnnService.getPageCount(user_id);
		
		PageUtil paging_vo = new PageUtil(currentPageSize, totalAnn, currentPageNum);
		
		paging_vo.setObject(listAnn);
		
		model.addAttribute("paging_vo",paging_vo);
		
		return "teacher/teh-index";
	}
	
	@RequestMapping(value="/show",method={RequestMethod.GET,RequestMethod.POST})
	public String  showNews(HttpServletRequest request,Model model)
	{
		int id = Integer.parseInt(getNotNull("id", request));
		
		Announcement ann=this.tcAnnService.getAnnById(id);
		
		model.addAttribute("ann", ann);
		
		return "teacher/read-tips";

	}
	
	@RequestMapping(value="/create",method={RequestMethod.GET,RequestMethod.POST})
	public String createNews(HttpServletRequest request,Announcement ann)
	{
		if(request.getMethod().equalsIgnoreCase("GET"))
		{
			return "teacher/create-tip";
		}
		else
		{
			ann.setTeacher(UsersContext.getLoginSysName());
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date date = new Date();
			String date_str=dateFormat.format(date);
			ann.setTime(date_str);
			
			int user_id=UsersContext.getLoginSysId();
			
			boolean result=this.tcAnnService.addAnn(ann,user_id);
			if(result)
			{
				return "redirect:/tcAnn/listAnn";
			}else{
				return "redirect:/tcAnn/listAnn";
			}
		}
	}
	
	@RequestMapping(value="/modify",method={RequestMethod.GET,RequestMethod.POST})
	public String  modifyNews(HttpServletRequest request,Announcement ann,Model model)
	{
		if(request.getMethod().equalsIgnoreCase("GET")){
			
			int id = Integer.parseInt(getNotNull("id", request));
			
			ann=this.tcAnnService.getAnnById(id);
			
			model.addAttribute("ann", ann);
			
			return "/tcAnn/editAnn";
		}
		else
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date date = new Date();
			String date_str=dateFormat.format(date);
			ann.setTime(date_str);
			
			boolean result=this.tcAnnService.updateAnn(ann);
			if(result)
			{
				return "redirect:/tcAnn/listAnn";
			}
			else
			{
				return "redirect:/tcAnn/listAnn";
			}
		}
	}
	
	@RequestMapping(value="/detail/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public String detailNews(@PathVariable("id") int id ,HttpServletRequest request)
	{
		boolean result=this.tcAnnService.deleteAnnById(id);
		
		if(result)
		{
			return "redirect:/tcAnn/listAnn";
		}
		else
		{
			return "redirect:/tcAnn/listAnn";
		}
	}
	
	@InitBinder  
    protected void initBinder(WebDataBinder binder) {  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));  
    }
	
}
