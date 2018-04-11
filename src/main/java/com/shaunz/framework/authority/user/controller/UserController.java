package com.shaunz.framework.authority.user.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shaunz.framework.authority.user.entity.User;
import com.shaunz.framework.authority.user.service.UserService;
import com.shaunz.framework.common.SequenceGenerator;
import com.shaunz.framework.web.base.BaseController;

@Controller
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	@Autowired
	private SequenceGenerator sequenceGenerator;

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
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	@ResponseBody
	public String userList(User user){
		List<User> result = null;
		if(user != null && user.isAvaliableData()){
			result = userService.queryLst(user);
		} else {
			result = userService.queryAll();
		}
		return convertToJsonString(result);
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	@ResponseBody
	public String addUser(@Valid User user,BindingResult bindingResult,Locale locale){
		Map<String, String> results = new HashMap<String, String>();
		if(bindingResult.hasErrors()){
			results.put("error", messageSource.getMessage("validation.failed",null,locale));
		} else {
			user.setId(""+sequenceGenerator.getNextMngmtSequenceNo());
			userService.addNewUser(user);
		}
		
		return convertToJsonString(results);
	}
	
}
