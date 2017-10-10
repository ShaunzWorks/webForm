package com.shaunz.framework.example.aspectj;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.shaunz.framework.example.annotation.AspectJTest;


@Aspect
@Component
public class AspectTestClass {
	private static Logger logger = Logger.getLogger(AspectTestClass.class);
	
	@Pointcut("@annotation(com.shaunz.framework.example.annotation.AspectJTest)")
	public void testAspect(){
		
	}
	@Before("testAspect()")
	public void doBefore(JoinPoint joinPoint){
		AspectJTest aspectJTestAnnotation = null;
		try {
			aspectJTestAnnotation = getAspectJTest(joinPoint);
			logger.info("before called and parameter is: " + aspectJTestAnnotation.name());;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	@After("@annotation(com.shaunz.framework.example.annotation.AspectJTest)")
	public void doAfter(JoinPoint joinPoint){
		AspectJTest aspectJTestAnnotation = null;
		try {
			aspectJTestAnnotation = getAspectJTest(joinPoint);
			logger.info("after called and parameter is: " + aspectJTestAnnotation.name());;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	/*
	@Around("@annotation(com.shaunz.framework.example.annotation.AspectJTest)")
	public void doAround(JoinPoint joinPoint){
		AspectJTest aspectJTestAnnotation = null;
		try {
			aspectJTestAnnotation = getAspectJTest(joinPoint);
			logger.info("around called and parameter is: " + aspectJTestAnnotation.name());;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}*/
	@AfterThrowing(pointcut="@annotation(com.shaunz.framework.example.annotation.AspectJTest)",throwing="e")
	public void doAfterThrowing(JoinPoint joinPoint,Exception e){
		AspectJTest aspectJTestAnnotation = null;
		try {
			aspectJTestAnnotation = getAspectJTest(joinPoint);
			logger.info("afterThrowing called and parameter is: " + aspectJTestAnnotation.name() + " and exception is " + e.getMessage());;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		
	}
	private AspectJTest getAspectJTest(JoinPoint joinPoint) throws Exception{
		AspectJTest fourAOptExceptionLog = null;
		Annotation[] allAnnotations = getMethodAnnotation(joinPoint);
		if(allAnnotations != null && allAnnotations.length > 0){
			for (int i = 0; i < allAnnotations.length; i++) {
				Annotation annotation = allAnnotations[i];
				if(annotation.annotationType().equals(AspectJTest.class)){
					fourAOptExceptionLog = (AspectJTest) annotation;
				}
			}
			return fourAOptExceptionLog;
		} else {
			return fourAOptExceptionLog;
		}
	}
	private Annotation[] getMethodAnnotation(JoinPoint joinPoint) throws Exception {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		if (method != null) {
			return method.getDeclaredAnnotations();
		}
		return null;
	}
}
