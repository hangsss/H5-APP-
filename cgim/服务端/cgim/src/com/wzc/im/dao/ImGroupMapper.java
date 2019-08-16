package com.wzc.im.dao;

import com.wzc.im.bean.ImGroup;
import com.wzc.im.bean.ImGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImGroupMapper {
    int countByExample(ImGroupExample example);

    int deleteByExample(ImGroupExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(ImGroup record);

    int insertSelective(ImGroup record);

    List<ImGroup> selectByExample(ImGroupExample example);

    ImGroup selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") ImGroup record, @Param("example") ImGroupExample example);

    int updateByExample(@Param("record") ImGroup record, @Param("example") ImGroupExample example);

    int updateByPrimaryKeySelective(ImGroup record);

    int updateByPrimaryKey(ImGroup record);
}