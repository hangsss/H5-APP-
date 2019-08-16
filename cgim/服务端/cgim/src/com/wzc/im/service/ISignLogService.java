package com.wzc.im.service;

import java.util.List;

import com.wzc.im.bean.FunSigninfo;
import com.wzc.im.bean.FunSignlog;

public interface ISignLogService {

	public boolean insert(FunSignlog signlog);
	
	public List<FunSigninfo> selectByUserId(String uid);
	
	public List<FunSignlog> selectBySignId(String sid);
}
