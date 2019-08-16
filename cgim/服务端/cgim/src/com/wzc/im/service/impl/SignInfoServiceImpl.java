package com.wzc.im.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzc.im.bean.FunSigninfo;
import com.wzc.im.bean.FunSigninfoExample;
import com.wzc.im.dao.FunSigninfoMapper;
import com.wzc.im.service.ISignInfoService;

@Service
public class SignInfoServiceImpl implements ISignInfoService{

	@Autowired
	private FunSigninfoMapper signinfoMapper;
	
	public boolean insert(FunSigninfo signinfo) {
		return signinfoMapper.insertSelective(signinfo)>0;
	}

	public boolean delete(String id) {
		return signinfoMapper.deleteByPrimaryKey(id)>0;
	}

	public List<FunSigninfo> selectByCreateId(String uid) {
		FunSigninfoExample example = new FunSigninfoExample();
		example.createCriteria().andCreateuseridEqualTo(uid);
		example.setOrderByClause(" createtime desc");
		return signinfoMapper.selectByExample(example);
	}

	public FunSigninfo selectById(String sid) {
		return signinfoMapper.selectByPrimaryKey(sid);
	}

}
