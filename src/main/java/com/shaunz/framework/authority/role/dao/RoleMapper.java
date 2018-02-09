package com.shaunz.framework.authority.role.dao;

import java.util.List;

import com.shaunz.framework.authority.role.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> selectByUserId(String usrId);
}