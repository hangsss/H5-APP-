mui.init({
	preloadPages:[
		{url:"chatpage.html",id:"chatpage.html"},
		{url:"profile.html",id:"profile.html"},
		{url:"search.html",id:"search.html"}
	]
});
var ws;
var subpages = ['sub_message.html','sub_contact.html','sub_discover.html','sub_personal.html'];
var subpage_style = {top: '45px',bottom: '51px'};
mui.plusReady(function() {
	openWebSocket();//开启通讯
	plus.navigator.setStatusBarBackground("#2c2c2c");//底部导航栏建立
	for (var i=0;i<subpages.length;i++) {
		var sub = plus.webview.create(subpages[i], subpages[i], subpage_style);
		if (i>0) {sub.hide();}plus.webview.currentWebview().append(sub);
	}
});
var activeTab = subpages[0];
mui('.mui-bar-tab').on('tap', 'a', function(e) {
	var targetTab = this.getAttribute('href');
	var title = document.getElementById("title");
	if (targetTab != activeTab) {
		title.innerHTML = this.querySelector('.mui-tab-label').innerHTML;
		plus.webview.show(targetTab);
		plus.webview.hide(activeTab);
		activeTab = targetTab;
	}
});

mui('.mui-bar-nav').on('tap', '.mui-pull-right', function(e) {
	var target = this.getAttribute("href");
	var vNextPage= mui.preload({url:target,id:target});
	mui.openWindow({url:target,id:target,show:{aniShow:"fade-in"}});
});


//通讯方法
var wsurl='ws://'+sip.substring(7,sip.length)+'/wsim.do?id='+user.id;
function openWebSocket(){//连接服务器
	ws = new WebSocket(wsurl);
	ws.onmessage = function(evnt) {receivemsg(evnt.data);};//接收消息
	ws.onopen  = function(evnt){console.info("服务器连接成功") };
	ws.onclose = function(evnt){ mui.toast("服务器连接断开，正在重连...");ws=null;reconnection();}
	ws.onerror = function(evnt){ mui.toast("服务器连接出错，正在重连...");ws=null;reconnection();}
}
function reconnection(){//重连函数
	setTimeout(function(){
		if(ws==null){
			mui.toast("正在重连...");
			ws = new WebSocket(wsurl);
			reconnection();
		}else{
			mui.toast("服务器重连成功");
			plus.webview.getWebviewById("sub_message.html").evalJS("getofflinemsgs()");
		}
	},15000);
}
window.addEventListener('sendmsg',function(event){//发送按钮响应监听-使用到了发送方法-被chatpage.js中多次调用
		var tid=event.detail.tid;
		var tname = event.detail.tname;
		var ttype = event.detail.ttype;
		var msgtext = event.detail.msgtext;
		var msgtype = event.detail.msgtype;
		var msgextras = event.detail.msgextras;
		var smsg= '{"mid":"0","fromtype":"user","fromid":"'+user.id+'","fromname":"'+user.name+
			'","msgtime":"'+getNowFormatDate()+'","targetid":"'+tid+'","targetname":"'+tname+
			'","targettype":"'+ttype+'","msgtext":"'+msgtext+'","msgextras":"'+msgextras+'","msgtype":"'+msgtype+'"}';
		ws.send(smsg);//发送信息
		if(msgtype!="application"){
			saveMsgToLocalDB(eval("("+smsg+")"));
		}
		
});
function receivemsg(message){//接收消息实现函数
	eval("var msg="+message);
	console.info(msg.msgtype);
	if(msg.msgtype=="application"){//如果是好友请求的消息则发送信息于新的朋友页面
		firedata("newfriend.html","receivemsg",{message:msg});
		showbadge("apply");
		plus.webview.getWebviewById("sub_contact.html").evalJS("showapply()");
	}else{//否则发送信息于聊天页面
		saveMsgToLocalDB(msg);
		var chatid= window.localStorage.getItem("chatid");
		if(chatid!=null){
			firedata("chatpage.html","receivemsg",{message:msg});
			if(msg.fromid!=chatid&&msg.targetid!=chatid){
				showbadge("message");//在聊天处显示小红点	
			}
		}else{
			firedata("sub_message.html","receivemsg",{message:msg});
			showbadge("message");//在聊天处显示小红点
		}
	}
}
function showbadge(obj){//显示小红点
	var msgspan;
	if(obj=="message"){
		msgspan =  document.querySelector(".icon-duihuaxinxitianchong");
	}else{
		msgspan =  document.querySelector(".icon-tongxunlutianchong");
	}
	var badge =msgspan.querySelector(".mui-badge");
	if(badge.classList.contains("mui-hidden")){
		badge.classList.remove("mui-hidden");
	}
	if(badge.innerHTML==""){
		badge.innerHTML="1";
	}else{
		badge.innerHTML=parseInt(badge.innerHTML)+1;//增加小红点新消息的数字
	}
}
function removebadge(obj){//移除小红点
	var msgspan;
	if(obj=="message"){
		msgspan =  document.querySelector(".icon-duihuaxinxitianchong");
	}else{
		msgspan =  document.querySelector(".icon-tongxunlutianchong");
	}
	var badge =msgspan.querySelector(".mui-badge");
	if(!badge.classList.contains("mui-hidden")){
		badge.innerHTML=0;
		badge.classList.add("mui-hidden");
	}
}

//再按一次退出应用
var first = null;
mui.back=function(){
	if(!first){
	    first = new Date().getTime();
	    mui.toast('再按一次退出应用');
	    setTimeout(function(){first = null;},1000);
    }else{
        if(new Date().getTime()-first<1000){
        	plus.storage.clear();
            plus.runtime.quit();
    	}
	}
};
