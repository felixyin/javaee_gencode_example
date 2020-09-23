/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdqtrj.com/">前途软件</a> All rights reserved.
 */
package com.qtrj.modules.iim.service;

import java.util.List;

import com.qtrj.modules.iim.entity.ChatPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qtrj.core.service.CrudService;
import com.qtrj.modules.iim.entity.ChatHistory;
import com.qtrj.modules.iim.mapper.ChatHistoryMapper;

/**
 * 聊天记录Service
 * @author qtrj
 * @version 2015-12-29
 */
@Service
@Transactional(readOnly = true)
public class ChatHistoryService extends CrudService<ChatHistoryMapper, ChatHistory> {

	public ChatHistory get(String id) {
		return super.get(id);
	}
	
	public List<ChatHistory> findList(ChatHistory chatHistory) {
			return mapper.findList(chatHistory);
	}
	
	
	public ChatPage<ChatHistory> findPage(ChatPage<ChatHistory> page, ChatHistory entity) {
		entity.setPage(page);
		page.setList(mapper.findLogList(entity));
		return page;
	}
	
	public ChatPage<ChatHistory> findGroupPage(ChatPage<ChatHistory> page, ChatHistory entity) {
		entity.setPage(page);
		page.setList(mapper.findGroupLogList(entity));
		return page;
	}
	
	@Transactional(readOnly = false)
	public void save(ChatHistory chatHistory) {
		super.save(chatHistory);
	}
	
	@Transactional(readOnly = false)
	public void delete(ChatHistory chatHistory) {
		super.delete(chatHistory);
	}
	
	public int findUnReadCount(ChatHistory chatHistory){
		return mapper.findUnReadCount(chatHistory);
	}
	
}