package com.wzc.im.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzc.im.bean.FunDynamic;
import com.wzc.im.bean.FunDynamicExample;
import com.wzc.im.bean.ImUser;
import com.wzc.im.dao.FunDynamicMapper;
import com.wzc.im.dao.ImUserMapper;
import com.wzc.im.service.IDynamicService;

@Service
public class DynamicServiceImpl implements IDynamicService{

	@Autowired
	private FunDynamicMapper dynamicMapper;
	
	@Autowired
	private ImUserMapper userMapper;
	
	public boolean insert(FunDynamic dynamic) {
		return dynamicMapper.insertSelective(dynamic)>0;
	}

	public boolean delete(String id) {
		return dynamicMapper.deleteByPrimaryKey(id)>0;
	}

	public boolean update(FunDynamic dynamic) {
		return dynamicMapper.updateByPrimaryKeySelective(dynamic)>0;
	}

	public FunDynamic selectById(String id) {
		return dynamicMapper.selectByPrimaryKey(id);
	}

	public List<FunDynamic> selectByUserId(int id) {
		FunDynamicExample example=new FunDynamicExample(); 
		example.createCriteria().andCreateuseridEqualTo(id);
		example.setOrderByClause(" createtime desc");
		return dynamicMapper.selectByExample(example);
	}

	public List<FunDynamic> selectFriendDynamics(int id) {
		FunDynamicExample example=new FunDynamicExample(); 
		example.createCriteria().andCreateuseridEqualTo(id);
		ImUser user = userMapper.selectByPrimaryKey(id);
		String friends =user.getFriends();
		if(friends!=null){
			if(friends.indexOf(",")>-1){
				String[] ids =friends.split(","); 
				for(String uid:ids){
					int intid = Integer.parseInt(uid);
					example.or(example.createCriteria().andCreateuseridEqualTo(intid));  
				}
			}else{
				example.or(example.createCriteria().andCreateuseridEqualTo(Integer.parseInt(friends)));
			}
		}
		example.setOrderByClause(" createtime desc");
		return dynamicMapper.selectByExample(example);
	}

}
