/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdqtrj.com/">前途软件</a> All rights reserved.
 */
package com.qtrj.modules.iim.mapper;

import com.qtrj.core.persistence.BaseMapper;
import com.qtrj.core.persistence.annotation.MyBatisMapper;
import com.qtrj.modules.iim.entity.MailCompose;

/**
 * 发件箱MAPPER接口
 * @author qtrj
 * @version 2015-11-15
 */
@MyBatisMapper
public interface MailComposeMapper extends BaseMapper<MailCompose> {
	public int getCount(MailCompose entity);
}