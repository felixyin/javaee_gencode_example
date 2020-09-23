/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdbak.com/">青岛佰安客科技有限公司</a> All rights reserved.
 */
package com.qtrj.modules.test1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qtrj.core.persistence.Page;
import com.qtrj.core.service.CrudService;
import com.qtrj.modules.test1.entity.Test1;
import com.qtrj.modules.test1.mapper.Test1Mapper;

/**
 * 测试1Service
 * @author 尹彬
 * @version 2020-06-21
 */
@Service
@Transactional(readOnly = true)
public class Test1Service extends CrudService<Test1Mapper, Test1> {

	public Test1 get(String id) {
		return super.get(id);
	}
	
	public List<Test1> findList(Test1 test1) {
		return super.findList(test1);
	}
	
	public Page<Test1> findPage(Page<Test1> page, Test1 test1) {
		return super.findPage(page, test1);
	}
	
	@Transactional(readOnly = false)
	public void save(Test1 test1) {
		super.save(test1);
	}
	
	@Transactional(readOnly = false)
	public void delete(Test1 test1) {
		super.delete(test1);
	}
	
}