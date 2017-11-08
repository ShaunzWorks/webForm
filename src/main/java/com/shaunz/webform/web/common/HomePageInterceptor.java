package com.shaunz.webform.web.common;

import javax.annotation.Resource;
import javax.interceptor.Interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shaunz.webform.web.home.entity.HomePage;

@Interceptor
public class HomePageInterceptor extends HandlerInterceptorAdapter{
	@Resource
	private HomePageGenerator homePageGenerator;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return super.preHandle(request, response, handler);
	}

}
