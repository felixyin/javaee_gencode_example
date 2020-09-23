/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdqtrj.com/">前途软件</a> All rights reserved.
 */
package com.qtrj.modules.iim.mapper;

import java.util.List;

import com.qtrj.core.persistence.BaseMapper;
import com.qtrj.core.persistence.annotation.MyBatisMapper;
import com.qtrj.modules.iim.entity.ChatHistory;

/**
 * 聊天记录MAPPER接口
 * @author qtrj
 * @version 2015-12-29
 */
@MyBatisMapper
public interface ChatHistoryMapper extends BaseMapper<ChatHistory> {
	
	
	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<ChatHistory> findLogList(ChatHistory entity);
	

	/**
	 * 查询群组列表数据
	 * @param entity
	 * @return
	 */
	public List<ChatHistory> findGroupLogList(ChatHistory entity);
	
	public int findUnReadCount(ChatHistory chatHistory);
	
}