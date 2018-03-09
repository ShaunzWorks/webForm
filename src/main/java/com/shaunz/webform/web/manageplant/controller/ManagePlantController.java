package com.shaunz.webform.web.manageplant.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shaunz.framework.authority.function.service.FunctionService;
import com.shaunz.framework.web.base.BaseController;

@Controller
public class ManagePlantController extends BaseController{
	@Resource
	private FunctionService functionService;
	
	@RequiresRoles("admin")
	@RequestMapping(value="/managePlant.html",method=RequestMethod.POST)
	public String managePlantPage(){
		return "managePlantPage";
	}
}
