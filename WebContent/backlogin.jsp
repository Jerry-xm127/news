<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>欢迎登录新闻发布后台管理系统</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/cloud.js"> </script>
		<script type="text/javascript">
		$(function(){
		    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		    
			$(window).resize(function(){  
		    	$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		    })  
		}); 
	</script>
</head>
<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>

	<div class="logintop">
		<span>欢迎登录新闻发布后台管理界面平台</span>
		<ul>
			<li><a href="#">回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>

	<div class="loginbody">
		<span class="systemlogo"></span>
		
		<div class="loginbox">
			<form action="#" method="post">
				<ul>
					<li><input  type="text" name="account" class="loginuser"  /></li>
					<li><input  type="password" name="pwd" class="loginpwd"  /></li>
					<li><input type="submit" name="sub"  class="loginbtn" value="登录"/>
					<label><input  type="checkbox" name="remember" checked="checked" />记住密码</label>
					<label><a href="#">忘记密码？</a></label></li>
				</ul>
			</form>
		</div>
	</div>
	
	<div class="loginbm">版权所有 2018 .com 仅供项目展示，勿用于任何商业用途</div>
</body>
</html>