mui.init();
var self;
mui.plusReady(function(){
	getofflinemsgs();
	self = plus.webview.currentWebview();
	self.setStyle({scrollIndicator:'none'});
	self.setPullToRefresh({support: true,style:'circle'}, pulldownRefresh);
});
function pulldownRefresh() {
	setTimeout(function() {
		getofflinemsgs();
		self.endPullToRefresh();
	}, 1500);
}
function getofflinemsgs(){
	mui.post(sip+"getOfflineMessages.do",{id:user.id},function(data){
		if(data!=null&&data!=""&&data!="[]"){
			var logs = eval(data);
			addData(logs[logs.length-1]);
			for(var i=0;i<logs.length;i++){
				var message = logs[i];
				if(message.msgtype=="application"){
					console.info(message.msgtype);
					firedata("newfriend.html","receivemsg",{message:message});
					plus.webview.getWebviewById("index.html").evalJS("showbadge('apply')");
					plus.webview.getWebviewById("sub_contact.html").evalJS("showapply()");
				}else{
					saveMsgToLocalDB(message);
					plus.webview.getWebviewById("index.html").evalJS("showbadge('message')");
				}
			}
		}else{
			getMsgToLocalDB();
			console.info("暂无离线记录");
		}
	});
}
function getMsgToLocalDB(){
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
function getlastlog(tablename){
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
function delchatlog(id){
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
window.addEventListener('receivemsg',function(event){
	var msg =event.detail.message;
	addData(msg);
});
function addData(message) {
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
			table.insertBefore(li, table.firstChild);
		}
	}
}
function tochat(id,type,name){
	window.localStorage.setItem("chatid",id);
	window.localStorage.setItem("chattype",type);
	window.localStorage.setItem("chatname",name);
	plus.webview.getWebviewById("chatpage.html").evalJS("initpage()");
	mui.openWindow({url:'chatpage.html',id:'chatpage.html'});
	plus.webview.getWebviewById("index.html").evalJS("removebadge('message')");
}
document.getElementById("msgtips").addEventListener("DOMSubtreeModified",function(){
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