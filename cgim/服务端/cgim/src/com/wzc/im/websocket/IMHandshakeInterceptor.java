package com.wzc.im.websocket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;
public class IMHandshakeInterceptor implements HandshakeInterceptor {
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse serverHttpResponse,
                                   WebSocketHandler webSocketHandler, Map<String, Object> map){
        if (request instanceof ServletServerHttpRequest) {
        	String imkey=request.getURI().getQuery().split("=")[1];
            if(imkey==null){
            	System.out.println("imkey为空");
            	return false;
            }
            map.put("imkey", imkey);
        }
        return true;
    }

    // 初次握手访问后
    public void afterHandshake(ServerHttpRequest serverHttpRequest, 
    		ServerHttpResponse serverHttpResponse,WebSocketHandler webSocketHandler, Exception e) {
    	
    }
}
