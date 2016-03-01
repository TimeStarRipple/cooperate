package com.lims.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LimsSessionContextListener implements HttpSessionListener{
	
	public void sessionCreated(HttpSessionEvent event) {
		LimsSessionContext.getInstance().addSession(event.getSession());
	}

	public void sessionDestroyed(HttpSessionEvent event) 
	{
		LimsSessionContext.getInstance().removeSession(event.getSession());
	}

}
