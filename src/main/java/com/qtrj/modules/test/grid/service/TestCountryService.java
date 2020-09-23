/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdqtrj.com/">前途软件</a> All rights reserved.
 */
package com.qtrj.modules.test.grid.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qtrj.core.persistence.Page;
import com.qtrj.core.service.CrudService;
import com.qtrj.modules.test.grid.entity.TestCountry;
import com.qtrj.modules.test.grid.mapper.TestCountryMapper;

/**
 * 国家Service
 * @author lgf
 * @version 2018-04-10
 */
@Service
@Transactional(readOnly = true)
public class TestCountryService extends CrudService<TestCountryMapper, TestCountry> {

	public TestCountry get(String id) {
		return super.get(id);
	}
	
	public List<TestCountry> findList(TestCountry testCountry) {
		return super.findList(testCountry);
	}
	
	public Page<TestCountry> findPage(Page<TestCountry> page, TestCountry testCountry) {
		return super.findPage(page, testCountry);
	}
	
	@Transactional(readOnly = false)
	public void save(TestCountry testCountry) {
		super.save(testCountry);
	}
	
	@Transactional(readOnly = false)
	public void delete(TestCountry testCountry) {
		super.delete(testCountry);
	}
	
}