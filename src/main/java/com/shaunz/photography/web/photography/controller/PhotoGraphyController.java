package com.shaunz.photography.web.photography.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shaunz.framework.web.base.BaseController;
import com.shaunz.photography.web.photography.entity.PhotoGraphy;
import com.shaunz.photography.web.photography.service.PhotoGraphyService;

@Controller
@RequestMapping("/photography")
public class PhotoGraphyController extends BaseController{
	@Resource
	private PhotoGraphyService photoGraphyService;
	@RequestMapping(value="/photography",method=RequestMethod.GET)
	@ResponseBody
	public List<PhotoGraphy> queryPhotoGraphy(PhotoGraphy photoGraphy){
		List<PhotoGraphy> result = photoGraphyService.selectByParameter(photoGraphy);
		return result;
	}
}
