/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdqtrj.com/">前途软件</a> All rights reserved.
 */
package com.qtrj.modules.test.manytoone.entity;

import javax.validation.constraints.NotNull;

import com.qtrj.core.persistence.DataEntity;
import com.qtrj.common.utils.excel.annotation.ExcelField;

/**
 * 商品Entity
 * @author liugf
 * @version 2018-06-12
 */
public class Goods extends DataEntity<Goods> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 商品名称
	private Category category;		// 所属类型
	private String price;		// 价格
	
	public Goods() {
		super();
	}

	public Goods(String id){
		super(id);
	}

	@ExcelField(title="商品名称", align=2, sort=1)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull(message="所属类型不能为空")
	@ExcelField(title="所属类型", fieldType=Category.class, value="category.name", align=2, sort=2)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@ExcelField(title="价格", align=2, sort=3)
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}