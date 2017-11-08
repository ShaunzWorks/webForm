package com.shaunz.webform.web.source.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shaunz.webform.web.source.entity.Source;

@Repository
public interface SourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Source record);

    int insertSelective(Source record);

    Source selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Source record);

    int updateByPrimaryKey(Source record);
    
    List<Source> quaryAll();
}