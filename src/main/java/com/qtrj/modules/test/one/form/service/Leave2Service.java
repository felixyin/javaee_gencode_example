/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdqtrj.com/">前途软件</a> All rights reserved.
 */
package com.qtrj.modules.test.one.form.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qtrj.core.persistence.Page;
import com.qtrj.core.service.CrudService;
import com.qtrj.modules.test.one.form.entity.Leave2;
import com.qtrj.modules.test.one.form.mapper.Leave2Mapper;

/**
 * 请假表单Service
 * @author lgf
 * @version 2018-06-12
 */
@Service
@Transactional(readOnly = true)
public class Leave2Service extends CrudService<Leave2Mapper, Leave2> {

	public Leave2 get(String id) {
		return super.get(id);
	}
	
	public List<Leave2> findList(Leave2 leave2) {
		return super.findList(leave2);
	}
	
	public Page<Leave2> findPage(Page<Leave2> page, Leave2 leave2) {
		return super.findPage(page, leave2);
	}
	
	@Transactional(readOnly = false)
	public void save(Leave2 leave2) {
		super.save(leave2);
	}
	
	@Transactional(readOnly = false)
	public void delete(Leave2 leave2) {
		super.delete(leave2);
	}
	
}