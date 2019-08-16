var sip = "101.91.216.129:9999/mim"
var ws;
$(function() {
    ws = new WebSocket('ws://'+sip+'/wsim.do?id='+aid);
    ws.onmessage = function(evnt) {receivemsg(evnt.data) };
    ws.onopen  = function(evnt){ console.info("鏈嶅姟鍣ㄩ摼鎺ユ垚鍔�.."); };
    ws.onclose = function(evnt){ console.info("鏈嶅姟鍣ㄩ摼鎺ユ柇寮�.."); };
    $("#send").click(function() {
		var msg = $("#msgarea").val();
		var nowtime = getNowFormatDate();
		var message = '<h4><small><a href="">'+aname+'</a> '+nowtime+' 鍙戦�锛�/small></h4><h5>'+msg+'</h5>';
		var smsg= '{"mid":"0","fromtype":"user","fromid":"'+aid+'","fromname":"'+aname+'","msgtime":"'+nowtime+
			'","targetid":"10000","targetname":"鑱婂ぉ娴嬭瘯缁�,"targettype":"2","msgtext":"'+msg+'","msgextras":"","msgtype":"text"}';
   		ws.send(smsg);
		$(".well").append(message);
		$(".well").scrollTop( $(".well")[0].scrollHeight );
		$("#msgarea").val("");
    });
}); 
function receivemsg(msgdata) {
	eval("var msg="+msgdata);
	var message = '<h4><small><a href="">'+msg.fromname+'</a> '+msg.msgtime+' 鍙戦�锛�/small></h4><h5>'+msg.msgtext+'</h5>';
	$(".well").append(message);
	$(".well").scrollTop( $(".well")[0].scrollHeight );
	$("#msgarea").val("");
}
function getNowFormatDate() {
    var date = new Date();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var currentdate = date.getFullYear() +"-" + fds(month) + "-"  + fds(strDate)+" "+
    		fds(date.getHours())+":"+ fds(date.getMinutes())+":" +fds(date.getSeconds());
    return currentdate;
}
function fds(str){
	if (str >= 1 && str <= 9){
		return str = "0" + str;
	}else{
		return str;
	}
}
		