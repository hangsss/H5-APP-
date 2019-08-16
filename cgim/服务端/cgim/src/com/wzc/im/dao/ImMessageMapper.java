package com.wzc.im.dao;

import com.wzc.im.bean.ImMessage;
import com.wzc.im.bean.ImMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImMessageMapper {
    int countByExample(ImMessageExample example);

    int deleteByExample(ImMessageExample example);

    int deleteByPrimaryKey(String mid);

    int insert(ImMessage record);

    int insertSelective(ImMessage record);

    List<ImMessage> selectByExample(ImMessageExample example);

    ImMessage selectByPrimaryKey(String mid);

    int updateByExampleSelective(@Param("record") ImMessage record, @Param("example") ImMessageExample example);

    int updateByExample(@Param("record") ImMessage record, @Param("example") ImMessageExample example);

    int updateByPrimaryKeySelective(ImMessage record);

    int updateByPrimaryKey(ImMessage record);
}