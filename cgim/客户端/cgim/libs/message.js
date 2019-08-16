mui.init();
var self;
mui.plusReady(function(){
	getofflinemsgs();
	self = plus.webview.currentWebview();
	self.setStyle({scrollIndicator:'none'});
	self.setPullToRefresh({support: true,style:'circle'}, pulldownRefresh);
});
function pulldownRefresh() {//下拉刷新
	setTimeout(function() {
		getofflinemsgs();
		self.endPullToRefresh();
	}, 1500);
}
function getofflinemsgs(){//获取离线信息
	mui.post(sip+"getOfflineMessages.do",{id:user.id},function(data){
		if(data!=null&&data!=""&&data!="[]"){
			var logs = eval(data);
			addData(logs[logs.length-1]);
			for(var i=0;i<logs.length;i++){
				var message = logs[i];
				if(message.msgtype=="application"){
					console.info(message.msgtype);
					firedata("newfriend.html","receivemsg",{message:message});//向新的朋友页面传递参数
					plus.webview.getWebviewById("index.html").evalJS("showbadge('apply')");//使用evalJS进行页面传参
					plus.webview.getWebviewById("sub_contact.html").evalJS("showapply()");
					saveMsgToLocalDB(message);
					plus.webview.getWebviewById("index.html").evalJS("showbadge('message')");//显示小红点
				}
			}
		}else{
			getMsgToLocalDB();
			console.info("暂无离线记录");
		}
	});
}
function getMsgToLocalDB(){//查询历史聊天记录（在本机的sqlite数据库中查询）
	db.transaction(function (tx) {  
		var sql="SELECT name FROM sqlite_master WHERE type='table'";
		tx.executeSql(sql, [], function (tx, results) {
		    var len = results.rows.length, i;
		    for (i = 1; i < len; i++){
		    	if(results.rows.item(i).name.indexOf("log_")>-1){
		    		getlastlog(results.rows.item(i).name); 
		    	}
		    }
		}, null);
	});
}
function getlastlog(tablename){//获取第一条对话条目
	db.transaction(function (tx) {  
		var sql="SELECT * FROM "+tablename+" order by rid desc LIMIT 1";
		tx.executeSql(sql, [], function (tx, results) {
		    var row = results.rows.item(0);
		    var str = '{mid:"'+row.mId+'",fromtype:"'+row.fromType+'",fromid:"'+row.fromId+'",fromname:"'+row.fromName+
						'",msgtime:"'+row.creatTime+'",targetid:"'+row.targetId+'",targetname:"'+row.targetName+
						'",targettype:"'+row.targetType+'",msgtext:"'+row.msgText+'",msgextras:"'+row.msgExtras+'",msgtype:"'+row.msgType+'"}';
			addData(eval("("+str+")"));
		}, null);
	});
}
function delchatlog(id){//删除聊天目标条目
	var tname = "log_"+id;
	db.transaction(function (tx) {  
		tx.executeSql('DROP TABLE '+tname);
	});
	var msglist = document.getElementById("msgtips");
	var child = document.getElementById("traget-"+id);
	if(child!=null){
		msglist.removeChild(child);
	}
}
window.addEventListener('receivemsg',function(event){//收到新消息后即添加对话条目 接收消息的函数实现位于index.js中
	var msg =event.detail.message;
	addData(msg);
});
function addData(message) {//增加聊天目标条目
	if(message.msgtype!="application"){
		var table = document.getElementById("msgtips");
		var tid = message.targettype==2?message.targetid:message.fromid;
		var tname=message.targettype==2?message.targetname:message.fromname;
		var msgtxt = message.targettype==2?message.fromname+": "+message.msgtext:message.msgtext;
		var stime = fdt(message.msgtime); 
		if(message.targettype==1&&message.fromid==user.id){
			tid = message.targetid;
			tname=message.targetname;
		}
		var values ="'"+tid+"',"+message.targettype+",'"+tname+"'";
		var html ='<div class="mui-slider-right mui-disabled"><a class="mui-btn mui-btn-red" onclick="delchatlog('+tid+')">删除</a></div>'+ 
					'<div class="mui-slider-handle" onclick="tochat('+values+')" ><a href="javascript:void(0)" style="color:#000000;"><img class="mui-media-object mui-pull-left" src="'+sip+'getuimg.do?uid='+tid+'">'+
					'<div class="mui-media-body"><div class="bodytop">'+tname+'<span class="mtime">'+stime+'</span></div><div class="bodybot">'+
					'<p class="mui-ellipsis">'+msgtxt+'</p><span class="mui-badge mui-badge-danger mui-hidden">1</span></div></div></a></div>';
		var mli = document.getElementById("traget-"+tid);
		if(mli!=null){
			mli.innerHTML = html;
		}else{
			var li = document.createElement('li');
			li.id="traget-"+tid;
			li.className = 'mui-table-view-cell mui-media';
			li.innerHTML = html;
			table.insertBefore(li, table.firstChild);//每次新增的聊天对话条目都加在第一个
		}
	}
}
function tochat(id,type,name){//进入聊天页面
	window.localStorage.setItem("chatid",id);
	window.localStorage.setItem("chattype",type);//聊天类型，以区分群聊与单聊
	window.localStorage.setItem("chatname",name);
	plus.webview.getWebviewById("chatpage.html").evalJS("initpage()");
	mui.openWindow({url:'chatpage.html',id:'chatpage.html'});
	plus.webview.getWebviewById("index.html").evalJS("removebadge('message')");//移除小红点
}
document.getElementById("msgtips").addEventListener("DOMSubtreeModified",function(){//如果当前页面没有对话条目，则显示“暂无聊天信息”的nullmsg，否则则将该图片隐藏
	var html =this.innerHTML;
	var nullmsg =document.getElementById("nullmsg")
	if(html==null||html==""){
		if(nullmsg.classList.contains("mui-hidden")){
			nullmsg.classList.remove("mui-hidden")
		}
	}else{
		if(!nullmsg.classList.contains("mui-hidden")){
			nullmsg.classList.add("mui-hidden")
		}
	}
})
//innerHTML在JS是双向功能：获取对象的内容  或  向对象插入内容