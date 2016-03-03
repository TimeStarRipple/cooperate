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

import com.lims.condition.InstrumentConditon;
import com.lims.constants.JsonResult;
import com.lims.constants.ResultCode;
import com.lims.controller.BaseController;
import com.lims.entity.Instrument;
import com.lims.service.InstrumentService;
import com.lims.utils.PageUtil;

@Controller
@RequestMapping("/instrument")
public class InstrumentController extends BaseController {
	
	@Autowired
	private InstrumentService instrumentService;
	
	@RequestMapping(value="/list",method={RequestMethod.POST,RequestMethod.GET})
	public String listInstrument(HttpServletRequest request,InstrumentConditon condition,Model model)
	{
		int courrentPageNum=this.getPageNum(request);
		int courrentPageSize=this.getPageSize(request);
		
		List<Instrument> listInstrument=instrumentService.listInstrumentByPage(condition.filterCondition(),courrentPageNum,courrentPageSize);
		
		int instrumentCount=instrumentService.getPageCount(condition.filterCondition());
		
		PageUtil pageInstrument=new PageUtil(courrentPageSize, instrumentCount, courrentPageNum);
		pageInstrument.setObject(listInstrument);
		
		model.addAttribute("page_vo", pageInstrument);
		model.addAttribute("queryCondition", condition);
		
		return "instrument/instrument_list";
	}
	
	@ResponseBody
	@RequestMapping(value="/create")
	public Object createInstrument(HttpServletRequest request,Instrument instrument)
	{
		instrument.setCreateTime(new Date());
		
		boolean result=instrumentService.createInstrument(instrument);
		if(result)
		{
			Map<String,String> paramMap=new HashMap<String,String>();
			paramMap.put("url", request.getContextPath()+"/instrument/list");
			
			return new JsonResult(ResultCode.RETURN_SUCCESS, "创建成功", paramMap);
		}
		else
		{
			return new JsonResult(ResultCode.RETURN_FAILURE,"创建失败","");
		}
	}
	
	/**
	 * 编辑仪器
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/edit/{id}",method={RequestMethod.POST,RequestMethod.GET})
	public Object editInstrument(@PathVariable("id")int id,HttpServletRequest request,Model model)
	{
		Instrument instrument=instrumentService.getInstrumentById(id);
		return instrument;
	}
	
	@ResponseBody
	@RequestMapping(value="/modify",method={RequestMethod.POST,RequestMethod.GET})
	public Object modifyInstrument(HttpServletRequest request,Instrument instrument)
	{
		boolean result=instrumentService.modifyInstrument(instrument);
		if(result)
		{
			Map<String,String> paramMap=new HashMap<String,String>();
			paramMap.put("url", request.getContextPath()+"/instrument/list");
			
			return new JsonResult(ResultCode.RETURN_SUCCESS, "修改成功", paramMap);
		}
		else
		{
			return new JsonResult(ResultCode.RETURN_FAILURE,"修改失败","");
		}
	}
	

}
