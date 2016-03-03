package com.lims.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lims.condition.ConsumableCondition;
import com.lims.controller.BaseController;
import com.lims.entity.Consumable;
import com.lims.service.ConsumableService;
import com.lims.utils.PageUtil;

@Controller
@RequestMapping("/consumable")
public class ConsumableController extends BaseController {
	
	@Autowired
	private ConsumableService consumableService;
	
	@RequestMapping(value="/list",method={RequestMethod.POST,RequestMethod.GET})
	public String listConsumable(ConsumableCondition condition,HttpServletRequest request,Model model)
	{
		int courrentPageSize=this.getPageSize(request);
		int courrentPageNum=this.getPageNum(request);
		
		List<Consumable> listConsumable=consumableService.listConsumableByPage(condition.filterCondition(),courrentPageNum,courrentPageSize);
		
		int consumableCount=consumableService.getPageCount(condition.filterCondition());
		
		PageUtil pageConsumable=new PageUtil(courrentPageSize, consumableCount, courrentPageNum);
		pageConsumable.setObject(listConsumable);
		
		model.addAttribute("page_vo", pageConsumable);
		model.addAttribute("queryCondition", condition);
		
		return "consumable/consumable_list";
	}

}
