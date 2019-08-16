package com.wzc.im.dao;

import com.wzc.im.bean.FunDynamic;
import com.wzc.im.bean.FunDynamicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunDynamicMapper {
    int countByExample(FunDynamicExample example);

    int deleteByExample(FunDynamicExample example);

    int deleteByPrimaryKey(String id);

    int insert(FunDynamic record);

    int insertSelective(FunDynamic record);

    List<FunDynamic> selectByExample(FunDynamicExample example);

    FunDynamic selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FunDynamic record, @Param("example") FunDynamicExample example);

    int updateByExample(@Param("record") FunDynamic record, @Param("example") FunDynamicExample example);

    int updateByPrimaryKeySelective(FunDynamic record);

    int updateByPrimaryKey(FunDynamic record);
}