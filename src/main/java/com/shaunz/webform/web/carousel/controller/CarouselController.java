package com.shaunz.webform.web.carousel.controller;

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
import com.shaunz.webform.web.carousel.entity.Carousel;
import com.shaunz.webform.web.carousel.service.CarouselService;
import com.shaunz.webform.web.home.entity.HomePage;

@Controller
public class CarouselController extends BaseController{

	@Autowired
	SequenceGenerator sequenceGenerator;
	@Autowired
	CarouselService carouselService;
	
	@RequestMapping(value="/carousel/carousel_lst.html",method=RequestMethod.GET)
	public String lstPage(){
		return "carousel/carousel_lst";
	}
	@RequestMapping(value="/carousel/carousel_add.html",method=RequestMethod.GET)
	public String addPage(){
		return "carousel/carousel_add";
	}
	@RequestMapping(value="/carousel/carousel_edit.html",method=RequestMethod.GET)
	public ModelAndView editPage(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		Carousel carousel = carouselService.selectByPrimaryKey(id);
		result.put("carousel", carousel);
		return new ModelAndView("carousel/carousel_edit",result);
	}
	
	@RequiresPermissions("7.query")
	@RequestMapping(value="/carousel",method=RequestMethod.GET)
	@ResponseBody
	public String lst(){
		List<Carousel> carousels = carouselService.queryList();
		return convertToJsonString(carousels);
	}
	
	@RequiresPermissions("7.add")
	@RequestMapping(value="/carousel",method=RequestMethod.POST)
	@ResponseBody
	@ShaunzAuditLog(optType="add",functionId="7")
	public String add(Carousel carousel,BindingResult bindingResult,Locale locale){
		Map<String, String> results = new HashMap<String, String>();
		if(bindingResult.hasErrors()){
			results.put("result", "error");
			results.put("message", messageSource.getMessage("validation.failed",null,locale));
		} else {
			carousel.setId(""+sequenceGenerator.getNextMngmtSequenceNo());
			carousel.setCloseFlg("N");
			boolean flag = carouselService.insertSelective(carousel);
			carousel.setOptFlag(flag);
			if(flag){
				refreshHomepage();
			}
			return formSubmitResult(flag, "common.addMsg", new Object[]{messageSource.getMessage("carousel.title", null, locale),carousel.getName()}
					, locale);
		}
		return convertToJsonString(results);
	
	}
	
	@RequiresPermissions("7.update")
	@RequestMapping(value="/carousel",method=RequestMethod.PUT)
	@ResponseBody
	@ShaunzAuditLog(optType="update",functionId="7")
	public String edit(Carousel carousel,Locale locale){
		boolean flag = carouselService.updateByPrimaryKeySelective(carousel);
		carousel.setOptFlag(flag);
		if(flag){
			refreshHomepage();
		}
		return formSubmitResult(flag, "common.updateMsg", new Object[]{messageSource.getMessage("carousel.title", null, locale),carousel.getName()}
		, locale);
	}
	
	@RequiresPermissions("7.delete")
	@RequestMapping(value="/carousel/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	@ShaunzAuditLog(optType="delete",functionId="7")
	public String delete(@PathVariable("id") String id,Locale locale){
		Carousel carousel = carouselService.selectByPrimaryKey(id);
		boolean flag = carouselService.close(carousel);
		if(flag){
			refreshHomepage();
		}
		return formSubmitResult(flag, "common.deleteMsg", new Object[]{messageSource.getMessage("carousel.title", null, locale),carousel.getName()}
		, locale);
	}
	
	private void refreshHomepage(){
		HomePage homePage = null;
		try {
			homePage = (HomePage)request.getServletContext().getAttribute("homePageObject");
			homePage.setCarousels(carouselService.quaryAll());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
