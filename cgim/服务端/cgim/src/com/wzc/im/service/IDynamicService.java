package com.wzc.im.service;

import java.util.List;

import com.wzc.im.bean.FunDynamic;

public interface IDynamicService {

	public boolean insert(FunDynamic dynamic);
    
    public boolean delete(String id);
    
    public boolean update(FunDynamic dynamic);
    
    public FunDynamic selectById(String id);
    
    public List<FunDynamic> selectByUserId(int id);
    
    public List<FunDynamic> selectFriendDynamics(int id);
}
