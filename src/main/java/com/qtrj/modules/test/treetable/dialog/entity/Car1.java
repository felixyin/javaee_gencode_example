/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdqtrj.com/">前途软件</a> All rights reserved.
 */
package com.qtrj.modules.test.treetable.dialog.entity;


import com.qtrj.core.persistence.DataEntity;
import com.qtrj.common.utils.excel.annotation.ExcelField;

/**
 * 车辆Entity
 * @author lgf
 * @version 2018-06-12
 */
public class Car1 extends DataEntity<Car1> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 品牌
	private CarKind1 kind;		// 车系 父类
	
	public Car1() {
		super();
	}

	public Car1(String id){
		super(id);
	}

	public Car1(CarKind1 kind){
		this.kind = kind;
	}

	@ExcelField(title="品牌", align=2, sort=1)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public CarKind1 getKind() {
		return kind;
	}

	public void setKind(CarKind1 kind) {
		this.kind = kind;
	}
	
}