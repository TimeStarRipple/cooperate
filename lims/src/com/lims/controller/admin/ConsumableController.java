package com.lims.controller.admin;

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

import com.lims.condition.ConsumableCondition;
import com.lims.constants.JsonResult;
import com.lims.constants.ResultCode;
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
	
	@ResponseBody
	@RequestMapping(value="/create",method={RequestMethod.POST,RequestMethod.GET})
	public Object createConsumable(HttpServletRequest request,Consumable consumable)
	{
		consumable.setCreateTime(new Date());
		
		boolean result=consumableService.createConsumable(consumable);
		if(result)
		{
			Map<String,String> paramMap=new HashMap<String,String>();
			paramMap.put("url", request.getContextPath()+"/consumable/list");
			
			return new JsonResult(ResultCode.RETURN_SUCCESS, "创建成功", paramMap);
		}
		else
		{
			return new JsonResult(ResultCode.RETURN_FAILURE, "创建失败", "");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/edit/{id}",method={RequestMethod.POST,RequestMethod.GET})
	public Object editInstrument(@PathVariable("id")int id,HttpServletRequest request,Model model)
	{
		Consumable consumable=consumableService.getConsumableById(id);
		return consumable;
	}
	
	@ResponseBody
	@RequestMapping(value="/modify",method={RequestMethod.POST,RequestMethod.GET})
	public Object modifyInstrument(HttpServletRequest request,Consumable consumable)
	{
		boolean result=consumableService.modifyConsumable(consumable);
		if(result)
		{
			Map<String,String> paramMap=new HashMap<String,String>();
			paramMap.put("url", request.getContextPath()+"/consumable/list");
			
			return new JsonResult(ResultCode.RETURN_SUCCESS, "修改成功", paramMap);
		}
		else
		{
			return new JsonResult(ResultCode.RETURN_FAILURE,"修改失败","");
		}
	}

}
