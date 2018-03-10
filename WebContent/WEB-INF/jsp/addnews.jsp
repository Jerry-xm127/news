<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加新闻页面</title>
	<link href="./css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="./js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./js/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="./js/select-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/ckeditor/ckeditor.js"></script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">表单</a></li>
		</ul>
	</div>

	<div class="formbody">

		<div class="formtitle">
			<span>添加新闻</span>
		</div>

		<form action="${pageContext.request.contextPath}/newsReleaseServlet" method="post" id="addform">
			<ul class="forminfo">
			<li><label>新闻标题<b>*</b></label><input type="text" name="newsTitle" id="newsTitle" class="dfinput" /><i>标题不能超过30个字符</i></li>
			<li><label>新闻简介</label><input type="text" name="newsIntro" id="newsIntro" class="dfinput" /><i>简介不能超过100个字符</i></li>
			<li><label>新闻内容<b>*</b></label><br><textarea id="newsContent" name="newsContent" class="ckeditor" style="width:700px;height:250px;visibility:hidden;"></textarea>
			
			<li><label>新闻作者<b>*</b></label><input type="text" id="newsIntro" name="newsAuthor" class="dfinput" /></li>
			<li>
				<label>所属栏目<b>*</b></label>
				<select name="column" class="dfinput" >
					<c:forEach items="${listColumn }" var="column">
						<option value="${column.columnId}">${column.columnName}</option>
					</c:forEach>
				</select>
			</li>
			<li>
				<label>关键字<b>*</b></label>
				<select name="keywords" class="dfinput" >
					<c:forEach items="${listKeywords }" var="keywords">
						<option value="${keywords.keyId}">${keywords.keyName}</option>
					</c:forEach>
				</select>
			<li>
				<label>&nbsp;</label>
				<input type="button" id="add_btn" name="add_submit"  class="btn" value="马上发布"/>
			</li>
		</ul>
			
		</form>
		

	</div>
</body>
<script type="text/javascript">
		$("#add_btn").click(function () {
			var newsTitle = $("#newsTitle").val();
			var newsContent = $("#newsContent").val();
			var newsIntro = $("#newsIntro").val();
			if((newsTitle == null || newsTitle == '') || (newsIntro == null || newsIntro == '')) {
				alert("带*的为必填项，请确认是否填写完整");
			}else{
				$("#addform").submit();
			}
		});
</script>
</html>