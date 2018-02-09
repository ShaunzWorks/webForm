package com.shaunz.framework.web.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version 1.0.0
 * @author Shaun Deng
 * @since 2016-06-21
 */
@Controller
public class BaseController {
	protected static final String FORWARD_TO = "forward:";
	protected static final String REDIRECT_TO = "redirect:";
	
	@Autowired
	protected MessageSource messageSource;
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	
	protected  Logger logger = Logger.getLogger(this.getClass());
	
	@ModelAttribute 
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){ 
        this.request = request; 
        this.response = response; 
        this.session = request.getSession(); 
    }
	
	public String getParameter(String key){
		if(StringUtils.isEmpty(key)) return null;
		return request.getParameter(key);
	}
	
	public void setAttribuate(String key,Object o){
		request.setAttribute(key, o);
	}
	
	@ExceptionHandler
	public ModelAndView ExceptionHandler(HttpServletRequest request,Exception ex){
		StringPrintWriter spw=new StringPrintWriter();
		ex.printStackTrace(spw); 
		logger.error("[ExceptionHandler:]"+spw.getString());
		return new ModelAndView("error/exception","exception",ex.getMessage());
	}
	
	public class StringPrintWriter extends PrintWriter{
		public StringPrintWriter(){  
	        super(new StringWriter());  
	    }  
	     
	    public StringPrintWriter(int initialSize) {  
	          super(new StringWriter(initialSize));  
	    }  
	     
	    public String getString() {  
	          flush();  
	          return ((StringWriter) this.out).toString();  
	    }  
	     
	    @Override  
	    public String toString() {  
	        return getString();  
	    }  
	}
	
	protected Map<String, Object> generateResultMap() {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		return resultMap;
	}
}
