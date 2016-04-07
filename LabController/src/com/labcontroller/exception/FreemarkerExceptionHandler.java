package com.labcontroller.exception;

import java.io.IOException;
import java.io.Writer;
import org.apache.log4j.Logger;
import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerExceptionHandler implements TemplateExceptionHandler {

	private static final Logger logger = Logger.getLogger(FreemarkerExceptionHandler.class);

	public void handleTemplateException(TemplateException te, Environment env, Writer out) 
	        throws TemplateException 
    {
		logger.error("[FreemarkerExceptionHandler][Freemarker Error: " + te.getMessage() + "]");
		try 
		{
			out.write("[ERROR: " + te.getMessage() + "]");
		} 
		catch(IOException e)
		{
			throw new TemplateException("Failed to print error message. Cause: " + e, env);
		}
	}
}