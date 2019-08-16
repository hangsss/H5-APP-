<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" href="${pageContext.request.contextPath }/res/css/bootstrap.min.css" />
  	<style type="text/css">
  	html,body{ height:100%;font-family:"黑体";min-width:1150px;min-height: 640px;}
  	</style>
  </head>
  <body style="padding-top: 50px;">
  <nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
		<div class="navbar-header">
			 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mynav"> 
				 <span class="sr-only">Toggle navigation</span>
				 <span class="icon-bar"></span>
				 <span class="icon-bar"></span>
				 <span class="icon-bar"></span>
			 </button> 
			 <a class="navbar-brand" href="#">momo通讯后台管理</a>
		</div>
		<div class="collapse navbar-collapse" id="mynav">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Link</a></li>
				<li><a href="#">Link</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<span class="glyphicon glyphicon-cog"></span> 系统设置<strong class="caret"></strong>
					</a>
					<ul class="dropdown-menu">
						<li><a  href="#modal-container-239459" data-toggle="modal">修改密码</a></li>
						<li><a href="#">添加好友</a></li>
						<li><a href="#">创建分组</a></li>
						<li class="divider"></li>
						<li><a href="#">退出系统</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
  <div class="container-fluid" >	 	 
	 <div class="row clearfix" >
		<div class="col-md-2" style="padding: 0px;height:100%;background-color: #2c2c2c;">
			<div class="panel-group" id="grouplist">
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title" data-toggle="collapse" data-parent="#grouplist" href="#panel-element-594051" style="text-decoration: none;">
						 <span class="glyphicon glyphicon-chevron-right"></span> ...</a>
					</div>
					<div id="panel-element-594051" class="panel-collapse collapse">
						<div class="panel-body" style="padding: 0px;">
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#" style="padding-left: 20%;"><span class="glyphicon glyphicon-user"></span> ...</a></li>
								<li><a href="#" style="padding-left: 20%;"><span class="glyphicon glyphicon-user"></span> ...</a></li>
								<li><a href="#" style="padding-left: 20%;"><span class="glyphicon glyphicon-user"></span>...</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title" data-toggle="collapse" data-parent="#grouplist"  href="#panel-element-266764" style="text-decoration: none;">
						 <span class="glyphicon glyphicon-chevron-right"></span> ...</a>
					</div>
					<div id="panel-element-266764" class="panel-collapse collapse">
						<div class="panel-body" style="padding: 0px;">
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#" style="padding-left: 20%;"><span class="glyphicon glyphicon-user"></span> ...</a></li>
								<li><a href="#" style="padding-left: 20%;"><span class="glyphicon glyphicon-user"></span> ...</a></li>
								<li><a href="#" style="padding-left: 20%;"><span class="glyphicon glyphicon-user"></span> ...</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-10" style="padding: 0px;height:100%;">
		暂未开发！
		<img id="uimg" />
		</div>
	</div>
</div>
<div class="modal fade" id="modal-container-239459" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					修改密码
				</h4>
			</div>
			<div class="modal-body">
				内容...
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">保存</button>
			 	<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/res/js/jquery.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/res/js/bootstrap.min.js" ></script>
<script type="text/javascript">
window.onload=function (){
	document.getElementById("uimg").src = "${pageContext.request.contextPath }/getuimg.do?uid=100001";
};
</script>
</body>
</html>
