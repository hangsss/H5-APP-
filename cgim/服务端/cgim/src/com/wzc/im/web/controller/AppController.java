package com.wzc.im.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wzc.im.bean.FunComment;
import com.wzc.im.bean.FunDynamic;
import com.wzc.im.bean.FunSigninfo;
import com.wzc.im.bean.FunSignlog;
import com.wzc.im.bean.ImGroup;
import com.wzc.im.bean.ImUser;
import com.wzc.im.service.ICommentService;
import com.wzc.im.service.IDynamicService;
import com.wzc.im.service.IGroupService;
import com.wzc.im.service.IMessageService;
import com.wzc.im.service.ISignInfoService;
import com.wzc.im.service.ISignLogService;
import com.wzc.im.service.IUserService;
import com.wzc.im.utils.Imt;

@Controller
public class AppController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IGroupService groupService;
	
	@Autowired
	private IMessageService messageService;
	
	@Autowired
	private IDynamicService dynamicService;
	
	@Autowired
	private ICommentService commentService;
	
	@Autowired
	private ISignInfoService signInfoService;
	
	@Autowired
	private ISignLogService signLogService;
	
	private Gson gson =new Gson();
	
	@RequestMapping(value="/login.do",produces="text/html;charset=UTF-8")
	public @ResponseBody String login(int username,String password){//登录验证服务
		return gson.toJson(userService.login(username,password));
	}
	
	@RequestMapping(value="/getuimg.do",produces="text/html;charset=UTF-8")//获取个人或群组图片
    public void getuimg(@RequestParam Integer uid,HttpServletResponse response,HttpServletRequest request) throws Exception{
		String imgpath ="upload/default.jpg";
		String path="";
		ImUser user = userService.selectById(uid);
		if(user==null){
			ImGroup group = groupService.selectById(uid);
			if(group!=null){
				imgpath = group.getGimg();
			}
		}else{
			imgpath = user.getUimg();
		}
		if(imgpath!=null&&imgpath!=""){
			path= request.getSession().getServletContext().getRealPath("/")+imgpath;
		}else{
			path= request.getSession().getServletContext().getRealPath("/")+"upload/default.jpg";
		}
		byte[] bytes = IOUtils.toByteArray(new FileInputStream(path));
		response.getOutputStream().write(bytes);
    }
	
	@RequestMapping(value="/updateUserInfo.do",produces="text/html;charset=UTF-8")//更新用户信息
	public @ResponseBody String updateUserInfo(ImUser user,String mbirthday){
		if(mbirthday!=null&&mbirthday!=""){
			user.setBirthday(Imt.getCustomDate(mbirthday));
		}
		return userService.update(user)+"";
	}

	@RequestMapping(value="/regist.do",produces="text/html;charset=UTF-8")//注册服务
	public @ResponseBody String regist(ImUser user,String mbirthday){
		if(mbirthday!=null&&mbirthday!=""){
			user.setBirthday(Imt.getCustomDate(mbirthday));
		}
		int id = userService.insert(user);
		return gson.toJson(userService.selectById(id));
	}
	
    @RequestMapping(value="/getAllUsers.do",produces="text/html;charset=UTF-8")//获取所有用户
    public @ResponseBody String getAllUsers(HttpServletResponse response) throws IOException{
        return gson.toJson(userService.selectAll());
    }
    
    @RequestMapping(value="/getMyFriends.do",produces="text/html;charset=UTF-8")//获取所有朋友
    public @ResponseBody String getMyFriends(Integer id, HttpServletResponse response){
    	try {
    		return gson.toJson(userService.selectFriends(id));
		} catch (Exception e) {
			return null;
		}
    }
    
    @RequestMapping(value="/getOfflineMessages.do",produces="text/html;charset=UTF-8")//获取离线信息
    public @ResponseBody String getOfflineMessages(Integer id, HttpServletResponse response) throws IOException{
        return gson.toJson(messageService.selectOfflineLogs(id));
    }
	
	@RequestMapping(value="/getGroup.do",produces="text/html;charset=UTF-8")//查询群组
    public @ResponseBody String getGroup(Integer id,HttpServletResponse response){
        return gson.toJson(groupService.selectById(id));
    }
	@RequestMapping(value="/getUser.do",produces="text/html;charset=UTF-8")//查询用户
    public @ResponseBody String getUser(Integer id,HttpServletResponse response){
        return gson.toJson(userService.selectById(id));
    }
    
    @RequestMapping(value="/myGroups.do",produces="text/html;charset=UTF-8")//我的群组
    public @ResponseBody String myGroups(Integer id,HttpServletResponse response){
        return gson.toJson(groupService.selectByUserId(id));
    }
    
    @RequestMapping(value="/addGroup.do",produces="text/html;charset=UTF-8")//增加群组
    public @ResponseBody String addGroup(ImGroup group){
    	group.setCreatetime(new Date());
    	int gid = groupService.insert(group);
    	if(gid!=0){
    		String members = group.getMembers();
    		if(members.indexOf(",")>-1){
    			String[] userids = members.split(",");
        		for (String uid:userids) {
    				updateUserGroups(uid,gid+"");
    			}
    		}else{
    			updateUserGroups(members,gid+"");
    		}
    		return gid+"";
    	}else{
    		return null;
    	}
    }
    
    public boolean updateUserGroups(String id,String gid){//更新群组用户成员
    	ImUser user =userService.selectById(Integer.parseInt(id));
		user.setGroups(Imt.addArraychild(user.getGroups(), gid));
		return userService.update(user);
    }
    
    
    @RequestMapping(value="/quitGroup.do",produces="text/html;charset=UTF-8")//退出群组
    public @ResponseBody String quitGroup(Integer uid ,Integer gid){
    	ImGroup group = groupService.selectById(gid);
    	String members =Imt.removeArraychild(group.getMembers(), uid+"");
    	group.setMembers(members);
    	ImUser user = userService.selectById(uid);
    	String groups = Imt.removeArraychild(user.getGroups(), gid+"");
    	user.setGroups(groups);
    	boolean res =  groupService.update(group)&&userService.update(user);
    	return res+"";
    }
    
    @RequestMapping(value="/deleteGroup.do",produces="text/html;charset=UTF-8")//删除群组
    public @ResponseBody String deleteGroup(Integer uid ,Integer gid){
    	ImUser user = userService.selectById(uid);
    	String groups = Imt.removeArraychild(user.getGroups(), gid+"");
    	user.setGroups(groups);
    	boolean res =  groupService.delete(gid)&&userService.update(user);
    	return  res+"";
    }
    
    @RequestMapping(value="/uploadfile.do",produces="text/html;charset=UTF-8")//上传文件
	public @ResponseBody String uploadfile(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException, IOException{
    	response.setHeader("Access-Control-Allow-Origin", "*");
		String filepath = request.getSession().getServletContext().getRealPath("/")+"upload/";
		if(!new File(filepath).exists()){ new File(filepath).mkdirs(); }
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("result", "faile");
    	//将请求转换成
        MultipartHttpServletRequest mRequest=(MultipartHttpServletRequest)request;
        Iterator<String> fns=mRequest.getFileNames();//获取上传的文件列表
        while(fns.hasNext()){
            String s =fns.next();
            MultipartFile mFile = mRequest.getFile(s);  
            if(!mFile.isEmpty()){
            	String filename =System.currentTimeMillis()+"_"+mFile.getOriginalFilename();
            	mFile.transferTo(new File(filepath+filename));
            	map.put("result", "OK");//返回结果
            	map.put("path", "upload/"+filename);
            }
        }
        return gson.toJson(map);
	}
    
    @RequestMapping(value="/joinGroup.do",produces="text/html;charset=UTF-8")//加入群组
    public @ResponseBody String joinGroup(String uid,Integer gid,HttpServletResponse response){
        ImGroup group = groupService.selectById(gid);
        String members =Imt.addArraychild(group.getMembers(),uid)  ;
        group.setMembers(members);
        boolean res = groupService.update(group)&&updateUserGroups(uid, gid+"");
        return res+"";
    }
    
    @RequestMapping(value="/addfriend.do",produces="text/html;charset=UTF-8")//添加好友 使得好友双方互相都添加成功
    public @ResponseBody String addfriend(Integer uid,Integer tid,HttpServletResponse response){
    	boolean res = addFriend(uid,tid)&&addFriend(tid, uid);
    	return res+"";
    }
    public boolean addFriend(Integer uid,Integer tid){ 
    	ImUser user = userService.selectById(uid);
        String members =Imt.addArraychild(user.getFriends(),tid+"")  ;
        user.setFriends(members);
    	return userService.update(user);
    }
    @RequestMapping(value="/deletefriend.do",produces="text/html;charset=UTF-8")//删除好友 使得好友双方互相删除
    public @ResponseBody String deletefriend(Integer uid,Integer tid,HttpServletResponse response){
    	boolean res = deleteFriend(uid, tid)&&deleteFriend(tid, uid);
    	return res+"";
    }
    
    public boolean deleteFriend(Integer uid,Integer tid){
    	ImUser user = userService.selectById(uid);
        String members =Imt.removeArraychild(user.getFriends(), tid+"")  ;
        user.setFriends(members);
    	return userService.update(user);
    }
    
    @RequestMapping(value="/publishDynamic.do",produces="text/html;charset=UTF-8")//发布动态
    public @ResponseBody String publishDynamic(FunDynamic dynamic,HttpServletResponse response){
    	dynamic.setCreatetime(new Date());
    	dynamic.setId(Imt.getUUID());
    	return dynamicService.insert(dynamic)+"";
    }
    
    @RequestMapping(value="/deleteDynamic.do",produces="text/html;charset=UTF-8")//响应客户端删除动态操作
    public @ResponseBody String deleteDynamic(String id,HttpServletResponse response){
    	return dynamicService.delete(id)+"";
    }
    
    @RequestMapping(value="/publishComment.do",produces="text/html;charset=UTF-8")//发布评论
    public @ResponseBody String publishComment(FunComment comment,HttpServletResponse response){
    	comment.setCreatetime(new Date());
    	comment.setId(Imt.getUUID());
    	return commentService.insert(comment)+"";
    }
    @RequestMapping(value="/dynamicList.do",produces="text/html;charset=UTF-8")//动态列表
    public @ResponseBody String dynamicList(Integer id,HttpServletResponse response){
    	return gson.toJson(dynamicService.selectFriendDynamics(id));
    }
    
    @RequestMapping(value="/commentList.do",produces="text/html;charset=UTF-8")//评论列表
    public @ResponseBody String commentList(String did,HttpServletResponse response){
    	return gson.toJson(commentService.selectByDynamicId(did));
    }
    @RequestMapping(value="/like.do",produces="text/html;charset=UTF-8")//点赞
    public @ResponseBody String like(String id,String userid,String username,HttpServletResponse response){
    	FunDynamic dynamic = dynamicService.selectById(id);
    	String likeids =Imt.addArraychild(dynamic.getLikeUserids(), userid);
    	String likenames =Imt.addArraychild(dynamic.getLikeNames(), username);
    	System.out.println(likeids+likenames);
    	dynamic.setLikeUserids(likeids);
    	dynamic.setLikeNames(likenames);
    	Map<String,Object> resMap = new HashMap<String, Object>();
    	resMap.put("success", dynamicService.update(dynamic));
    	resMap.put("names", likenames);
    	return gson.toJson(resMap);
    }
    
    @RequestMapping(value="/nolike.do",produces="text/html;charset=UTF-8")//取消点赞
    public @ResponseBody String nolike(String id,String userid,String username,HttpServletResponse response){
    	FunDynamic dynamic = dynamicService.selectById(id);
    	String likeids =Imt.removeArraychild(dynamic.getLikeUserids(), userid);
    	String likenames =Imt.removeArraychild(dynamic.getLikeNames(), username);
    	dynamic.setLikeUserids(likeids);
    	dynamic.setLikeNames(likenames);
    	Map<String,Object> resMap = new HashMap<String, Object>();
    	resMap.put("success", dynamicService.update(dynamic));
    	resMap.put("names", likenames);
    	return gson.toJson(resMap);
    }
    //以下是签到内容
    @RequestMapping(value="/publishSign.do",produces="text/html;charset=UTF-8")
    public @ResponseBody String publishSign(FunSigninfo info,String kaishitime,String jieshutime){
    	info.setStarttime(Imt.getCustomDateM(kaishitime));
    	info.setEndtime(Imt.getCustomDateM(jieshutime));
    	info.setSid(Imt.getUUID());
    	info.setCreatetime(new Date());
    	return signInfoService.insert(info)+"";
    }
    
    @RequestMapping(value="/signcheck.do",produces="text/html;charset=UTF-8")
    public @ResponseBody String signcheck(FunSignlog log,HttpServletResponse response){
    	FunSigninfo info = signInfoService.selectById(log.getSignid());
    	long nowtime =new Date().getTime(); 
    	if(info.getStarttime().getTime()<nowtime&&info.getEndtime().getTime()>nowtime){
    		log.setId(Imt.getUUID());
        	log.setSigntime(new Date());
        	return signLogService.insert(log)+"";
    	}else {
    		return "签到失败，当前不是签到时间";
		}
    }
    
    @RequestMapping(value="/signList.do",produces="text/html;charset=UTF-8")
    public @ResponseBody String signList(String id,HttpServletResponse response){
    	Gson gson2 =new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
    	return gson2.toJson(signInfoService.selectByCreateId(id));
    }
    
    @RequestMapping(value="/signUserList.do",produces="text/html;charset=UTF-8")
    public @ResponseBody String signUserList(String id,HttpServletResponse response){
    	Gson gson2 =new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    	return gson2.toJson(signLogService.selectBySignId(id));
    }
}
//@RequestMapping 是 Spring Web 应用程序中最常被用到的注解之一。这个注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
//@ResponseBody的作用其实是将java对象转为json格式的数据，在以上代码中，将java对象的返回值转换为josn格式
//GSON是Google提供的用来在Java对象和JSON数据之间进行映射的Java类库。可以将一个Json字符转成一个Java对象，或者将一个Java转化为Json字符串。
