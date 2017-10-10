package com.shaunz.photography.web.photography.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shaunz.framework.web.base.BaseService;
import com.shaunz.photography.web.photography.dao.PhotoGraphyMapper;
import com.shaunz.photography.web.photography.entity.PhotoGraphy;

@Service
public class PhotoGraphyService extends BaseService{
	private PhotoGraphyMapper photoGraphyMapper;
	public int deleteByPrimaryKey(String vchPhotoId){
		return photoGraphyMapper.deleteByPrimaryKey(vchPhotoId);
	}

	public int insert(PhotoGraphy record){
		return photoGraphyMapper.insert(record);
	}

	public int insertSelective(PhotoGraphy record){
		return photoGraphyMapper.insertSelective(record);
	}

	public PhotoGraphy selectByPrimaryKey(String vchPhotoId){
		return photoGraphyMapper.selectByPrimaryKey(vchPhotoId);
	}
	
	public List<PhotoGraphy> selectByParameter(PhotoGraphy photoGraphy){
		return photoGraphyMapper.selectByParameter(photoGraphy);
	}

	public int updateByPrimaryKeySelective(PhotoGraphy record){
		return photoGraphyMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(PhotoGraphy record){
		return photoGraphyMapper.updateByPrimaryKey(record);
	}
}
