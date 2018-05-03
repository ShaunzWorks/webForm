package com.shaunz.webform.web.manageplant.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shaunz.framework.authority.user.entity.User;
import com.shaunz.framework.authority.user.service.UserService;
import com.shaunz.framework.web.base.BaseController;

@RequiresRoles("admin")
@Controller
public class ManagePlantController extends BaseController{
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/managePlant.html",method=RequestMethod.POST)
	public String managePlantPage(){
		return "managePlantPage";
	}
	
	@RequestMapping(value="mngpages/dashboard.html",method=RequestMethod.GET)
	public String dashboardPage(){
		return "mngpages/dashboard";
	}
	
	@RequestMapping(value="/mngpages/account_lst.html",method=RequestMethod.GET)
	public String accountLstPage(){
		return "mngpages/account_lst";
	}
	
	@RequestMapping(value="/mngpages/account_add.html",method=RequestMethod.GET)
	public String accountAddPage(){
		return "mngpages/account_add";
	}
	
	@RequestMapping(value="/mngpages/account_edit.html",method=RequestMethod.GET)
	public ModelAndView accountEditPage(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		User user = userService.selectByPrimaryKey(id);
		user.dateConverter();
		result.put("user", user);
		return new ModelAndView("mngpages/account_edit", result);
	}
}
