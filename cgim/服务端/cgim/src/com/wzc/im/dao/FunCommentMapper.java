package com.wzc.im.dao;

import com.wzc.im.bean.FunComment;
import com.wzc.im.bean.FunCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunCommentMapper {
    int countByExample(FunCommentExample example);

    int deleteByExample(FunCommentExample example);

    int deleteByPrimaryKey(String id);

    int insert(FunComment record);

    int insertSelective(FunComment record);

    List<FunComment> selectByExample(FunCommentExample example);

    FunComment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FunComment record, @Param("example") FunCommentExample example);

    int updateByExample(@Param("record") FunComment record, @Param("example") FunCommentExample example);

    int updateByPrimaryKeySelective(FunComment record);

    int updateByPrimaryKey(FunComment record);
}