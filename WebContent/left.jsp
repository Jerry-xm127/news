<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>左部菜单栏</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		$(function(){	
			//导航切换
			$(".menuson li").click(function(){
				$(".menuson li.active").removeClass("active")
				$(this).addClass("active");
			});
			
			$('.title').click(function(){
				var $ul = $(this).next('ul');
				$('dd').find('ul').slideUp();
				if($ul.is(':visible')){
					$(this).next('ul').slideUp();
				}else{
					$(this).next('ul').slideDown();
				}
			});
		})	
	</script>
</head>
<body style="background:#f0f9fd;">
	<div class="lefttop">
		<span></span>菜单栏
	</div>

	<dl class="leftmenu">

		<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /></span>新闻信息管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${pageContext.request.contextPath}/newsReleaseServlet" target="rightFrame">发布新闻</a><i></i></li>
				<li class="active"><cite></cite><a href="right.html" target="rightFrame">修改新闻</a><i></i></li>
				<li><cite></cite><a href="imgtable.html" target="rightFrame">删除新闻</a><i></i></li>
				<li><cite></cite><a href="error.html" target="rightFrame">404页面</a><i></i></li>
			</ul>
		</dd>
		
		<dd>
			<div class="title">
				<span><img src="images/leftico03.png" /></span>新闻类型管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="#">添加新闻类型</a><i></i></li>
				<li><cite></cite><a href="#">修改新闻类型</a><i></i></li>
				<li><cite></cite><a href="#">删除新闻类型</a><i></i></li>
				<li><cite></cite><a href="#">其他</a><i></i></li>
			</ul>
		</dd>

		<dd>
			<div class="title">
				<span><img src="images/leftico02.png" /></span>关键字管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="#">修改关键字</a><i></i></li>
			</ul>
		</dd>


		<dd>
			<div class="title">
				<span><img src="images/leftico04.png" /></span>评价信息管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="#">自定义</a><i></i></li>
				<li><cite></cite><a href="#">常用资料</a><i></i></li>
				<li><cite></cite><a href="#">信息列表</a><i></i></li>
				<li><cite></cite><a href="#">其他</a><i></i></li>
			</ul>
		</dd>
		
		<dd>
			<div class="title">
				<span><img src="images/leftico03.png" /></span>统计汇总信息
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="#">添加新闻类型</a><i></i></li>
				<li><cite></cite><a href="#">修改新闻类型</a><i></i></li>
				<li><cite></cite><a href="#">删除新闻类型</a><i></i></li>
				<li><cite></cite><a href="#">其他</a><i></i></li>
			</ul>
		</dd>
		
		<dd>
			<div class="title">
				<span><img src="images/leftico03.png" /></span>管理员管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="#">添加新闻类型</a><i></i></li>
				<li><cite></cite><a href="#">修改新闻类型</a><i></i></li>
				<li><cite></cite><a href="#">删除新闻类型</a><i></i></li>
				<li><cite></cite><a href="#">其他</a><i></i></li>
			</ul>
		</dd>

	</dl>
</body>
</html>