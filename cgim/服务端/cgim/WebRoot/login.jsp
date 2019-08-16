<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script  src="${pageContext.request.contextPath }/res/js/jquery.min.js"></script>
  </head>
  
  <body style="background-image: url(${pageContext.request.contextPath }/res/img/loginbg.jpg);background-size: cover;">
    <div class="container">
		<div class="col-md-offset-4 col-md-4" style="box-shadow:0px 0px 10px #efefef inset;padding:0px 50px 50px;border-radius:5px;background: rgba(220,220,220, 0.5);margin-top: 15%;padding-top: 50px;">
			<form class="form-horizontal" method="post" role="form" action="${pageContext.request.contextPath }/Weblogin.do">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" class="form-control" name="username"  placeholder="请输入账号"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<input type="password" class="form-control" name="password" placeholder="请输入密码"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						 <button type="submit" class="btn btn-success btn-block" >登录</button>
					</div>
				</div>
			</form>
		</div>
	 </div>
  </body>
</html>
