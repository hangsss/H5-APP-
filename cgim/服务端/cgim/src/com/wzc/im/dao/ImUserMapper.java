package com.wzc.im.dao;

import com.wzc.im.bean.ImUser;
import com.wzc.im.bean.ImUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImUserMapper {
    int countByExample(ImUserExample example);

    int deleteByExample(ImUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImUser record);

    int insertSelective(ImUser record);
    
    int insertAndGetId(ImUser record);

    List<ImUser> selectByExampleWithBLOBs(ImUserExample example);

    List<ImUser> selectByExample(ImUserExample example);

    ImUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImUser record, @Param("example") ImUserExample example);

    int updateByExampleWithBLOBs(@Param("record") ImUser record, @Param("example") ImUserExample example);

    int updateByExample(@Param("record") ImUser record, @Param("example") ImUserExample example);

    int updateByPrimaryKeySelective(ImUser record);

    int updateByPrimaryKeyWithBLOBs(ImUser record);

    int updateByPrimaryKey(ImUser record);
}
//Mapper.xml映射文件中定义了操作数据库的sql，每个sql是一个statement，映射文件是mybatis的核心。