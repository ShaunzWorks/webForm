package com.shaunz.webform.web.manageplant.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shaunz.framework.web.base.BaseController;

@RequiresRoles("admin")
@Controller
public class ManagePlantController extends BaseController{
	
	
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
}
