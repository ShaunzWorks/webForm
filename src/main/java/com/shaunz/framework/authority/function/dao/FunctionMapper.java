package com.shaunz.framework.authority.function.dao;

import java.util.List;

import com.shaunz.framework.authority.function.entity.Function;

public interface FunctionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);
    
    List<Function> queryAll();
}