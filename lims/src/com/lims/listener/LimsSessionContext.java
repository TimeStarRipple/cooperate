package com.lims.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;


/**
 *  CTMS session上下文
 * @author zhangyubin
 */

public class LimsSessionContext {

	public Map<String,HttpSession> sessionMap=new HashMap<String,HttpSession>();
	
	public static LimsSessionContext limsSessionContext = new LimsSessionContext();
	
	private LimsSessionContext()
	{
		//单例模式
	}
	
	public synchronized static LimsSessionContext getInstance()
	{
		if(limsSessionContext==null)
		{
			return new LimsSessionContext();
		}
		return limsSessionContext;
	}
	
	public void addSession(HttpSession session)
	{
		if(session!=null)
		{
			sessionMap.put(session.getId(), session);
		}
	}
	
	public void removeSession(HttpSession session)
	{
		if(session!=null)
		{
			sessionMap.remove(session.getId());
		}	
	}
	
	public HttpSession getSession(String sessionId)
	{
		if(StringUtils.isNotBlank(sessionId))
		{
			return sessionMap.get(sessionId);
		}
		return null;
	}
}
