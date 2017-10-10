package com.shaunz.photography.web.photography.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shaunz.photography.web.photography.entity.PhotoGraphy;

@Repository
public interface PhotoGraphyMapper {
    int deleteByPrimaryKey(String vchPhotoId);

    int insert(PhotoGraphy record);

    int insertSelective(PhotoGraphy record);

    PhotoGraphy selectByPrimaryKey(String vchPhotoId);
    
    List<PhotoGraphy> selectByParameter(PhotoGraphy photoGraphy);

    int updateByPrimaryKeySelective(PhotoGraphy record);

    int updateByPrimaryKey(PhotoGraphy record);
}