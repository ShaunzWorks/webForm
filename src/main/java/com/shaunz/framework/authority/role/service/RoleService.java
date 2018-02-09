package com.shaunz.framework.authority.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaunz.framework.authority.role.dao.RoleMapper;
import com.shaunz.framework.authority.role.entity.Role;
import com.shaunz.framework.web.base.BaseService;

@Service
public class RoleService extends BaseService{
	
	@Autowired
	RoleMapper roleMapper;
	
	public List<Role> getRolesByUsrId(String usrId) {
		return roleMapper.selectByUserId(usrId);
	}
}
