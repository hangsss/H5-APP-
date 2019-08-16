package com.wzc.im.service;

import java.util.List;

import com.wzc.im.bean.FunComment;

public interface ICommentService {

	public boolean insert(FunComment comment);
	
	public List<FunComment> selectByDynamicId(String did);
	
}
