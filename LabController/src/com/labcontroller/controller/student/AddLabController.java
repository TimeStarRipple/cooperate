package com.labcontroller.controller.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.labcontroller.context.UsersContext;
import com.labcontroller.service.AddLabService;
import com.labcontroller.controller.BaseController;
import com.labcontroller.entity.OrderLab;
import com.labcontroller.entity.UserLab;
import com.labcontroller.utils.PageUtil;

/***
 *学生加入实验
 * @author  zhangyubin
 * 2015-12-24
 */
@Controller
@RequestMapping("/student")
public class AddLabController extends BaseController{
	
	@Autowired
	private AddLabService addLabService;
	
	@RequestMapping(value="/listAddLab",method={RequestMethod.GET,RequestMethod.POST})
	public String listAddLab(HttpServletRequest request,Model model)
	{
		
		int currentPageSize = this.getPageSize(request);
		int currentPageNum = this.getPageNum(request);
		
		int user_id=UsersContext.getLoginSysId();
		
		List<OrderLab> listLabs=this.addLabService.listAddLabByPage(currentPageNum, currentPageSize,user_id);
		
		int totalNews=this.addLabService.getPageCount();
		
		PageUtil paging_vo = new PageUtil(currentPageSize, totalNews, currentPageNum);
		
		paging_vo.setObject(listLabs);
		
		model.addAttribute("paging_vo",paging_vo);
		
		return "student/stu-join";
	}
	
	@RequestMapping(value="/addLab",method={RequestMethod.GET,RequestMethod.POST})
	public String addLab(HttpServletRequest request,Model model)
	{
		int id = Integer.parseInt(getNotNull("id", request));
		int number=Integer.parseInt(getNotNull("number", request));
		int user_id=UsersContext.getLoginSysId();
		int sort=UsersContext.getLoginSort();
		
		UserLab userlab=new UserLab();
		userlab.setSort(sort);
		userlab.setUser_id(user_id);
		userlab.setExperiment_id(id);
		
		boolean result=this.addLabService.addNumber(id,number,userlab);
		
		if(result)
		{
			return "redirect:/student/listAddLab";
		}
		else
		{
			return "redirect:/student/listAddLab";
		}
	}

}
