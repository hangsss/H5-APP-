package com.wzc.im.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wzc.im.bean.ImMessage;
import com.wzc.im.bean.ImUser;
import com.wzc.im.dao.ImMessageMapper;
import com.wzc.im.dao.ImUserMapper;
import com.wzc.im.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService{

	@Autowired
	private ImMessageMapper messageMapper;
	
	@Autowired
	private ImUserMapper userMapper;

	public boolean insert(ImMessage message) {
		return messageMapper.insertSelective(message)>0;
	}

	public boolean delete(String id) {
		return messageMapper.deleteByPrimaryKey(id)>0;
	}

	public ImMessage selectById(String id) {
		return messageMapper.selectByPrimaryKey(id);
	}

	public List<ImMessage> selectOfflineLogs(int uid) {
		ImUser user =userMapper.selectByPrimaryKey(uid);
		String logstr = user.getOfflinelogs();
		List<ImMessage> messages = new ArrayList<ImMessage>();
		if(logstr!=null&&!logstr.equals("")){
			if(logstr.indexOf(",")>-1){
				String[] msgids =logstr.split(",");
				for(String msgid:msgids){
					ImMessage message =messageMapper.selectByPrimaryKey(msgid);
					if(message!=null){
						messages.add(message);
					}
				}
			}else{
				ImMessage message =messageMapper.selectByPrimaryKey(logstr);
				if(message!=null){
					messages.add(message);
				}
			}
			user.setOfflinelogs("");
			userMapper.updateByPrimaryKeySelective(user);
		}
		return messages;
	}
}
