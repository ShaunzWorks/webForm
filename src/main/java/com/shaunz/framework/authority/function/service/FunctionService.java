package com.shaunz.framework.authority.function.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaunz.framework.authority.function.dao.FunctionMapper;
import com.shaunz.framework.authority.function.entity.Function;
import com.shaunz.framework.common.treemenu.BootStrapTreeViewNode;
import com.shaunz.framework.common.treemenu.TreeMenu;
import com.shaunz.framework.web.base.BaseService;

@Service
public class FunctionService extends BaseService{
	@Autowired
	private FunctionMapper functionMapper;
	
	public List<Function> queryAllFunctions(){
		return functionMapper.queryAll();
	}
	
	public TreeMenu generateMngmtTree(String usrId){
		List<Function> allAuthorizedFunctions = functionMapper.queryAllAuthorizedFunctionByUsrId(usrId);
		List<BootStrapTreeViewNode> treeNodes = TreeMenu.changeFunctionLstToTreeNodes(allAuthorizedFunctions);
		TreeMenu treeMenu = new TreeMenu(treeNodes);
		if(treeMenu.isValidTree()){
			treeMenu.setShowBorder(false);
			treeMenu.setBackColor("#F5F5F5");
			return treeMenu;
		}
		return null;
	}

}
