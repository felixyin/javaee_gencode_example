/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdqtrj.com/">前途软件</a> All rights reserved.
 */
package com.qtrj.modules.iim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qtrj.common.utils.StringUtils;
import com.qtrj.core.persistence.Page;
import com.qtrj.core.service.CrudService;
import com.qtrj.modules.iim.entity.Mail;
import com.qtrj.modules.iim.entity.MailBox;
import com.qtrj.modules.iim.entity.MailCompose;
import com.qtrj.modules.iim.mapper.MailBoxMapper;
import com.qtrj.modules.iim.mapper.MailComposeMapper;
import com.qtrj.modules.iim.mapper.MailMapper;

/**
 * 发件箱Service
 * @author qtrj
 * @version 2015-11-15
 */
@Service
@Transactional(readOnly = true)
public class MailService extends CrudService<MailMapper, Mail> {

	@Autowired
	private MailBoxMapper mailBoxMapper;
	@Autowired
	private MailComposeMapper mailComposeMapper;
	
	public Mail get(String id) {
		Mail mail = super.get(id);
		mail.setMailBoxList(mailBoxMapper.findList(new MailBox(mail)));
		mail.setMailComposeList(mailComposeMapper.findList(new MailCompose(mail)));
		return mail;
	}
	
	public List<Mail> findList(Mail mail) {
		return super.findList(mail);
	}
	
	public Page<Mail> findPage(Page<Mail> page, Mail mail) {
		return super.findPage(page, mail);
	}
	
	@Transactional(readOnly = false)
	public void save(Mail mail) {
		super.save(mail);
		for (MailBox mailBox : mail.getMailBoxList()){
			if (mailBox.getId() == null){
				continue;
			}
			if (MailBox.DEL_FLAG_NORMAL.equals(mailBox.getDelFlag())){
				if (StringUtils.isBlank(mailBox.getId())){
					mailBox.setMail(mail);
					mailBox.preInsert();
					mailBoxMapper.insert(mailBox);
				}else{
					mailBox.preUpdate();
					mailBoxMapper.update(mailBox);
				}
			}else{
				mailBoxMapper.delete(mailBox);
			}
		}
		for (MailCompose mailCompose : mail.getMailComposeList()){
			if (mailCompose.getId() == null){
				continue;
			}
			if (MailCompose.DEL_FLAG_NORMAL.equals(mailCompose.getDelFlag())){
				if (StringUtils.isBlank(mailCompose.getId())){
					mailCompose.setMail(mail);
					mailCompose.preInsert();
					mailComposeMapper.insert(mailCompose);
				}else{
					mailCompose.preUpdate();
					mailComposeMapper.update(mailCompose);
				}
			}else{
				mailComposeMapper.delete(mailCompose);
			}
		}
	}
	@Transactional(readOnly = false)
	public void saveOnlyMain(Mail mail) {
		super.save(mail);
		for (MailBox mailBox : mail.getMailBoxList()){
			if (mailBox.getId() == null){
				continue;
			}
			if (MailBox.DEL_FLAG_NORMAL.equals(mailBox.getDelFlag())){
				if (StringUtils.isBlank(mailBox.getId())){
					mailBox.setMail(mail);
					mailBox.preInsert();
					mailBoxMapper.insert(mailBox);
				}else{
					mailBox.preUpdate();
					mailBoxMapper.update(mailBox);
				}
			}else{
				mailBoxMapper.delete(mailBox);
			}
		}
		for (MailCompose mailCompose : mail.getMailComposeList()){
			if (mailCompose.getId() == null){
				continue;
			}
			if (MailCompose.DEL_FLAG_NORMAL.equals(mailCompose.getDelFlag())){
				if (StringUtils.isBlank(mailCompose.getId())){
					mailCompose.setMail(mail);
					mailCompose.preInsert();
					mailComposeMapper.insert(mailCompose);
				}else{
					mailCompose.preUpdate();
					mailComposeMapper.update(mailCompose);
				}
			}else{
				mailComposeMapper.delete(mailCompose);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(Mail mail) {
		super.delete(mail);
		mailBoxMapper.delete(new MailBox(mail));
		mailComposeMapper.delete(new MailCompose(mail));
	}
	
}