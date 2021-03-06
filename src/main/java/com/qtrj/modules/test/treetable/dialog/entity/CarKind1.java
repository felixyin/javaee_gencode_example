/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdqtrj.com/">前途软件</a> All rights reserved.
 */
package com.qtrj.modules.test.treetable.dialog.entity;

import java.util.List;
import com.google.common.collect.Lists;

import com.qtrj.core.persistence.TreeEntity;

/**
 * 车系Entity
 * @author lgf
 * @version 2018-06-12
 */
public class CarKind1 extends TreeEntity<CarKind1> {
	
	private static final long serialVersionUID = 1L;
	
	private List<Car1> car1List = Lists.newArrayList();		// 子表列表
	
	public CarKind1() {
		super();
	}

	public CarKind1(String id){
		super(id);
	}

	public  CarKind1 getParent() {
			return parent;
	}
	
	@Override
	public void setParent(CarKind1 parent) {
		this.parent = parent;
		
	}
	
	public List<Car1> getCar1List() {
		return car1List;
	}

	public void setCar1List(List<Car1> car1List) {
		this.car1List = car1List;
	}
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}