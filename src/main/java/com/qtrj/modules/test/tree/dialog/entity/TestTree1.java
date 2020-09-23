/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdqtrj.com/">前途软件</a> All rights reserved.
 */
package com.qtrj.modules.test.tree.dialog.entity;

import com.qtrj.core.persistence.TreeEntity;

/**
 * 组织机构Entity
 * @author liugf
 * @version 2018-06-12
 */
public class TestTree1 extends TreeEntity<TestTree1> {
	
	private static final long serialVersionUID = 1L;
	
	
	public TestTree1() {
		super();
	}

	public TestTree1(String id){
		super(id);
	}

	public  TestTree1 getParent() {
			return parent;
	}
	
	@Override
	public void setParent(TestTree1 parent) {
		this.parent = parent;
		
	}
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}