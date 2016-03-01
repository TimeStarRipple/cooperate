package com.lims.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String indexPage(Model model,HttpServletRequest request)
	{
		return "/index";
	}
	
	@RequestMapping("/default")
	public String defaultPage(Model model,HttpServletRequest request)
	{
		return "/default";
	}

}
