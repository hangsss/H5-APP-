package com.wzc.im.websocket;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wzc.im.bean.ImMessage;
import com.wzc.im.bean.ImUser;
import com.wzc.im.service.IGroupService;
import com.wzc.im.service.IMessageService;
import com.wzc.im.service.IUserService;
import com.wzc.im.utils.Imt;

public class IMWebSocketHander implements WebSocketHandler {
    private Logger logger = Logger.getLogger(IMWebSocketHander.class);
    private Map<String, WebSocketSession> socketsessions = new HashMap<String, WebSocketSession>();
    private Gson gson =new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    @Autowired
    private IGroupService groupService;
    
    @Autowired
    private IUserService userService;
    
    @Autowired
    private IMessageService messageService;
    // 初次链接成功执行
    public void afterConnectionEstablished(WebSocketSession session ) throws Exception {
        String imkey = (String) session.getAttributes().get("imkey");
        if(socketsessions.containsKey(imkey)){
        	socketsessions.get(imkey).close();
        }
        socketsessions.put(imkey,session);	
        logger.info("链接成功，当前在线人数："+socketsessions.size());	
    }
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if (webSocketSession.isOpen()) {
            webSocketSession.close();
        }
        socketsessions.remove((String) webSocketSession.getAttributes().get("imkey"));
        logger.info("链接出错，当前在线人数："+socketsessions.size());
    }

    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
    	socketsessions.remove((String) webSocketSession.getAttributes().get("imkey"));
    	logger.info("链接关闭，当前在线人数："+socketsessions.size());
        
    }

    public boolean supportsPartialMessages() { return false;}
   
    // 接受消息处理消息
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage)throws Exception {
    	ImMessage message = gson.fromJson((String) webSocketMessage.getPayload(), ImMessage.class);
    	message.setMid(Imt.getUUID());
    	if(messageService.insert(message)){
    		if(message.getTargettype().equals("1")){//单聊
        		sendMessageToUser(message,message.getTargetid()+"");
        	}else if(message.getTargettype().equals("2")){//群聊
        		sendMessageToGroup(message);
        	}else if(message.getTargettype().equals("3")){//所有在线人
        		sendMessageToAll(message,webSocketSession);
        	}
    	}
    }
    /**
     * 给所有在线人员发消息（通知）
     * @param message
     * @param activeSession
     */
    public void sendMessageToAll(ImMessage msg,WebSocketSession activeSession) {
        for (WebSocketSession user : socketsessions.values()) {
    		try {
                if (user!=activeSession&&user.isOpen()) {
                    user.sendMessage(new TextMessage(gson.toJson(msg)));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 给指定用户发消息（单聊）
     */
    public void sendMessageToUser(ImMessage msg,String tid) {
    	if(socketsessions.containsKey(tid)&&socketsessions.get(tid).isOpen()){//若要发送的对应用户在线，则直接发送信息
    		try {
				socketsessions.get(tid).sendMessage(new TextMessage(gson.toJson(msg)));
			} catch (IOException e) {
				System.out.println("消息发送失败"+e);
			}
    	}else{//若不在线则设置于数据库的离线消息中
    		int uid = Integer.parseInt(tid);
    		ImUser user =userService.selectById(uid);
    		String idstr =user.getOfflinelogs();
    		if(idstr!=null&&!idstr.equals("")){
    			user.setOfflinelogs(idstr+","+msg.getMid());
    		}else{
    			user.setOfflinelogs(msg.getMid());
    		}
    		userService.update(user);
    	}
    }
    /**
     * 给指定群组用户发消息（群聊）
     */
    public void sendMessageToGroup(ImMessage msg){
    	String str =groupService.selectById(msg.getTargetid()).getMembers();
    	str = Imt.removeArraychild(str, msg.getFromid()+"");
    	if(str.indexOf(",")>-1){
    		String[] tids =str.split(",");
        	for(String tid:tids){
    			System.out.println(tid+"=="+msg.getFromid());
    			sendMessageToUser(msg,tid);//循环向群组里的用户发送单聊消息
        	}
    	}
    }
}