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
	
	public List<Role> queryList(Role role){
		return roleMapper.queryList(role);
	}
	
	public Role selectByPrimaryKey(String id){
		return roleMapper.selectByPrimaryKey(id);
	}
	
	public boolean insertSelective(Role record){
		return roleMapper.insertSelective(record) == 1;
	}
	
	public boolean updateByPrimaryKeySelective(Role record){
		return roleMapper.updateByPrimaryKeySelective(record) == 1;
	}
	
	public boolean deleteByPrimaryKey(String id){
		return roleMapper.deleteByPrimaryKey(id) == 1;
	}
	
	public boolean closeRole(Role role){
		role.setCloseFlg("Y");
		return updateByPrimaryKeySelective(role);
	}
}
