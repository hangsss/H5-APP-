package com.wzc.im.service;

import java.util.List;

import com.wzc.im.bean.ImMessage;

public interface IMessageService {
	
	public boolean insert(ImMessage message);
	
	public boolean delete(String id);
	
	public ImMessage selectById(String id);
	
	public List<ImMessage> selectOfflineLogs(int uid);

}
