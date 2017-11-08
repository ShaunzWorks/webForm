package com.shaunz.webform.web.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shaunz.framework.web.base.BaseController;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{
	@RequestMapping("/index")
    public String homePage(){
    	return "index";
    }
}
