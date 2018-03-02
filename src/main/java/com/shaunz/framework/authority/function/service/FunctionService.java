package com.shaunz.framework.authority.function.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shaunz.framework.authority.function.dao.FunctionMapper;
import com.shaunz.framework.authority.function.entity.Function;
import com.shaunz.framework.common.utils.TreeNode;
import com.shaunz.framework.web.base.BaseService;

@Service
public class FunctionService extends BaseService{
	@Resource
	private FunctionMapper functionMapper;
	
	public List<Function> queryAllFunctions(){
		return functionMapper.queryAll();
	}
	
	public List<TreeNode> queryAllAuthorizedFunctions(String usrId){
		List<Function> allAuthorizedFunctions = functionMapper.queryAll();
		if(allAuthorizedFunctions != null && allAuthorizedFunctions.size() > 0){
			for (int i = 0; i < allAuthorizedFunctions.size(); i++) {
				Function function = allAuthorizedFunctions.get(i);
			}
		}
		return null;
	}

}
