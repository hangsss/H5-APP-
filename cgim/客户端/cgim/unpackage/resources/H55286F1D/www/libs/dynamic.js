mui.previewImage();//初始化页面预览控件
mui.init({preloadPages:[{url:"publish_dynamic.html",id:"publish_dynamic.html"}]});
var self;
document.addEventListener("plusready", function() {
	self = plus.webview.currentWebview();
	self.setStyle({scrollIndicator:'none'});
	self.setPullToRefresh({support: true,style:'circle'}, pulldownRefresh);//注册下拉刷新事件
}, false);
function pulldownRefresh() {
	setTimeout(function() {
		getdynamiclist();
		self.endPullToRefresh();
	}, 1500);
}
mui.plusReady(function(){
	getdynamiclist();
});

var dynamiclist={};
//获取动态列表
function getdynamiclist(){
	mui.post(sip+"dynamicList.do",{id:user.id},function(json){
		document.querySelector(".mui-content").innerHTML="";
		var data = JSON.parse(json);
		if(data.length>0){
			for(var i=0;i<data.length;i++){
				var cinfo = data[i];
				dynamiclist[cinfo.id]=cinfo;
				adddata(cinfo);
			}
		}else{
			mui.toast("没有数据");
		}
	});
}
//根据id获取评论
function getcomment(id){
	mui.post(sip+"commentList.do",{did:id},function(json){
		var comments = JSON.parse(json);
		var html="";
		if(comments.length>0){
			html='<div class="dy-comment">';
			for(var i=0;i<comments.length;i++){
				var comment = comments[i];
				if(comment.replyId!=null){//如果回复人id不为空则证明为回复的评论
					html+='<p class="comp"><a id="'+comment.userid+'">'+comment.username+'</a> 回复 <a id="'+comment.replyId+'">'+comment.replyName+'</a>'+comment.content+'</p>';
				}else{
					html+='<p class="comp"><a id="'+comment.userid+'">'+comment.username+'：</a>'+comment.content+'</p>';
				}
			}
			html+='</div>';
		}
		document.getElementById(id).querySelector(".dy-body").innerHTML+=html;
	});
}
function adddata(cinfo){
	var card = document.createElement("div");
	card.id=cinfo.id;
	card.className="dy-card";
	var deletebtn =cinfo.createuserid==user.id?'<span class="mui-icon iconfont icon-shanchutianchong"></span>':"";
	var zanbtn ='<span class="mui-icon iconfont icon-zantianchong"></span>';
	var likeids = cinfo.likeUserids;
	if(likeids!=null){//如果点赞人id不为空
		if(likeids.indexOf(user.id)>-1){//当前用户已点赞
			zanbtn='<span class="mui-icon iconfont icon-zantianchong active"></span>';
		}
	}
	//图片存放div
	var imgdiv = "";
	var extras =cinfo.extras;
	if(extras!=null){
		if(extras.indexOf(",")>-1){
			var pathary = extras.split(",");
			for(var i=0;i<pathary.length;i++){//如果是多张
				imgdiv+="<img src='"+sip+pathary[i]+"' class='imgpriview' data-preview-src='' data-preview-group='1' />";
			}
		}else if(extras!=""){
			imgdiv+="<img src='"+sip+extras+"' class='imgpriview' data-preview-src='' data-preview-group='1' />";
		}
	}
	var infotext;
	if(cinfo.content.length>60){//内容若大于60字符，则隐藏
		infotext ='<p>'+cinfo.content.substr(0,60)+'...<a class="seeall">查看全文</a></p>';
	}else{
		infotext ='<p>'+cinfo.content+'</p>'; 
	}
	var zans = "";
	var names = cinfo.likeNames;
	if(names!=null){//若点赞人不为空
		if(names.indexOf(",")>-1){
			var reg=new RegExp(",","g");
			var snames = names.replace(reg,"、");
			zans=snames+" "+names.split(",").length+"人觉得很赞";
		}else{
			zans=names+" "+"1人觉得很赞";
		}
	}
	card.innerHTML='<img class="dy-uimg" src="'+sip+'getuimg.do?uid='+cinfo.createuserid+'"><div class="dy-body"><div class="dy-header"><a id="'+cinfo.createuserid+'">'+cinfo.createname+'</a><span>'+fdt(cinfo.createtime)+'</span></div><div class="dy-content">'+infotext+imgdiv+'</div>'+
				   '<div class="dy-operate"><span class="mui-icon iconfont icon-duihuaxinxitianchong"></span>'+zanbtn+deletebtn+'</div><div class="zannames">'+zans+'</div></div>';
	document.querySelector(".mui-content").appendChild(card);
	getcomment(cinfo.id);
}
document.querySelector(".mui-pull-right").addEventListener("tap",function(){
	pagejump("publish_dynamic.html");
});
var footer =document.querySelector(".footer-input");
var combtn = document.getElementById("pubcom");
var cominput = document.querySelector(".mui-input-clear");
var mask = mui.createMask(closefooter);
function closefooter(){
	footer.classList.add("mui-hidden");
}
var cdyid;
var postdata = {};
//点击评论图标触发的操作
combtn.addEventListener("tap",function(){
	var comcontent = cominput.value;
	if(comcontent!=null&&comcontent!=""){
		postdata.dynamicid=cdyid;
		postdata.userid=user.id;
		postdata.username=user.name;
		postdata.content = comcontent;
		mui.post(sip+"publishComment.do",postdata,function(json){
			if(json=="true"){
				var dycom =document.getElementById(cdyid).querySelector(".dy-comment");
				var html;
				if(postdata.replyId!=null){
					html='<p class="comp"><a id="'+user.id+'">'+user.name+'</a> 回复 <a id="'+postdata.replyId+'">'+postdata.replyName+'</a>'+comcontent+'</p>'
				}else{
					html='<p class="comp"><a id="'+user.id+'">'+user.name+'：</a>'+comcontent+'</p>';
				}
				if(dycom!=null){
					dycom.innerHTML+=html;
				}else{
					document.getElementById(cdyid).querySelector(".dy-body").innerHTML+='<div class="dy-comment">'+html+'</div>';
				}
			}else{
				mui.toast("网络连接出错，评论失败");
			}
			mask.close();
			cominput.value="";
			footer.classList.add("mui-hidden");
		})
	}
});
//发送按钮是否可用
cominput.addEventListener("input",function(){
	if(this.value!=null&&this.value!=""){
		if(combtn.classList.contains("mui-disabled")){
			combtn.classList.remove("mui-disabled");
		}
	}else{
		if(!combtn.classList.contains("mui-disabled")){
			combtn.classList.add("mui-disabled");
		}
	}
});
//点击评论图标输入评论
mui(".mui-content").on("tap",".icon-duihuaxinxitianchong",function(){
	cdyid= this.parentNode.parentNode.parentNode.id;
	mask.show();
	footer.classList.remove("mui-hidden");
	document.querySelector(".mui-input-clear").focus();
	cominput.setAttribute("placeholder","输入评论");
});
//点赞相关操作
mui(".mui-content").on("tap",".icon-zantianchong",function(){
	var obj = this;
	cdyid= obj.parentNode.parentNode.parentNode.id;
	if(obj.classList.contains("active")){
		obj.classList.remove("active");
		pointzan(obj,"nolike");
	}else{
		obj.classList.add("active");
		pointzan(obj,"like");
	}
});
function pointzan(obj,operate){
	var namediv = document.getElementById(cdyid).querySelector(".zannames");
	mui.post(sip+operate+".do",{id:cdyid,userid:user.id,username:user.name},function(json){
		var res = JSON.parse(json);
		if(res.success==true){
			var names =res.names; 
			if(names!=""){
				var reg=new RegExp(",","g");
				var snames = names.replace(reg,"、");
				if(names.indexOf(",")>-1){
					namediv.innerHTML=snames+" "+names.split(",").length+"人觉得很赞";
				}else{
					namediv.innerHTML=names+" "+"1人觉得很赞";
				}
			}else{
				namediv.innerHTML="";
			}
		}else{
			if(operate=="nolike"){
				obj.classList.remove("active");
				mui.toast("取消失败");
			}else{
				obj.classList.add("active");
				mui.toast("点赞失败");
			}
		}
	});
}
//若改动态势当前登录人所发，则可以拥有删除该动态权限
mui(".mui-content").on("tap",".icon-shanchutianchong",function(){
	cdyid= this.parentNode.parentNode.parentNode.id;
	mui.confirm("确认删除该动态？","提示",["取消","确定"],function(e){
		if (e.index == 1) {
			mui.post(sip+"deleteDynamic.do",{id:cdyid},function(json){
				if(json=="true"){
					document.getElementById(cdyid).remove();
					mui.toast("删除成功");
				}
			})
		}
	});
});
//收起全文
mui(".mui-content").on("tap",".seeall",function(){
	var txt = this.parentNode;
	var dyid =this.parentNode.parentNode.parentNode.parentNode.id;
	txt.innerHTML=dynamiclist[dyid].content+"<br><a class='hideall'>收起全文</a>";
});
//显示全文
mui(".mui-content").on("tap",".hideall",function(){
	var txt = this.parentNode;
	var dyid =this.parentNode.parentNode.parentNode.parentNode.id;
	txt.innerHTML=dynamiclist[dyid].content.substr(0,60)+"...<a class='seeall'>查看全文</a>";
});
//点击评论进行回复
mui(".mui-content").on("tap",".comp",function(){
	cdyid= this.parentNode.parentNode.parentNode.id;
	var uid = this.querySelectorAll("a")[0].id;
	var uname = this.querySelector("a").innerHTML;
	postdata.replyId=uid;
	postdata.replyName=uname;
	mask.show();
	footer.classList.remove("mui-hidden");
	document.querySelector(".mui-input-clear").focus();
	cominput.setAttribute("placeholder","回复 "+uname);
});