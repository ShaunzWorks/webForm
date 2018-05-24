package com.shaunz.webform.web.navigationbar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shaunz.framework.common.SequenceGenerator;
import com.shaunz.framework.common.auditlogs.ShaunzAuditLog;
import com.shaunz.framework.web.base.BaseController;
import com.shaunz.webform.web.home.entity.HomePage;
import com.shaunz.webform.web.navigationbar.entity.NavigationBar;
import com.shaunz.webform.web.navigationbar.service.NavigationBarService;

@Controller
public class NavigationBarController extends BaseController{

	@Autowired
	SequenceGenerator sequenceGenerator;
	@Autowired
	NavigationBarService navigationBarService;
	
	@RequestMapping(value="/navigationbar/navigationbar_lst.html",method=RequestMethod.GET)
	public String authorLstPage(){
		return "navigationbar/navigationbar_lst";
	}
	@RequestMapping(value="/navigationbar/navigationbar_add.html",method=RequestMethod.GET)
	public String authorAddPage(){
		return "navigationbar/navigationbar_add";
	}
	@RequestMapping(value="/navigationbar/navigationbar_edit.html",method=RequestMethod.GET)
	public ModelAndView authorEditPage(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		NavigationBar navigationBar = navigationBarService.selectByPrimaryKey(id);
		result.put("navigationBar", navigationBar);
		return new ModelAndView("navigationbar/navigationbar_edit",result);
	}
	
	@RequiresPermissions("5.query")
	@RequestMapping(value="/navigationbar",method=RequestMethod.GET)
	@ResponseBody
	public String authorLst(){
		List<NavigationBar> authors = navigationBarService.queryList();
		return convertToJsonString(authors);
	}
	
	@RequiresPermissions("5.add")
	@RequestMapping(value="/navigationbar",method=RequestMethod.POST)
	@ResponseBody
	@ShaunzAuditLog(optType="add",functionId="5")
	public String authorAdd(NavigationBar navigationBar,BindingResult bindingResult,Locale locale){
		Map<String, String> results = new HashMap<String, String>();
		if(bindingResult.hasErrors()){
			results.put("result", "error");
			results.put("message", messageSource.getMessage("validation.failed",null,locale));
		} else {
			navigationBar.setId(""+sequenceGenerator.getNextMngmtSequenceNo());
			navigationBar.setCloseFlg("N");
			boolean flag = navigationBarService.insertSelective(navigationBar);
			navigationBar.setOptFlag(flag);
			if(flag){
				refreshNavigationBarInHomepage();
			}
			return formSubmitResult(flag, "common.addMsg", new Object[]{messageSource.getMessage("navigationbar.title", null, locale),navigationBar.getName()}
					, locale);
		}
		return convertToJsonString(results);
	
	}
	
	@RequiresPermissions("5.update")
	@RequestMapping(value="/navigationbar",method=RequestMethod.PUT)
	@ResponseBody
	@ShaunzAuditLog(optType="update",functionId="5")
	public String authorEdit(NavigationBar navigationBar,Locale locale){
		boolean flag = navigationBarService.updateByPrimaryKeySelective(navigationBar);
		navigationBar.setOptFlag(flag);
		if(flag){
			refreshNavigationBarInHomepage();
		}
		return formSubmitResult(flag, "common.updateMsg", new Object[]{messageSource.getMessage("navigationbar.title", null, locale),navigationBar.getName()}
		, locale);
	}
	
	@RequiresPermissions("5.delete")
	@RequestMapping(value="/navigationbar/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	@ShaunzAuditLog(optType="delete",functionId="5")
	public String authorDelete(@PathVariable("id") String id,Locale locale){
		NavigationBar navigationBar = navigationBarService.selectByPrimaryKey(id);
		boolean flag = navigationBarService.closeAuthor(navigationBar);
		if(flag){
			refreshNavigationBarInHomepage();
		}
		return formSubmitResult(flag, "common.deleteMsg", new Object[]{messageSource.getMessage("navigationbar.title", null, locale),navigationBar.getName()}
		, locale);
	}
	
	private void refreshNavigationBarInHomepage(){
		HomePage homePage = null;
		try {
			homePage = (HomePage)request.getServletContext().getAttribute("homePageObject");
			homePage.setNavigationBars(navigationBarService.queryAllNavigationBar());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}

}
