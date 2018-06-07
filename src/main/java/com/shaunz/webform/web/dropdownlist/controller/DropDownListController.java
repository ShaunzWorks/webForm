package com.shaunz.webform.web.dropdownlist.controller;

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
import com.shaunz.webform.web.dropdownlist.entity.DropDownList;
import com.shaunz.webform.web.dropdownlist.service.DropDownListService;
import com.shaunz.webform.web.home.entity.HomePage;
import com.shaunz.webform.web.navigationbar.service.NavigationBarService;

@Controller
public class DropDownListController extends BaseController{
	@Autowired
	SequenceGenerator sequenceGenerator;
	@Autowired
	DropDownListService dropDownListService;
	@Autowired
	NavigationBarService navigationBarService;
	
	@RequestMapping(value="/dropdownlist/dropdownlist_lst.html",method=RequestMethod.GET)
	public String lstPage(){
		return "dropdownlist/dropdownlist_lst";
	}
	@RequestMapping(value="/dropdownlist/dropdownlist_add.html",method=RequestMethod.GET)
	public String addPage(){
		return "dropdownlist/dropdownlist_add";
	}
	@RequestMapping(value="/dropdownlist/dropdownlist_edit.html",method=RequestMethod.GET)
	public ModelAndView editPage(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		DropDownList dropDownList = dropDownListService.selectByPrimaryKey(id);
		result.put("dropdownlist", dropDownList);
		return new ModelAndView("dropdownlist/dropdownlist_edit",result);
	}
	
	@RequiresPermissions("15.query")
	@RequestMapping(value="/dropdownlist",method=RequestMethod.GET)
	@ResponseBody
	public String lst(){
		List<DropDownList> dropDownLists = dropDownListService.queryList();
		return convertToJsonString(dropDownLists);
	}
	
	@RequiresPermissions("15.add")
	@RequestMapping(value="/dropdownlist",method=RequestMethod.POST)
	@ResponseBody
	@ShaunzAuditLog(optType="add",functionId="15")
	public String add(DropDownList dropDownList,BindingResult bindingResult,Locale locale){
		Map<String, String> results = new HashMap<String, String>();
		if(bindingResult.hasErrors()){
			results.put("result", "error");
			results.put("message", messageSource.getMessage("validation.failed",null,locale));
		} else {
			dropDownList.setId(""+sequenceGenerator.getNextMngmtSequenceNo());
			dropDownList.setCloseFlg("N");
			boolean flag = dropDownListService.insertSelective(dropDownList);
			dropDownList.setOptFlag(flag);
			if(flag){
				refreshHomepage();
			}
			return formSubmitResult(flag, "common.addMsg", new Object[]{messageSource.getMessage("dropdownlist.title", null, locale),dropDownList.getName()}
					, locale);
		}
		return convertToJsonString(results);
	
	}
	
	@RequiresPermissions("15.update")
	@RequestMapping(value="/dropdownlist",method=RequestMethod.PUT)
	@ResponseBody
	@ShaunzAuditLog(optType="update",functionId="15")
	public String edit(DropDownList dropDownList,Locale locale){
		boolean flag = dropDownListService.updateByPrimaryKeySelective(dropDownList);
		dropDownList.setOptFlag(flag);
		if(flag){
			refreshHomepage();
		}
		return formSubmitResult(flag, "common.updateMsg", new Object[]{messageSource.getMessage("dropdownlist.title", null, locale),dropDownList.getName()}
		, locale);
	}
	
	@RequiresPermissions("15.delete")
	@RequestMapping(value="/dropdownlist/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	@ShaunzAuditLog(optType="delete",functionId="15")
	public String delete(@PathVariable("id") String id,Locale locale){
		DropDownList dropDownList = dropDownListService.selectByPrimaryKey(id);
		boolean flag = dropDownListService.close(dropDownList);
		if(flag){
			refreshHomepage();
		}
		return formSubmitResult(flag, "common.deleteMsg", new Object[]{messageSource.getMessage("dropdownlist.title", null, locale),dropDownList.getName()}
		, locale);
	}
	
	private void refreshHomepage(){
		HomePage homePage = null;
		try {
			homePage = (HomePage)request.getServletContext().getAttribute("homePageObject");
			homePage.setNavigationBars(navigationBarService.queryAllNavigationBar());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}



}
