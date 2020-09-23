/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdbak.com/">青岛佰安客科技有限公司</a> All rights reserved.
 */
package com.qtrj.modules.test1.mapper;

import com.qtrj.core.persistence.BaseMapper;
import com.qtrj.core.persistence.annotation.MyBatisMapper;
import com.qtrj.modules.test1.entity.Test1;

/**
 * 测试1MAPPER接口
 * @author 尹彬
 * @version 2020-06-21
 */
@MyBatisMapper
public interface Test1Mapper extends BaseMapper<Test1> {
	
}