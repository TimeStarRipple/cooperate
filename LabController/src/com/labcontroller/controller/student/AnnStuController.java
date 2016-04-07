package com.labcontroller.controller.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.labcontroller.controller.BaseController;
import com.labcontroller.entity.Announcement;
import com.labcontroller.service.AnnService;
import com.labcontroller.utils.PageUtil;

/***
 *学生查看公告
 * @author  zhangyubin
 * 2015-12-26
 */

@Controller
@RequestMapping("/stuAnn")
public class AnnStuController extends BaseController{
	
	@Autowired
	private AnnService annService;
	
	@RequestMapping(value="/listAnn",method={RequestMethod.GET,RequestMethod.POST})
	public String listAnn(HttpServletRequest request,Model model)
	{
		
		int currentPageSize = this.getPageSize(request);
		int currentPageNum = this.getPageNum(request);
		
		List<Announcement> listAnn=this.annService.listAnnByPage(currentPageNum, currentPageSize);
		
		int totalNews=this.annService.getPageCount();
		
		PageUtil paging_vo = new PageUtil(currentPageSize, totalNews, currentPageNum);
		
		paging_vo.setObject(listAnn);
		
		model.addAttribute("paging_vo",paging_vo);
		
		return "student/stu-index";
	}
	
	@RequestMapping(value="/show",method={RequestMethod.GET,RequestMethod.POST})
	public String  showNews(HttpServletRequest request,Model model)
	{
		int id = Integer.parseInt(getNotNull("id", request));
		
		Announcement ann=this.annService.getAnnById(id);
		
		model.addAttribute("ann", ann);
		
		return "teacher/read-tips";

	}

}
