package com.wzc.im.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzc.im.bean.ImUser;
import com.wzc.im.bean.ImUserExample;
import com.wzc.im.dao.ImUserMapper;
import com.wzc.im.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{//服务接口

	@Autowired
    private ImUserMapper userMapper;
	
	public ImUser selectByTell(String tell) {
		ImUserExample example =new ImUserExample();
		example.createCriteria().andCellphoneEqualTo(tell);
		return userMapper.selectByExample(example).get(0);
		
	}
    public int insert(ImUser user) {
    	if(userMapper.insertAndGetId(user)>0){
    		return user.getId();
    	}
        return 0;
    }
    public ImUser selectById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}
    public List<ImUser> selectAll() {
		return userMapper.selectByExample(null);
	}
    public boolean update(ImUser user) {
        return userMapper.updateByPrimaryKeySelective(user)>0;
    }
	public ImUser login(int uid, String password) {   //登陆账户密码验证
		ImUserExample example =new ImUserExample();//自定义查询　andIdEqualTo相当于在sql中拼接一个"AND id=uid"
		example.createCriteria().andIdEqualTo(uid).andPasswordEqualTo(password);//mybatis框架的逆向工程的example类示例
		//example.createCriteria().andPasswordEqualTo(password);
		List<ImUser> user =userMapper.selectByExample(example);
		if(user.size()>0){
			return user.get(0);
		}
		return null;
	}
	public boolean delete(int id) { //按照id删除用户
		return userMapper.deleteByPrimaryKey(id)>0;
	}
	public List<ImUser> selectFriends(int id) { //按照id查询指定好友
		ImUser user = userMapper.selectByPrimaryKey(id);
		List<ImUser> users = new ArrayList<ImUser>();
		String friends = user.getFriends();
		if(friends!=null&&friends!=""){
			if(friends.indexOf(",")>-1){
				String[] uids =friends.split(",");
				for(String uid:uids){
					users.add(userMapper.selectByPrimaryKey(Integer.parseInt(uid)));
				}
			}else{
				users.add(userMapper.selectByPrimaryKey(Integer.parseInt(friends)));
			}
		}
		return users;
	}
}
//@Service("userService")注解是告诉Spring，
//当Spring要创建UserServiceImpl的的实例时，
//bean的名字必须叫做"userService"，
//这样当Action需要使用UserServiceImpl的的实例时,
//就可以由Spring创建好的"userService"，
//然后注入给Action：在Action只需要声明一个名字叫“userService”的变量来接收由Spring注入的"userService"即可

/*
 MVC的设计模式。model层就是实体类，对应数据库的表。controller层是Servlet，主要是负责业务模块流程的控制，调用service接口的方法，在struts2就是Action。
 Service层主要做逻辑判断，Dao层是数据访问层，与数据库进行对接。至于这个Mapper是mybtis框架的映射用到,mapper映射文件在dao层用。
 */
//Mapper=DAO 主要是在操作数据库
/*
SSM是sping+springMVC+mysql集成的框架。
MVC即model view controller。
 */
/*
mybatis的一个主要的特点就是需要程序员自己编写sql，那么如果表太多的话，难免会很麻烦，
所以mybatis官方提供了一个逆向工程，可以针对单表自动生成mybatis执行所需要的代码（包括mapper.xml、mapper.Java、po..）。
一般在开发中，常用的逆向工程方式是通过数据库的表生成代码。

MyBatis 是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。
MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。
MyBatis 可以使用简单的 XML 或注解来配置和映射原生信息，将接口和 Java 的 POJOs(Plain Ordinary Java Object,普通的 Java对象)映射成数据库中的记录。
 */
