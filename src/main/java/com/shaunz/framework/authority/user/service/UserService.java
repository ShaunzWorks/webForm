package com.shaunz.framework.authority.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaunz.framework.authority.user.dao.UserMapper;
import com.shaunz.framework.authority.user.entity.User;
import com.shaunz.framework.common.utils.IStringUtil;
import com.shaunz.framework.web.base.BaseService;

@Service
public class UserService extends BaseService{
	
	@Autowired
	UserMapper userMapper;
	
	public User selectByPrimaryKey(String id){
		return userMapper.selectByPrimaryKey(id);
	}
	
	public User findUserByNm(String usrNm){
		return userMapper.selectByUserNm(usrNm);
	}
	
	public User findUserByEmail(String email){
		return userMapper.selectByEmail(email);
	}
	
	public User findUser(String identifier){
		User user = findUserByNm(identifier);
		if(user== null || IStringUtil.isBlank(user.getId())){
			user = findUserByEmail(identifier);
		}
		return user;
	}
	
	public List<User> queryAll(){
		return userMapper.queryAll();
	}
    
	public List<User> queryLst(User user){
		return userMapper.queryLst(user);
	}
	
	public boolean updateUserByPrimaryKeySelective(User user){
		return userMapper.updateByPrimaryKeySelective(user) == 1;
	}
	
	public boolean addNewUser(User user){
		return userMapper.insertSelective(user) == 1;
	}
	
	public boolean deleteUser(User user){
		return userMapper.deleteByPrimaryKey(IStringUtil.isBlank(user.getId())?"":user.getId()) == 1;
	}
	
	public boolean closeUser(User user){
		user.setCloseFlg("Y");
		return updateUserByPrimaryKeySelective(user);
	}
}
