package com.shaunz.framework.common.utils;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class TreeNode implements Serializable {
	private static final long serialVersionUID = 1L;
	private String pid;
	private String id;
	protected String name;
	private String url ;
	protected Object obj;
	protected TreeNode pNode;
	protected List<TreeNode> childList;
	private String loadStyle;
	public TreeNode() {
		initChildList();
	}
	
	public TreeNode(String id,String name,String pid,String url) {
		this.id=id;
		this.name=name;
		this.pid=pid;
		this.url=url;
		initChildList();
	}

	public TreeNode(TreeNode parentNode) {
		this.getPNode();
		initChildList();
	}

	public boolean isLeaf() {
		if (childList == null) {
			return true;
		} else {
			if (childList.isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public void addChildNode(TreeNode node) {
		initChildList();
		if(!childList.contains(node)){
			childList.add(node);
		}
	}

	public void initChildList() {
		if (childList == null)
			childList = new ArrayList<TreeNode>();
	}

	
	@Override
	public boolean equals(Object obj) {
		TreeNode node = (TreeNode) obj ;
		return node.getId().equals(this.getId()) ;
	}

	public boolean isValidTree() {
		return true;
	}
	
	public List<TreeNode> getElders() {
		List<TreeNode> elderList = new ArrayList<TreeNode>();
		TreeNode parentNode = this.getPNode();
		if (parentNode == null) {
			return elderList;
		} else {
			elderList.add(parentNode);
			elderList.addAll(parentNode.getElders());
			return elderList;
		}
	}

	/* 返回当前节点的晚辈集合 */
	public List<TreeNode> getJuniors() {
		List<TreeNode> juniorList = new ArrayList<TreeNode>();
		List<TreeNode> childList = this.getChildList();
		if (childList == null) {
			return juniorList;
		} else {
			int childNumber = childList.size();
			for (int i = 0; i < childNumber; i++) {
				TreeNode junior = childList.get(i);
				juniorList.add(junior);
				juniorList.addAll(junior.getJuniors());
			}
			return juniorList;
		}
	}

	/* 返回当前节点的孩子集合 */
	public List<TreeNode> getChildList() {
		return childList;
	}

	/* 删除节点和它下面的晚辈 */
	public void deleteNode() {
		TreeNode parentNode = this.getPNode();
		String id = this.getId();

		if (parentNode != null) {
			parentNode.deleteChildNode(id);
		}
	}

	/* 删除当前节点的某个子节点 */
	public void deleteChildNode(String childId) {
		List<TreeNode> childList = this.getChildList();
		int childNumber = childList.size();
		for (int i = 0; i < childNumber; i++) {
			TreeNode child = childList.get(i);
			if (child.getId() .equals( childId)) {
				childList.remove(i);
				return;
			}
		}
	}

	/* 动态的插入一个新的节点到当前树中 */
	public boolean insertJuniorNode(TreeNode treeNode) {
		String juniorParentId = treeNode.getPid();
		if (this.pid .equals(juniorParentId)) {
			addChildNode(treeNode);
			return true;
		} else {
			List<TreeNode> childList = this.getChildList();
			int childNumber = childList.size();
			boolean insertFlag;

			for (int i = 0; i < childNumber; i++) {
				TreeNode childNode = childList.get(i);
				insertFlag = childNode.insertJuniorNode(treeNode);
				if (insertFlag == true)
					return true;
			}
			return false;
		}
	}

	/* 找到一颗树中某个节点 */
	public TreeNode findTreeNodeById(String id) {
		if (this.id.equals(id))
			return this;
		if (childList.isEmpty() || childList == null) {
			return null;
		} else {
			int childNumber = childList.size();
			for (int i = 0; i < childNumber; i++) {
				TreeNode child = childList.get(i);
				TreeNode resultNode = child.findTreeNodeById(id);
				if (resultNode != null) {
					return resultNode;
				}
			}
			return null;
		}
	}

	/* 遍历一棵树，层次遍历 */
	public void traverse() {
		if (id ==null || "".equals(id))
			return;
		print(this.id);
		if (childList == null || childList.isEmpty())
			return;
		int childNumber = childList.size();
		for (int i = 0; i < childNumber; i++) {
			TreeNode child = childList.get(i);
			child.traverse();
		}
	}

	public void print(String content) {
		System.out.println(content);
	}

	public void print(int content) {
		System.out.println(String.valueOf(content));
	}

	public void setChildList(List<TreeNode> childList) {
		this.childList = childList;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TreeNode getPNode() {
		return pNode;
	}

	public void setPNode(TreeNode pNode) {
		this.pNode = pNode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLoadStyle() {
		return loadStyle;
	}

	public void setLoadStyle(String loadStyle) {
		this.loadStyle = loadStyle;
	}
	
	
}

