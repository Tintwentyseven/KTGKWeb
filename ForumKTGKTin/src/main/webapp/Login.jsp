<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginForum</title>
<link rel="stylesheet" type="text/css" href="./css/Login.css">
<link rel="stylesheet" type="text/css" href="./css/index.css">
</head>

	<c:if
		test="${not empty requestScope.status and requestScope.status eq 'failed'}">
		<div class="err" >Tài khoản hoặc mật khẩu không chính xác, vui
			lòng nhập lại</div>
	</c:if>



<body>
		<div class="container">
			<div class="box1">
			<h3>Đăng nhập</h3>
			</div>
			<form class="box2" method="post" action="login">
			
			<table>
				<tr>
				<td align="right">Tên đăng nhập</td>
				<td><input type="text" name="name" size="20"></td>
				
				</tr>
			<tr>
				<td align="right">Mật khẩu</td>
				<td><input type="password" name="password" size="20"></td>
				
				</tr>
			</table>
						<button type="submit">Đăng nhập</button>
			
			</form>
		</div>
</body>
</html>