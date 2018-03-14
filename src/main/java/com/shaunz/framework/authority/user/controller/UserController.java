package com.shaunz.framework.authority.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shaunz.framework.authority.user.entity.User;
import com.shaunz.framework.web.base.BaseController;

public class UserController extends BaseController{

	@RequestMapping(value="/crrentUser",method=RequestMethod.GET)
	@ResponseBody
	public String getCurrentUsr(){
		Subject subject = SecurityUtils.getSubject();
		User usrRet = null;
		if(subject.isAuthenticated()){
			User user = (User)session.getAttribute("user");
			try {
				usrRet = (User) user.clone();
				usrRet.deSensitive();
			} catch (CloneNotSupportedException e) {
				logger.error(e);
			}
		}
		return convertToJsonString(usrRet);
	}
}
