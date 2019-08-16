package com.wzc.im.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzc.im.bean.FunComment;
import com.wzc.im.bean.FunCommentExample;
import com.wzc.im.dao.FunCommentMapper;
import com.wzc.im.service.ICommentService;
@Service
public class CommentServiceImpl implements ICommentService{

	@Autowired
	private FunCommentMapper commentMapper;
	
	
	public boolean insert(FunComment comment) {
		return commentMapper.insertSelective(comment)>0;
	}

	public List<FunComment> selectByDynamicId(String did) {
		FunCommentExample example = new FunCommentExample();
		example.createCriteria().andDynamicidEqualTo(did);
		example.setOrderByClause(" createtime asc");
		return commentMapper.selectByExample(example);
	}

}
