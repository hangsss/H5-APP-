var tid,ttype,tname,pageNumber,addData;
var selfimgsrc,targetimgsrc;
var record = new Array();
var docmsglist = document.getElementById("msg-list");
var docloading = document.getElementById("mloading");
var righticon = document.querySelector(".mui-pull-right");
function initpage(){
	tid =window.localStorage.getItem("chatid");
	tname =window.localStorage.getItem("chatname");
	ttype =window.localStorage.getItem("chattype");
	selfimgsrc = sip+"getuimg.do?uid="+user.id;
	targetimgsrc=sip+"getuimg.do?uid="+tid;
	if(ttype=="2"){
		if(righticon.classList.contains("mui-hidden")){
			righticon.classList.remove("mui-hidden");
		}
	}else{
		if(!righticon.classList.contains("mui-hidden")){
			righticon.classList.add("mui-hidden");
		}
	}
	document.querySelector("#chattitle").innerText=tname;
	docmsglist.innerHTML="";
	pageNumber=0;
	record.splice(0,record.length);
	getchatlog();
}
righticon.addEventListener("tap",function(){
	firejump("groupinfo.html","getidandtype",{id:tid});
});
window.addEventListener('receivemsg',function(event){
		var message =event.detail.message;
		console.info(message.fromname);
		if(message.targettype=="1"&&message.fromid==tid){
			addData(message);
		}else if(message.targettype=="2"&&message.targetid==tid){
			addData(message);
		}else{
			console.info(message.msgtext);
		}
});
docmsglist.addEventListener("swipedown",function(){
	if(docmsglist.scrollTop==0){
		docloading.classList.remove("mui-hidden");
		setTimeout(function(){
			docloading.classList.add("mui-hidden");
		},2000)
//		pageNumber++;
//		getchatlog();
	}
});
function getchatlog(){
	var startindex =pageNumber*20;
	db.transaction(function (tx) {  
		var sql="SELECT * FROM log_"+tid+" order by rid desc LIMIT 20 offset "+startindex;
		tx.executeSql(sql, [], function (tx, results) {
			if(results.rows.length>0){
				for(var i=results.rows.length;i>0;i--){
					var row = results.rows.item(i-1);
				    var str = '{mid:"'+row.mId+'",fromtype:"'+row.fromType+'",fromid:"'+row.fromId+'",fromname:"'+row.fromName+
							'",msgtime:"'+row.creatTime+'",targetid:"'+row.targetId+'",targetname:"'+row.targetName+
							'",targettype:"'+row.targetType+'",msgtext:"'+row.msgText+'",msgextras:"'+row.msgExtras+'",msgtype:"'+row.msgType+'"}';
					addData(eval("("+str+")"));
				}
			}
		}, null);
	});
}

(function($, doc) {
var MIN_SOUND_TIME = 800;
$.init({
	gestureConfig: {
		tap: true, //默认为true
		doubletap: true, //默认为false
		longtap: true, //默认为false
		swipe: true, //默认为true
		drag: true, //默认为true
		hold: true, //默认为false，不监听
		release: true //默认为false，不监听
	},beforeback: function(){
		window.localStorage.removeItem("chatid");
        plus.webview.getWebviewById("sub_message.html").evalJS("getMsgToLocalDB()");
        return true;
  },preloadPages:[{url:"groupinfo.html",id:"groupinfo.html"}]
});
template.config('escape', false);
$.plusReady(function() {
	var selfview = plus.webview.currentWebview();
	selfview.setStyle({softinputMode: "adjustResize"});
	var showKeyboard = function() {
		if ($.os.ios) {
			var webView = plus.webview.currentWebview().nativeInstanceObject();
			webView.plusCallMethod({"setKeyboardDisplayRequiresUserAction": false});
		} else {
			var Context = plus.android.importClass("android.content.Context");
			var InputMethodManager = plus.android.importClass("android.view.inputmethod.InputMethodManager");
			var main = plus.android.runtimeMainActivity();
			var imm = main.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
			imm.showSoftInput(main.getWindow().getDecorView(), InputMethodManager.SHOW_IMPLICIT);
		}
	};
	var ui = {
		body: doc.querySelector('body'),
		footer: doc.querySelector('footer'),
		footerRight: doc.querySelector('.footer-right'),
		footerLeft: doc.querySelector('.footer-left'),
		btnmsgtype: doc.querySelector('#msg-type'),
		boxMsgText: doc.querySelector('#msg-text'),
		boxMsgSound: doc.querySelector('#msg-sound'),
		btnMsgImage: doc.querySelector('#msg-image'),
		areaMsgList: doc.querySelector('#msg-list'),
		boxSoundAlert: doc.querySelector('#sound-alert'),
		h: doc.querySelector('#h'),
		content: doc.querySelector('.mui-content'),
	};
	ui.h.style.width = ui.boxMsgText.offsetWidth + 'px';
	var footerPadding = ui.footer.offsetHeight - ui.boxMsgText.offsetHeight;
	var msgItemTap = function(msgItem, event) {
		var msgtype = msgItem.getAttribute('msg-type');
		var msgContent = msgItem.getAttribute('msg-content')
		if (msgtype == 'sound') {
			player = plus.audio.createPlayer(msgContent);
			var playState = msgItem.querySelector('.play-state');
			playState.innerText = '正在播放...';
			player.play(function() {
				playState.innerText = '点击播放';
			}, function(e) {
				playState.innerText = '点击播放';
			});
		}
	};
	var imageViewer = new $.ImageViewer('.msg-content-image', {dbl: false});
	var bindMsgList = function() {
		ui.areaMsgList.innerHTML = template('msg-template', {"record": record});
		var msgItems = ui.areaMsgList.querySelectorAll('.msg-item');
		[].forEach.call(msgItems, function(item, index) {
			item.addEventListener('tap', function(event) {
				msgItemTap(item, event);
			}, false);
		});
		imageViewer.findAllImage();
		ui.areaMsgList.scrollTop = ui.areaMsgList.scrollHeight + ui.areaMsgList.offsetHeight;
	};
	window.addEventListener('resize', function() {
		ui.areaMsgList.scrollTop = ui.areaMsgList.scrollHeight + ui.areaMsgList.offsetHeight;
	}, false);
	var send = function(msg) {
		record.push(msg);
		bindMsgList();
	};
	function msgTextFocus() {
			ui.boxMsgText.focus();
			setTimeout(function() {
				ui.boxMsgText.focus();
			}, 150);
		}
		//解决长按“发送”按钮，导致键盘关闭的问题；
	ui.footerRight.addEventListener('touchstart', function(event) {
		if (ui.btnmsgtype.classList.contains('mui-icon-paperplane')) {
			msgTextFocus();
			event.preventDefault();
		}
	});
	//解决长按“发送”按钮，导致键盘关闭的问题；
	ui.footerRight.addEventListener('touchmove', function(event) {
		if (ui.btnmsgtype.classList.contains('mui-icon-paperplane')) {
			msgTextFocus();
			event.preventDefault();
		}
	});
	ui.footerRight.addEventListener('release', function(event) {
		if (ui.btnmsgtype.classList.contains('mui-icon-paperplane')) {
			ui.boxMsgText.focus();
			setTimeout(function() {
				ui.boxMsgText.focus();
			}, 150);
			var tt = ui.boxMsgText.value.replace(new RegExp('\n', 'gm'), '<br/>');
			mui.fire(plus.webview.getWebviewById("index.html"),"sendmsg",{tid:tid,tname:tname,ttype:ttype,msgtext:tt,msgextras:"",msgtype:"text"});
			send({
				sendname:user.name,
				sender: 'self',
				type: 'text',
				uimg:selfimgsrc,
				content: tt
			});
			ui.boxMsgText.value = '';
			$.trigger(ui.boxMsgText, 'input', null);
		} else if (ui.btnmsgtype.classList.contains('mui-icon-mic')) {
			ui.btnmsgtype.classList.add('mui-icon-compose');
			ui.btnmsgtype.classList.remove('mui-icon-mic');
			ui.boxMsgText.style.display = 'none';
			ui.boxMsgSound.style.display = 'block';
			ui.boxMsgText.blur();
			document.body.focus();
		} else if (ui.btnmsgtype.classList.contains('mui-icon-compose')) {
			ui.btnmsgtype.classList.add('mui-icon-mic');
			ui.btnmsgtype.classList.remove('mui-icon-compose');
			ui.boxMsgSound.style.display = 'none';
			ui.boxMsgText.style.display = 'block';
			ui.boxMsgText.focus();
			setTimeout(function() {
				ui.boxMsgText.focus();
			}, 150);
		}
	}, false);
	ui.footerLeft.addEventListener('tap', function(event) {
		var btnArray = [{
			title: "拍照"
		}, {
			title: "从相册选择"
		}];
		plus.nativeUI.actionSheet({
			title: "选择照片",
			cancel: "取消",
			buttons: btnArray
		}, function(e) {
			var index = e.index;
			switch (index) {
				case 0:
					break;
				case 1:
					var cmr = plus.camera.getCamera();
					cmr.captureImage(function(path) {
						send({
							sendname:user.name,
							sender: 'self',
							type: 'image',
							uimg:selfimgsrc,
							content: "file://" + plus.io.convertLocalFileSystemURL(path)
						});
						var task = plus.uploader.createUpload(sip+"uploadfile.do",
					    		{method: "POST"},function(t, status) {
						            if (status == 200) { 
						                console.log("上传成功：" + t.responseText);
						                eval("var data="+t.responseText);
						                if(data.result=="OK"){
						                	mui.fire(plus.webview.getWebviewById("index.html"),"sendmsg",{tid:tid,tname:tname,ttype:ttype,msgtext:"[图片]",msgextras:data.path,msgtype:"image"});
						                }else{
						                	mui.toast("发送失败！");
						                }
						                
						            }else{ 
						            	mui.toast("发送失败！");
						                console.log("上传失败：" + status); 
						            } 
					        	} 
					    ); 
					    var keyid = Math.floor(Math.random() * 100000000 + 10000000).toString();
					    var dstname="_downloads/"+keyid+".jpg";
					   	plus.zip.compressImage({
				            src: "file://" + plus.io.convertLocalFileSystemURL(path), 
				            dst: dstname, 
				            overwrite:true, 
				            quality: 20 
				        },function(event) { 
				            console.log("success:"+event.target); 
				            task.addFile(event.target, {key: keyid}); 
					    	task.start();
				        },function(error) { 
				            console.log(error); 
				        });
					}, function(err) {});
					break;
				case 2:
					plus.gallery.pick(function(path) { 
			        	var task = plus.uploader.createUpload(sip+"uploadfile.do",
				    		{method: "POST"},function(t, status) {
					            if (status == 200) { 
					                console.log("上传成功：" + t.responseText);
					                eval("var data="+t.responseText);
					                if(data.result=="OK"){
					                	send({sendname:user.name,sender: 'self',type: 'image',uimg:selfimgsrc,content: path});
					                	mui.fire(plus.webview.getWebviewById("index.html"),"sendmsg",{tid:tid,tname:tname,ttype:ttype,msgtext:"[图片]",msgextras:data.path,msgtype:"image"});
					                }else{
					                	mui.toast("发送失败！");
					                }
					            }else{ 
					            	mui.toast("发送失败！");
					                console.log("上传失败：" + status); 
					            } 
				        	}); 
				        var keyid = Math.floor(Math.random() * 100000000 + 10000000).toString();
				    	var dstname="_downloads/"+keyid+".jpg";
					   	plus.zip.compressImage({
				            src: path, 
				            dst: dstname, 
				            overwrite:true, 
				            quality: 20 
				        },function(event) { 
				            console.log("success:"+event.target); 
				            task.addFile(event.target, {key: keyid}); 
					    	task.start();
				        },function(error) { 
				            console.log(error); 
				        });
    				}, function(e) {},{filter: "image"});
					break;
			}
		});
	}, false); 
	var setSoundAlertVisable=function(show){
		if(show){
			ui.boxSoundAlert.style.display = 'block';
			ui.boxSoundAlert.style.opacity = 1;
		}else{
			ui.boxSoundAlert.style.opacity = 0;
			//fadeOut 完成再真正隐藏
			setTimeout(function(){
				ui.boxSoundAlert.style.display = 'none';
			},200);
		}
	};
	var recordCancel = false;
	var recorder = null;
	var audio_tips = document.getElementById("audio_tips");
	var startTimestamp = null;
	var stopTimestamp = null;
	var stopTimer = null;
	ui.boxMsgSound.addEventListener('hold', function(event) {
		recordCancel = false;
		if(stopTimer)clearTimeout(stopTimer);
		audio_tips.innerHTML = "手指上划，取消发送";
		ui.boxSoundAlert.classList.remove('rprogress-sigh');
		setSoundAlertVisable(true);
		recorder = plus.audio.getRecorder();
		if (recorder == null) {
			plus.nativeUI.toast("不能获取录音对象");
			return;
		}
		startTimestamp = (new Date()).getTime();
		recorder.record({
			filename: "_doc/audio/"
		}, function(path) {
			if (recordCancel) return;
			var task = plus.uploader.createUpload(sip+"uploadfile.do",
		    		{method: "POST"},function(t, status) {
			            if (status == 200) { 
			                console.log("上传成功：" + t.responseText); 
			                eval("var data="+t.responseText);
			                if(data.result=="OK"){
						       	send({
									sendname:user.name,
									sender: 'self',
									type: 'sound',
									uimg:selfimgsrc,
									content: path
								});
						       	mui.fire(plus.webview.getWebviewById("index.html"),"sendmsg",{tid:tid,tname:tname,ttype:ttype,msgtext:"[语音消息]",msgextras:data.path,msgtype:"sound"});
							}else{
								mui.toast("发送失败！");
							}
			            }else{ 
			                console.log("上传失败：" + status); 
			            } 
		        	} 
		    ); 
		    var keyid = Math.floor(Math.random() * 100000000 + 10000000).toString();
		    task.addFile(path, {key: keyid}); 
		    task.start(); 
		}, function(e) {
			plus.nativeUI.toast("录音时出现异常: " + e.message);
		});
	}, false);
	ui.body.addEventListener('drag', function(event) {
		if (Math.abs(event.detail.deltaY) > 50) {
			if (!recordCancel) {
				recordCancel = true;
				if (!audio_tips.classList.contains("cancel")) {
					audio_tips.classList.add("cancel");
				}
				audio_tips.innerHTML = "松开手指，取消发送";
			}
		} else {
			if (recordCancel) {
				recordCancel = false;
				if (audio_tips.classList.contains("cancel")) {
					audio_tips.classList.remove("cancel");
				}
				audio_tips.innerHTML = "手指上划，取消发送";
			}
		}
	}, false);
	ui.boxMsgSound.addEventListener('release', function(event) {
		//console.log('release');
		if (audio_tips.classList.contains("cancel")) {
			audio_tips.classList.remove("cancel");
			audio_tips.innerHTML = "手指上划，取消发送";
		}
		//
		stopTimestamp = (new Date()).getTime();
		if (stopTimestamp - startTimestamp < MIN_SOUND_TIME) {
			audio_tips.innerHTML = "录音时间太短";
			ui.boxSoundAlert.classList.add('rprogress-sigh');
			recordCancel = true;
			stopTimer=setTimeout(function(){
				setSoundAlertVisable(false);
			},800);
		}else{
			setSoundAlertVisable(false);
		}
		recorder.stop();
	}, false);
	ui.boxMsgSound.addEventListener("touchstart", function(e) {
		e.preventDefault();
	});
	ui.boxMsgText.addEventListener('input', function(event) {
		ui.btnmsgtype.classList[ui.boxMsgText.value == '' ? 'remove' : 'add']('mui-icon-paperplane');
		ui.btnmsgtype.setAttribute("for", ui.boxMsgText.value == '' ? '' : 'msg-text');
		ui.h.innerText = ui.boxMsgText.value.replace(new RegExp('\n', 'gm'), '\n-') || '-';
		ui.footer.style.height = (ui.h.offsetHeight + footerPadding) + 'px';
		ui.content.style.paddingBottom = ui.footer.style.height;
	});
	var focus = false;
	ui.boxMsgText.addEventListener('tap', function(event) {
		ui.boxMsgText.focus();
		setTimeout(function() {
			ui.boxMsgText.focus();
		}, 0);
		focus = true;
		setTimeout(function () {
			focus = false;
		},1000);
		event.detail.gesture.preventDefault();
	}, false);
	//点击消息列表，关闭键盘
	ui.areaMsgList.addEventListener('click',function (event) {
			if(!focus){
				ui.boxMsgText.blur();
			}
		})
	//自定义方法
	addData= function(message) {
		var sendid =message.fromid==user.id?"self":"zs";
		var content =message.msgtype=="text"?message.msgtext:sip+message.msgextras
		record.push({
			sendname:message.fromname,
			sender: sendid,
			type: message.msgtype,
			uimg:sip+"getuimg.do?uid="+message.fromid,
			content: content
		});
		bindMsgList();
	}
});
}(mui, document));
