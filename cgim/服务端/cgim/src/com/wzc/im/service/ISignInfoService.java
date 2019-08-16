package com.wzc.im.service;

import java.util.List;

import com.wzc.im.bean.FunSigninfo;

public interface ISignInfoService {

	public boolean insert(FunSigninfo signinfo);
	
	public boolean delete(String id);
	
	public FunSigninfo selectById(String sid);
	
	public List<FunSigninfo> selectByCreateId(String uid);
}
