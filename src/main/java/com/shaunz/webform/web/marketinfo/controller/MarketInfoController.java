package com.shaunz.webform.web.marketinfo.controller;

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
import com.shaunz.webform.web.marketinfo.entity.MarketInfo;
import com.shaunz.webform.web.marketinfo.service.MarketInfoService;

@Controller
public class MarketInfoController extends BaseController{
	@Autowired
	SequenceGenerator sequenceGenerator;
	@Autowired
	MarketInfoService marketInfoService;
	
	@RequestMapping(value="/market/market_lst.html",method=RequestMethod.GET)
	public String lstPage(){
		return "market/market_lst";
	}
	@RequestMapping(value="/market/market_add.html",method=RequestMethod.GET)
	public String addPage(){
		return "market/market_add";
	}
	@RequestMapping(value="/market/market_edit.html",method=RequestMethod.GET)
	public ModelAndView editPage(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		MarketInfo marketInfo = marketInfoService.selectByPrimaryKey(id);
		result.put("market", marketInfo);
		return new ModelAndView("market/market_edit",result);
	}
	
	@RequiresPermissions("7.query")
	@RequestMapping(value="/market",method=RequestMethod.GET)
	@ResponseBody
	public String lst(){
		List<MarketInfo> marketInfos = marketInfoService.queryList();
		return convertToJsonString(marketInfos);
	}
	
	@RequiresPermissions("7.add")
	@RequestMapping(value="/market",method=RequestMethod.POST)
	@ResponseBody
	@ShaunzAuditLog(optType="add",functionId="7")
	public String add(MarketInfo marketInfo,BindingResult bindingResult,Locale locale){
		Map<String, String> results = new HashMap<String, String>();
		if(bindingResult.hasErrors()){
			results.put("result", "error");
			results.put("message", messageSource.getMessage("validation.failed",null,locale));
		} else {
			marketInfo.setId(""+sequenceGenerator.getNextMngmtSequenceNo());
			marketInfo.setCloseFlg("N");
			boolean flag = marketInfoService.insertSelective(marketInfo);
			marketInfo.setOptFlag(flag);
			if(flag){
				refreshHomepage();
			}
			return formSubmitResult(flag, "common.addMsg", new Object[]{messageSource.getMessage("market.title", null, locale),marketInfo.getName()}
					, locale);
		}
		return convertToJsonString(results);
	
	}
	
	@RequiresPermissions("7.update")
	@RequestMapping(value="/market",method=RequestMethod.PUT)
	@ResponseBody
	@ShaunzAuditLog(optType="update",functionId="7")
	public String edit(MarketInfo marketInfo,Locale locale){
		boolean flag = marketInfoService.updateByPrimaryKeySelective(marketInfo);
		marketInfo.setOptFlag(flag);
		if(flag){
			refreshHomepage();
		}
		return formSubmitResult(flag, "common.updateMsg", new Object[]{messageSource.getMessage("market.title", null, locale),marketInfo.getName()}
		, locale);
	}
	
	@RequiresPermissions("7.delete")
	@RequestMapping(value="/market/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	@ShaunzAuditLog(optType="delete",functionId="7")
	public String delete(@PathVariable("id") String id,Locale locale){
		MarketInfo marketInfo = marketInfoService.selectByPrimaryKey(id);
		boolean flag = marketInfoService.close(marketInfo);
		if(flag){
			refreshHomepage();
		}
		return formSubmitResult(flag, "common.deleteMsg", new Object[]{messageSource.getMessage("market.title", null, locale),marketInfo.getName()}
		, locale);
	}
	
	private void refreshHomepage(){
		HomePage homePage = null;
		try {
			homePage = (HomePage)request.getServletContext().getAttribute("homePageObject");
			homePage.setMarketInfos(marketInfoService.quaryAll());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}


}
