package com.shaunz.framework.authority.function.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shaunz.framework.authority.function.service.FunctionService;
import com.shaunz.framework.authority.user.entity.User;
import com.shaunz.framework.common.treemenu.TreeMenu;
import com.shaunz.framework.web.base.BaseController;

@Controller
public class FunctionController extends BaseController{
	
	@Autowired
	private FunctionService functionService;

	@RequestMapping(value="/functions",method=RequestMethod.GET)
	@ResponseBody
	public String generateMngmtTree(){
		User user = getUser();
		TreeMenu treeMenu = functionService.generateMngmtTree(user.getId());
		return convertToJsonString(treeMenu);
	}
	
	@RequestMapping(value="/object/{functionId:[\\d]+}/{objId:[\\d]+}",method=RequestMethod.GET)
	@ResponseBody
	public String findObjBy(@PathVariable("functionId")long functionId, @PathVariable("objId")long objId){
		Map<String, Object> obj = functionService.findObjectDetailBy(""+functionId, ""+objId);
		return convertToJsonString(obj);
	}
}
