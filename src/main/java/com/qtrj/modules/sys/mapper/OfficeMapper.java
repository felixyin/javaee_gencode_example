/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdqtrj.com/">前途软件</a> All rights reserved.
 */
package com.qtrj.modules.sys.mapper;

import com.qtrj.core.persistence.TreeMapper;
import com.qtrj.core.persistence.annotation.MyBatisMapper;
import com.qtrj.modules.sys.entity.Office;

/**
 * 机构MAPPER接口
 * @author qtrj
 * @version 2017-05-16
 */
@MyBatisMapper
public interface OfficeMapper extends TreeMapper<Office> {
	
	public Office getByCode(String code);
}
