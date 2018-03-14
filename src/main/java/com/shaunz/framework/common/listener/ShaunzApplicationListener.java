package com.shaunz.framework.common.listener;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.RequestHandledEvent;

import com.shaunz.framework.common.SourceTableGenerator;
import com.shaunz.webform.web.common.HomePageGenerator;

public class ShaunzApplicationListener implements ApplicationListener<ApplicationEvent>{
	private Logger logger = Logger.getLogger(ShaunzApplicationListener.class);
	
	@Resource
	private HomePageGenerator homePageGenerator;
	@Resource
	private SourceTableGenerator sourceTableGenerator;
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		
		/*if(event instanceof RequestHandledEvent){
			requestHandled(event);
			return ;
		}*/
		
		if(event instanceof ContextClosedEvent) {
	        applicationClosed(event);
	        return ;
	    }
		
		if(event instanceof ContextStoppedEvent){
			applicationStoped(event);
			return ;
		}
		
		if(event instanceof ContextStartedEvent){
			dapplicationStarted(event);
			return ;
		}

	    if(event instanceof ContextRefreshedEvent){
	    	applicationRefreshed(event);
	    } 
	    
	}
	
	private void applicationRefreshed(ApplicationEvent event){
		ContextRefreshedEvent e = (ContextRefreshedEvent) event;
	    ApplicationContext appContext = e.getApplicationContext();
	    if(appContext instanceof WebApplicationContext){
	    	sourceTableGenerator.init();
	    	//Generate Home page object and put it in the servlet context when start up.
	    	WebApplicationContext ctx = (WebApplicationContext) e.getApplicationContext();
		    ServletContext servletContext = ctx.getServletContext();
		    homePageGenerator.generateHomePage(servletContext);
		    
		    
	    }
	    
	    logger.info("Application Refreshed...");
	}
	
	private void dapplicationStarted(ApplicationEvent event){
		logger.info("Application Started...");
	}
	
	private void applicationStoped(ApplicationEvent event){
		logger.info("Application Stoped...");
	}
	
	private void applicationClosed(ApplicationEvent event){
		logger.info("Application Closed...");
	}
	
	private void requestHandled(ApplicationEvent event){
		logger.info("Request Handled...");
	}

}
