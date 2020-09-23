/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdbak.com/">青岛佰安客科技有限公司</a> All rights reserved.
 */
package com.qtrj.modules.test1.entity;


import com.qtrj.core.persistence.DataEntity;
import com.qtrj.common.utils.excel.annotation.ExcelField;

/**
 * 测试1Entity
 * @author 尹彬
 * @version 2020-06-21
 */
public class Test1 extends DataEntity<Test1> {
	
	private static final long serialVersionUID = 1L;
	
	public Test1() {
		super();
	}

	public Test1(String id){
		super(id);
	}

}