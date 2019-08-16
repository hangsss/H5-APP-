var sip =window.localStorage.getItem("sip")==null?"http://101.91.216.129:9999/cgim/":window.localStorage.getItem("sip");
//39.108.51.82
//var sip ="http://192.168.2.102:8080/cgim/";
var user = eval(window.localStorage.getItem("user"));
var db = openDatabase("user_"+(user==null?"":user.id)+"_db",'1.0','会话聊天记录', 2*1024*1024);

//数据库操作
function saveMsgToLocalDB(message){
	var msgary = [message.mid,message.fromtype,message.fromid,
		message.fromname,message.msgtime,message.targetid,message.targetname,
		message.targettype,message.msgtext,message.msgextras,message.msgtype];
	var tbname;
	if(message.fromid==user.id){
		tbname="log_"+message.targetid;	
	}else{
		if(message.targettype=="1"){
			tbname="log_"+message.fromid;
		}else{
			tbname="log_"+message.targetid;
		}
	}
	db.transaction(function (tx) { 
		tx.executeSql('CREATE TABLE IF NOT EXISTS '+tbname+' (rid int identity(1,1) primary key,mId,fromType,fromId,fromName,creatTime,targetId,targetName,targetType,msgText,msgExtras,msgType)');
		tx.executeSql('INSERT INTO '+tbname+' (mId,fromType,fromId,fromName,creatTime,targetId,targetName,targetType,msgText,msgExtras,msgType) VALUES (?,?,?,?,?,?,?,?,?,?,?)',msgary);
	});
}

//工具方法
function fds(str){
	if (str >= 1 && str <= 9){
			return str = "0" + str;
	}else{
		return str;
	}
}
function fdt(date){
	var d = new Date(Date.parse(date.replace(/-/g,"/")));
	var nd = new Date();
	var dm =fds(d.getMonth()+1);
	var ndm =fds(nd.getMonth()+1);
	var sd ="";
	if(d.getFullYear()==nd.getFullYear()){
		if(dm==ndm){
			if(d.getDate()==nd.getDate()){
				sd=fds(d.getHours())+":"+fds(d.getMinutes());
			}else {
				sd =dm+"-"+fds(d.getDate());
			}
		}else{
			sd =dm+"-"+fds(d.getDate());
		}
	}else{
		sd =d.getFullYear()+"-"+dm+"-"+d.getDate();
	}
	return sd;
}
function getNowFormatDate() {
    var date = new Date();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var currentdate = date.getFullYear() +"-" + fds(month) + "-"  + fds(strDate)+" "+
    		fds(date.getHours())+":"+ fds(date.getMinutes())+":" +fds(date.getSeconds());
    return currentdate;
}
function deltag(str){
	return str.replace(/<[^>]+>/g,"");
}
function pagejump(target){
	if(plus.webview.getWebviewById(target)==null){
		mui.preload({url:target,id:target});
	}
	mui.openWindow({url:target,id:target});
}
function firejump(target,method,data){
	var nextpage = plus.webview.getWebviewById(target);
	if(nextpage==null){
		nextpage =mui.preload({url:target,id:target});
	}
	mui.fire(nextpage,method,data);
	mui.openWindow({url:target,id:target});
}
function firedata(target,method,data){
	var nextpage = plus.webview.getWebviewById(target);
	if(nextpage==null){
		nextpage =mui.preload({url:target,id:target});
	}
	mui.fire(nextpage,method,data);
}
