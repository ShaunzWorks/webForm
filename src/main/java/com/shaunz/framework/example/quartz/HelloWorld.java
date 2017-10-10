package com.shaunz.framework.example.quartz;

import java.util.Date;

import org.apache.log4j.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloWorld implements Job{

    private static Logger logger = Logger.getLogger(HelloWorld.class);

    public HelloWorld() {
    }

    /**
     * spring 检测要求不带参数
     */
    public void execute() {
        logger.info("-----------------------------------------" +
                "\n\n I'm a RAM scheduler job! \n\n" +
                "-----------------------------------------" +
                new Date());
    }

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		logger.info("-----------------------------------------" +
                "\n\n I'm a JDBC scheduler job! \n\n" +
                "-----------------------------------------" +
                new Date());
	}
}
