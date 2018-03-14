<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>新闻列表页</title>
	<link href="./css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
		  $(".click").click(function(){
		  	$(".tip").fadeIn(200);
		  });
		  
		  $(".tiptop a").click(function(){
		  $(".tip").fadeOut(200);
		});
		
		  $(".sure").click(function(){
		  $(".tip").fadeOut(100);
		});
		
		  $(".cancel").click(function(){
		  $(".tip").fadeOut(100);
		});
		
		});
	</script>
</head>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据表</a></li>
			<li><a href="#">基本内容</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<form action="${pageContext.request.contextPath}/newsListServlet" method="post" id="pageForm">
			<div class="tools">
				<ul class="toolbar">
					<li class="click"><span><img src="images/t01.png" /></span>添加</li>
					<li class="click"><span><img src="images/t02.png" /></span>修改</li>
					<li><span><img src="images/t03.png" /></span>删除</li>
					<li><span><img src="images/t04.png" /></span>统计</li>
				</ul>
				<ul class="toolbar1">
					<input type="hidden" id="pageNo" name="pageNo" value = "${page.pageNo}">
					<li><label>作者:</label><input type="text" id="newsAuthor" name="newsAuthor" style="padding:5px 5px 5px 5px;margin: auto;"></li>
					<li>
						<label>栏目:</label>
						<select id="column" name="column" style="padding:5px 5px 5px 5px;margin: auto;">
							<c:forEach items="${columnList}" var="column">
								<option value="${column.columnId}">${column.columnName}</option>
							</c:forEach>
						</select>
					</li>
					<li><label>关键字:</label>
						<select id="keywords" name="keywords" style="padding:5px 5px 5px 5px;margin: auto;">
							<c:forEach items="${keyList}" var="key">
								<option value="${key.keyId}">${key.keyName}</option>
							</c:forEach>
						</select>
					</li>
					<li><span><input type="submit" value="搜索" style="padding:5px 5px 5px 5px;margin: auto;" /></span></li>
				</ul>
			</div>
	
	
			<table class="tablelist">
				<thead>
					<tr>
						<th><input name="" type="checkbox" value="" checked="checked"/></th>
						<th>所属栏目<i class="sort"><img src="images/px.gif" /></i></th>
						<th>新闻标题</th>
						<th>作者</th>
						<th>发布时间</th>
						<th>浏览次数(次)</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.list}" var="news">
						<tr>
							<td><input name="" type="checkbox" value="" /></td>
							<td>${news.column.columnName}</td>
							<td>${news.newsTitle}</td>
							<td>${news.newsAuthor}</td>
							<td>${news.newsDate}</td>
							<td>${news.browseCount}</td>
							<td>
								<a href="#" class="tablelink">查看</a>
								<a href="#" class="tablelink click">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	
	
			<div class="pagin">
				<div class="message">
					共<i class="blue">${page.totalRecords}</i>条记录，当前显示第&nbsp;<i class="blue">${page.pageNo+1}&nbsp;</i>页
				</div>
				
				<ul class="paginList">
					<li class="paginItem"><a href="javascript:topage(${page.previousPage});"><span class="pagepre"></span></a></li>
					<li class="paginItem current"><a href="javascript:topage(0);">1</a></li>
					<c:forEach begin="1" end="${page.bottomPage}" var ="pagenum" >
						<li class="paginItem"><a href = "javascript:topage(${pagenum });">${pagenum+1 }</a></li>
					</c:forEach>
					<li class="paginItem more"><a href="javascript:;">...</a></li>
					<li class="paginItem"><a href="javascript:topage(${page.nextPage});"><span class="pagenxt"></span></a></li>
				</ul>
			</div>
		</form>
		


		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>

			<div class="tipinfo">
				<span><img src="images/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>

		</div>




	</div>

	<script type="text/javascript">
		$(".tablelist tbody tr:odd").addClass('odd');
	function topage(pageNo) {
		$("#pageNo").val(pageNo);
		$("#pageForm").submit();
	}
	</script>
	
</body>
</html>