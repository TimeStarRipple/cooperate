package com.lims.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.lims.constants.UsersConstant;
import com.lims.entity.Users;

/**
 * 基本控制层
 * @author zhangyubin(copy from wangfucai)
 * 2016-2-27
 */
public class BaseController {

	/**
	 * 设置不要缓存数据
	 * @param response
	 */
	public void setNoCache(HttpServletResponse response) {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
	}
	
	/** 写入信息 */
	private void write(String contentType, HttpServletRequest req, HttpServletResponse resp, String msg) throws ServletException, IOException {
		resp.setContentType(contentType);
		OutputStreamWriter out = new OutputStreamWriter(resp.getOutputStream(), "UTF-8");
		out.write(msg);
		resp.setContentLength(msg.getBytes("UTF-8").length);
		out.flush();
	}

	protected void writeJson(HttpServletRequest req, HttpServletResponse resp, String msg) throws ServletException, IOException {
		write("application/json; charset=\"UTF-8\"", req, resp, msg);
	}

	protected void writeXml(HttpServletRequest req, HttpServletResponse resp, String msg) throws ServletException, IOException {
		write("application/xml; charset=\"UTF-8\"", req, resp, msg);
	}

	protected void writeFile(HttpServletRequest req, HttpServletResponse resp, String fileName, InputStream in) throws ServletException, IOException {
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		resp.setContentType("application/x-zip-compressed; charset=\"UTF-8\"");
		writeImage(req, resp, in);
	}

	protected void writeExcel(HttpServletRequest req, HttpServletResponse resp, String fileName, OutputStream out) throws ServletException,
			IOException {
		resp.setHeader("Content-Disposition", "attachment; filename=stat_data.xls");
		resp.setHeader("Content-Type", "application/vnd.ms-excel");
		resp.setContentType("application/vnd.ms-excel; charset=\"UTF-8\"");
		out.flush();
		out.close();
	}

	protected void writeImage(HttpServletRequest req, HttpServletResponse resp, InputStream imageIn) throws ServletException, IOException {
		OutputStream output = resp.getOutputStream();
		BufferedInputStream bis = new BufferedInputStream(imageIn);// 输入缓冲流
		BufferedOutputStream bos = new BufferedOutputStream(output);// 输出缓冲流
		byte data[] = new byte[4096];// 缓冲字节数
		int size = 0;
		size = bis.read(data);
		while (size != -1) {
			bos.write(data, 0, size);
			size = bis.read(data);
		}
		bis.close();
		bos.flush();// 清空输出缓冲流
		bos.close();
		output.close();
	}
	
	public String getNotNull(String key, HttpServletRequest req)
	{
		String value = req.getParameter(key);
		return (value == null ? "" : value.trim());
	}
	
	//分页相关
	public int getPageNum(HttpServletRequest request)
	{
		int currentPageNum=0;
		try
		{
			String pageNum =this.getNotNull("page_num", request);
			if(StringUtils.isBlank(pageNum))
			{
				currentPageNum=0;
			}
			else
			{
				currentPageNum=Integer.parseInt(pageNum);
			}
		} 
		catch (NumberFormatException ne)
		{
			currentPageNum=0;
		}
		return currentPageNum;
	}
	
	public int getPageSize(HttpServletRequest request) 
	{
		int currentPageSize=10;
				
		try
		{
			String pageSize=this.getNotNull("page_size", request);
			
			if(StringUtils.isBlank(pageSize))
			{
				currentPageSize=10;
			}
			else
			{
				currentPageSize=Integer.parseInt(pageSize);
			}
			
		} 
		catch (NumberFormatException ne) 
		{
			currentPageSize=10;
		}
		return currentPageSize;
	}
	
	public long getUid(HttpServletRequest request)
	{
		Users user=(Users)request.getSession().getAttribute(UsersConstant.LOGIN_SESSION_USERS);
		return user.getId();
	}

}
