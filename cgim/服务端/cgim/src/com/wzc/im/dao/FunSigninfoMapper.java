package com.wzc.im.dao;

import com.wzc.im.bean.FunSigninfo;
import com.wzc.im.bean.FunSigninfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunSigninfoMapper {
    int countByExample(FunSigninfoExample example);

    int deleteByExample(FunSigninfoExample example);

    int deleteByPrimaryKey(String sid);

    int insert(FunSigninfo record);

    int insertSelective(FunSigninfo record);

    List<FunSigninfo> selectByExample(FunSigninfoExample example);

    FunSigninfo selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") FunSigninfo record, @Param("example") FunSigninfoExample example);

    int updateByExample(@Param("record") FunSigninfo record, @Param("example") FunSigninfoExample example);

    int updateByPrimaryKeySelective(FunSigninfo record);

    int updateByPrimaryKey(FunSigninfo record);
}