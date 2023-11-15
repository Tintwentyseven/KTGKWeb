<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ReplyTopicForum</title>
<link rel="stylesheet" type="text/css" href="./css/newTopic.css">
<link rel="stylesheet" type="text/css" href="./css/index.css">
</head>
<body>
	<div class="wrapper">
		<c:set var="user" value="${sessionScope.user}" />
				<div class="header" style="font-size:13px;text-align:right">
		
			<span>Chào ${user.username}| </span> <a href="logout">Thoát</a>
		</div>
		<form class="input" action="reply?id=${requestScope.id}"
			method="post">
			<b>Tiêu đề</b> <input type="text" name="title"
				value="Re: ${requestScope.title}"> <br> <b>Nội dung</b>
			<textarea rows="4" cols="50" name="content"></textarea>
			<div class="submit">
				<button type="submit">Gửi</button>
				<button>
					<a href="new-topic?type=cancel" style="text-decoration:none">hủy bỏ</a>
				</button>
			</div>
		</form>
	</div>

</body>
</html>