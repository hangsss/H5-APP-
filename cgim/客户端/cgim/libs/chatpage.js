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
	selfimgsrc = sip+"getuimg.do?uid="+user.id;//获取本用户头像
	targetimgsrc=sip+"getuimg.do?uid="+tid;//获取目标用户头像
	if(ttype=="2"){//如果是群组聊天，则移除群组按钮隐藏 mui-hidden即默认设为隐藏
		if(righticon.classList.contains("mui-hidden")){
			righticon.classList.remove("mui-hidden");
		}
	}else{//如果是一对一聊天，则加上群组按钮隐藏
		if(!righticon.classList.contains("mui-hidden")){
			righticon.classList.add("mui-hidden");
		}
	}
	document.querySelector("#chattitle").innerText=tname;//将聊天目标显示于对话框标题
	docmsglist.innerHTML="";
	pageNumber=0;
	record.splice(0,record.length);
	getchatlog();//从本地数据库获取历史聊天记录
}
righticon.addEventListener("tap",function(){//群组按钮的响应事件
	firejump("groupinfo.html","getidandtype",{id:tid});
});
window.addEventListener('receivemsg',function(event){//接收消息
		var message =event.detail.message;
		console.info(message.fromname);
		if(message.targettype=="1"&&message.fromid==tid){//一对一聊天
			addData(message);
		}else if(message.targettype=="2"&&message.targetid==tid){//群组聊天
			addData(message);
		}else{
			console.info(message.msgtext);
		}
});
docmsglist.addEventListener("swipedown",function(){//下滑
	if(docmsglist.scrollTop==0){
		docloading.classList.remove("mui-hidden");//移除loading.gif效果
		setTimeout(function(){//两秒定时
			docloading.classList.add("mui-hidden");
		},2000)
//		pageNumber++;
//		getchatlog();
	}
});
function getchatlog(){//从本地数据库获取历史聊天记录
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
					addData(eval("("+str+")"));//从本地数据库中获取历史信息后在界面中循环加入消息条目
				}
			}
		}, null);
	});
}

(function($, doc) {
var MIN_SOUND_TIME = 800;//定义了录音的最短录制时间，在此代码文件的底部有所调用
$.init({
	gestureConfig: {//此处为mui手势事件
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
  },preloadPages:[{url:"groupinfo.html",id:"groupinfo.html"}]//预加载群组信息界面
});
template.config('escape', false);
$.plusReady(function() {
	var selfview = plus.webview.currentWebview();
	selfview.setStyle({softinputMode: "adjustResize"});
	var showKeyboard = function() {//虚拟键盘方法，弹出软键盘
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
	//msg-type是消息类型（发送按钮） msg-text是消息输入框的内容 msg-sound是消息输入语音 msg-image是图片（图片按钮） msg-list是消息列表区域
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
	ui.h.style.width = ui.boxMsgText.offsetWidth + 'px';//将文本宽度值赋给h
	var footerPadding = ui.footer.offsetHeight - ui.boxMsgText.offsetHeight;//让文本框居中
	var msgItemTap = function(msgItem, event) {//语音输入函数
		var msgtype = msgItem.getAttribute('msg-type');
		var msgContent = msgItem.getAttribute('msg-content')
		if (msgtype == 'sound') {//如果信息种类为语音
			player = plus.audio.createPlayer(msgContent);//找到指定的音频文件并播放
			var playState = msgItem.querySelector('.play-state');
			playState.innerText = '正在播放...';//语音信息显示为正在播放
			player.play(function() {
				playState.innerText = '点击播放';
			}, function(e) {
				playState.innerText = '点击播放';
			});
		}
	};
	var imageViewer = new $.ImageViewer('.msg-content-image', {dbl: false});//图片预览组件
	var bindMsgList = function() {//绑定消息节点
		ui.areaMsgList.innerHTML = template('msg-template', {"record": record});//将数据绑定到界面上
		var msgItems = ui.areaMsgList.querySelectorAll('.msg-item');//拿到所有的聊天节点
		[].forEach.call(msgItems, function(item, index) {
			item.addEventListener('tap', function(event) {
				msgItemTap(item, event);//调用之前定义的语音输入代码来处理语音消息播放
			}, false);
		});
		imageViewer.findAllImage();//找到所有符合条件的图片
		ui.areaMsgList.scrollTop = ui.areaMsgList.scrollHeight + ui.areaMsgList.offsetHeight;//聊天界面的高度修改
	};
	window.addEventListener('resize', function() {//平滑高度过渡
		ui.areaMsgList.scrollTop = ui.areaMsgList.scrollHeight + ui.areaMsgList.offsetHeight;
	}, false);
	var send = function(msg) {//发送方法
		record.push(msg);//将消息内容体push进record
		bindMsgList();//绑定消息节点
	};
	function msgTextFocus() {//输入框获取焦点函数
			ui.boxMsgText.focus();
			setTimeout(function() {
				ui.boxMsgText.focus();
			}, 150);
		}
		//解决长按“发送”按钮，导致键盘关闭的问题；（与下面的响应事件合力完成）
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
	ui.footerRight.addEventListener('release', function(event) {//长按离开屏幕时触发
		if (ui.btnmsgtype.classList.contains('mui-icon-paperplane')) {//当是文字时
			ui.boxMsgText.focus();
			setTimeout(function() {
				ui.boxMsgText.focus();
			}, 150);
			var tt = ui.boxMsgText.value.replace(new RegExp('\n', 'gm'), '<br/>');
			mui.fire(plus.webview.getWebviewById("index.html"),"sendmsg",{tid:tid,tname:tname,ttype:ttype,msgtext:tt,msgextras:"",msgtype:"text"});//以文字发送
			send({
				sendname:user.name,
				sender: 'self',
				type: 'text',
				uimg:selfimgsrc,
				content: tt
			});
			ui.boxMsgText.value = '';
			$.trigger(ui.boxMsgText, 'input', null);
		} else if (ui.btnmsgtype.classList.contains('mui-icon-mic')) {//当是语音时
			ui.btnmsgtype.classList.add('mui-icon-compose');
			ui.btnmsgtype.classList.remove('mui-icon-mic');
			ui.boxMsgText.style.display = 'none';
			ui.boxMsgSound.style.display = 'block';
			ui.boxMsgText.blur();
			document.body.focus();
		} else if (ui.btnmsgtype.classList.contains('mui-icon-compose')) {//当是文本状态时
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
	ui.footerLeft.addEventListener('tap', function(event) {//发送图片（即左边按钮）
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
				case 1://相机拍照
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
						                	mui.fire(plus.webview.getWebviewById("index.html"),"sendmsg",{tid:tid,tname:tname,ttype:ttype,msgtext:"[图片]",msgextras:data.path,msgtype:"image"});//以图片发送
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
					   	plus.zip.compressImage({//图片压缩
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
				case 2://相册选取
					plus.gallery.pick(function(path) { 
			        	var task = plus.uploader.createUpload(sip+"uploadfile.do",
				    		{method: "POST"},function(t, status) {
					            if (status == 200) { 
					                console.log("上传成功：" + t.responseText);
					                eval("var data="+t.responseText);
					                if(data.result=="OK"){
					                	send({sendname:user.name,sender: 'self',type: 'image',uimg:selfimgsrc,content: path});
					                	mui.fire(plus.webview.getWebviewById("index.html"),"sendmsg",{tid:tid,tname:tname,ttype:ttype,msgtext:"[图片]",msgextras:data.path,msgtype:"image"});//以图片发送
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
					   	plus.zip.compressImage({//图片压缩
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
	var setSoundAlertVisable=function(show){//按住语音时的显示与隐藏
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
	ui.boxMsgSound.addEventListener('hold', function(event) {//按住说话时触发
		recordCancel = false;
		if(stopTimer)clearTimeout(stopTimer);//如果有结束时间，清除定时器
		audio_tips.innerHTML = "手指上划，取消发送";//修改显示的文字
		ui.boxSoundAlert.classList.remove('rprogress-sigh');
		setSoundAlertVisable(true);//显示样式
		recorder = plus.audio.getRecorder();//获取录音对象
		if (recorder == null) {
			plus.nativeUI.toast("不能获取录音对象");
			return;
		}
		startTimestamp = (new Date()).getTime();//记录当前录音时间
		recorder.record({//保存录音
			filename: "_doc/audio/"
		}, function(path) {
			if (recordCancel) return;
			var task = plus.uploader.createUpload(sip+"uploadfile.do",//上传于服务器中，实际与上传到服务器中的图片位于一个位置，保存格式是amr格式
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
						       	mui.fire(plus.webview.getWebviewById("index.html"),"sendmsg",{tid:tid,tname:tname,ttype:ttype,msgtext:"[语音消息]",msgextras:data.path,msgtype:"sound"});//以语音发送 在服务器的数据库中则存入[语音消息]这几个文字来与其他的消息类型进行区分
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
	ui.body.addEventListener('drag', function(event) {//监听drag（拖动中）事件，及上滑，下滑
		if (Math.abs(event.detail.deltaY) > 50) {//此时已经上滑到屏幕中间的取消发送位置
			if (!recordCancel) {//此时没有录音操作执行，检查recordCancel状态
				recordCancel = true;
				if (!audio_tips.classList.contains("cancel")) {
					audio_tips.classList.add("cancel");
				}
				audio_tips.innerHTML = "松开手指，取消发送";
			}
		} else {//还没有上滑
			if (recordCancel) {
				recordCancel = false;
				if (audio_tips.classList.contains("cancel")) {
					audio_tips.classList.remove("cancel");
				}
				audio_tips.innerHTML = "手指上划，取消发送";//在屏幕中间显示
			}
		}
	}, false);
	ui.boxMsgSound.addEventListener('release', function(event) {//长按录音节点离开后的响应事件
		//console.log('release');
		if (audio_tips.classList.contains("cancel")) {//初始化
			audio_tips.classList.remove("cancel");
			audio_tips.innerHTML = "手指上划，取消发送";
		}
		//判断录音是否小于所定义的最小录音时间，若小于，则废弃（在代码的上面已定义了最短录音时间为800ms）
		stopTimestamp = (new Date()).getTime();
		if (stopTimestamp - startTimestamp < MIN_SOUND_TIME) {
			audio_tips.innerHTML = "录音时间太短";//在屏幕中间显示录音时间太短
			ui.boxSoundAlert.classList.add('rprogress-sigh');
			recordCancel = true;
			stopTimer=setTimeout(function(){
				setSoundAlertVisable(false);
			},800);
		}else{
			setSoundAlertVisable(false);
		}
		recorder.stop();//停止录音模块
	}, false);
	ui.boxMsgSound.addEventListener("touchstart", function(e) {//阻止浏览器默认的事件冒泡
		e.preventDefault();
	});
	ui.boxMsgText.addEventListener('input', function(event) {//监听用户输入时触发
		ui.btnmsgtype.classList[ui.boxMsgText.value == '' ? 'remove' : 'add']('mui-icon-paperplane');//当输入为空时去掉发送按钮，当不为空时，显示发送按钮
		ui.btnmsgtype.setAttribute("for", ui.boxMsgText.value == '' ? '' : 'msg-text');//当用户输入值不为空时，设置自定义属性for，赋值msg-text
		ui.h.innerText = ui.boxMsgText.value.replace(new RegExp('\n', 'gm'), '\n-') || '-';//替换与正则表达式相匹配的值
		ui.footer.style.height = (ui.h.offsetHeight + footerPadding) + 'px';//动态调整输入框高度
		ui.content.style.paddingBottom = ui.footer.style.height;//调整显示信息高度
	});
	var focus = false;
	ui.boxMsgText.addEventListener('tap', function(event) {//监听用户点击发送时触发
		ui.boxMsgText.focus();//获得焦点
		setTimeout(function() {
			ui.boxMsgText.focus();
		}, 0);
		focus = true;
		setTimeout(function () {
			focus = false;
		},1000);
		event.detail.gesture.preventDefault();//阻止ios中的手势事件
	}, false);
	//点击消息列表，关闭键盘
	ui.areaMsgList.addEventListener('click',function (event) {
			if(!focus){
				ui.boxMsgText.blur();
			}
		})
	//自定义方法
	addData= function(message) {//气泡消息条目
		var sendid =message.fromid==user.id?"self":"zs";//判断消息的来源是否是本机的用户  下面的content则是判断消息种类是否为文字，若不为文字则在服务器的额外信息中存入图片的路径
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
