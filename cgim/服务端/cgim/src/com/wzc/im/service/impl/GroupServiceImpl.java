package com.wzc.im.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wzc.im.bean.ImGroup;
import com.wzc.im.bean.ImGroupExample;
import com.wzc.im.bean.ImGroupExample.Criteria;
import com.wzc.im.bean.ImUser;
import com.wzc.im.dao.ImGroupMapper;
import com.wzc.im.dao.ImUserMapper;
import com.wzc.im.service.IGroupService;

@Service
public class GroupServiceImpl implements IGroupService{

	@Autowired
	private ImGroupMapper groupMapper;
	@Autowired
	private ImUserMapper userMapper;
	
	public ImGroup selectById(int id) {
		return groupMapper.selectByPrimaryKey(id);
	}

	public List<ImGroup> selectByCreateId(int cid) {
		ImGroupExample example = new ImGroupExample();
        Criteria criteria = example.createCriteria();
        criteria.andCreateuseridEqualTo(cid);
		return groupMapper.selectByExample(example);
	}

	public int insert(ImGroup group) {
		if(groupMapper.insertSelective(group)>0){
			return group.getGid();
		}
		return 0;
	}

	public boolean update(ImGroup group) {
		return groupMapper.updateByPrimaryKeySelective(group)>0;
	}

	public boolean delete(int id) {
		return groupMapper.deleteByPrimaryKey(id)>0;
	}

	public List<ImUser> selectGroupUsers(int gid) {
		List<ImUser> members = new ArrayList<ImUser>();
		String memberstr =groupMapper.selectByPrimaryKey(gid).getMembers();
		if(memberstr!=null&&!memberstr.equals("")){
			if(memberstr.indexOf(",")>-1){
				String[] memberids =memberstr.split(",");
				for(String member:memberids){
					int uid = Integer.parseInt(member);
					ImUser user =userMapper.selectByPrimaryKey(uid);
					if(user!=null){
						members.add(user);
					}
				}
			}else{
				int uid = Integer.parseInt(memberstr);
				ImUser user =userMapper.selectByPrimaryKey(uid);
				if(user!=null){
					members.add(user);
				}
			}
			
		}
		return members;
	}

	public List<ImGroup> selectByUserId(int id) {
		List<ImGroup> groups = new ArrayList<ImGroup>();
		String groupstr =userMapper.selectByPrimaryKey(id).getGroups();
		if(groupstr!=null&&!groupstr.equals("")){
			if(groupstr.indexOf(",")>-1){
				String[] groupids =groupstr.split(",");
				for(String groupid:groupids){
					int gid = Integer.parseInt(groupid);
					ImGroup group =groupMapper.selectByPrimaryKey(gid);
					if(group!=null){
						groups.add(group);
					}
				}
			}else{
				int gid = Integer.parseInt(groupstr);
				ImGroup group =groupMapper.selectByPrimaryKey(gid);
				if(group!=null){
					groups.add(group);
				}
			}
			
		}
		return groups;
	}


}
