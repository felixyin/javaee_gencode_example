/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdqtrj.com/">前途软件</a> All rights reserved.
 */
package com.qtrj.modules.test.manytoone.mapper;

import com.qtrj.core.persistence.BaseMapper;
import com.qtrj.core.persistence.annotation.MyBatisMapper;
import com.qtrj.modules.test.manytoone.entity.Goods;

/**
 * 商品MAPPER接口
 * @author liugf
 * @version 2018-06-12
 */
@MyBatisMapper
public interface GoodsMapper extends BaseMapper<Goods> {
	
}