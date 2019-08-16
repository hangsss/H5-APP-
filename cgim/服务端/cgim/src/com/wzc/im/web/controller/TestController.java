package com.wzc.im.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/user")
public class TestController {

	private Gson gson =new Gson();
	
	@RequestMapping(value="/login.do",produces="text/html;charset=UTF-8")
	public @ResponseBody String login(String loginName,String userPwd,HttpServletResponse response){
		System.out.println(loginName+":"+userPwd);
		Map<String,Object> resMap = new HashMap<String, Object>();
    	resMap.put("success", "登录成功");
    	resMap.put("name", "momo");
    	return gson.toJson(resMap);
	}
}
