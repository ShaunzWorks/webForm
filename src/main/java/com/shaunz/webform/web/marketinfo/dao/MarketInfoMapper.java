package com.shaunz.webform.web.marketinfo.dao;

import java.util.List;

import com.shaunz.webform.web.marketinfo.entity.MarketInfo;

public interface MarketInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(MarketInfo record);

    int insertSelective(MarketInfo record);

    MarketInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MarketInfo record);

    int updateByPrimaryKey(MarketInfo record);
    
    List<MarketInfo> quaryAll();
}