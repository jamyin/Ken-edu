<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>团餐登录</title>
<link href="login/css/style.css" rel="stylesheet" />
</head>
<body>
	<h1>欢迎使用阳光午餐系统</h1>
	<div class="login_wrap"></div>
	<div class="login_box">
		<ul>
			<form id="submit_form">
				<li><input name="userAccount" type="text" placeholder="请输入登录名"></li>
				<li><input name="password" type="password" placeholder="请输入密码名"></li>
			</form>
			<li class="submit"><input id="login" type="button" value="登录"><a href="reg.jsp">注册新用户</a></li>
		</ul>
	</div>
</body>
<script src="reg/js/jquery-1.11.1.min.js"></script>
<script>
	$(function() {
		$("#login").click(function() {
			var dataParam = $("#submit_form").serialize();
			$.ajax({
				url : '${pageContext.request.contextPath}/userController/login',
				type : "POST",
				data : dataParam,
				dataType : 'json',
				success : function(data) {
					if(!data.success){
						alert(data.msg);
					}else{
						window.location.href = "index.jsp";
					}
				}
			});			
		});
	});
</script>
</html>