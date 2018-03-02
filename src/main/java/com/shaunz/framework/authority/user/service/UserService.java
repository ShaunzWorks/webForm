package com.shaunz.framework.authority.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaunz.framework.authority.user.dao.UserMapper;
import com.shaunz.framework.authority.user.entity.User;
import com.shaunz.framework.web.base.BaseService;

@Service
public class UserService extends BaseService{
	
	@Autowired
	UserMapper userMapper;
	
	public User findUserByNm(String usrNm){
		return userMapper.selectByUserNm(usrNm);
	}
	
	public User findUserByEmail(String email){
		return userMapper.selectByEmail(email);
	}
}