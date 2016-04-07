package com.labcontroller.controller.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.labcontroller.context.UsersContext;
import com.labcontroller.controller.BaseController;
import com.labcontroller.entity.OrderLab;
import com.labcontroller.service.StuLabService;
import com.labcontroller.utils.PageUtil;

/***
 *学生加入的实验列表
 * @author  zhangyubin
 * 2015-12-26
 */

@Controller
@RequestMapping("/studentLab")
public class StuLabController extends BaseController{
	
	@Autowired
	private StuLabService stuLabService;
	
	@RequestMapping(value="/listStuLab",method={RequestMethod.GET,RequestMethod.POST})
	public String listAddLab(HttpServletRequest request,Model model)
	{
		
		int currentPageSize = this.getPageSize(request);
		int currentPageNum = this.getPageNum(request);
		
		int user_id=UsersContext.getLoginSysId();
		int sort=UsersContext.getLoginSort(); 
		
		List<OrderLab> listLabs=this.stuLabService.listStuLabByPage(currentPageNum, currentPageSize,user_id,2);
		
		int totalStuAnn=this.stuLabService.getPageCount(user_id,sort);
		
		PageUtil paging_vo = new PageUtil(currentPageSize, totalStuAnn, currentPageNum);
		
		paging_vo.setObject(listLabs);
		
		model.addAttribute("paging_vo",paging_vo);
		
		return "student/stu-lesson";
	}
	
	@RequestMapping(value="/delete",method={RequestMethod.GET,RequestMethod.POST})
	public String deleteStuLab(HttpServletRequest request,Model model)
	{
		int user_id=UsersContext.getLoginSysId();
		int id = Integer.parseInt(getNotNull("id", request));
		
		boolean result=this.stuLabService.deleteLabById(user_id,id);
		
		if(result)
		{
			return "redirect:/studentLab/listStuLab";
		}
		else
		{
			return "redirect:/studentLab/listStuLab";
		}
	}

}
