<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<c:set var="user" value="${sessionScope.user}" />
	<div class="wrapper">
		<div class="header">
		<span>Chào <b style="color: blue;"><c:out value="${user.username}" /></b>|</span>
			<a href="logout">Thoát</a>
		</div>
		<h2><b>Danh mục các mặt hàng đấu giá</b></h2>
		<table>

			<tr>
				<th>Mặt hàng</th>
				<th>Giá</th>
			</tr>

			<c:forEach var="au" items="${requestScope.auction}">
			<fmt:formatNumber var="init" value="${fn:replace(au.initialPrice, ',', '.')}" />
			<fmt:formatNumber var="current" value="${au.currentPrice}" pattern="#,##0" />
                <tr>
                    <td><a href="auction?id=<c:out value="${au.id}" />"><c:out value="${au.description}" /></a></td>
                    <td>
                        Giá khởi đầu: <c:out value="${init}" /> VND <br>
                        <c:if test="${not empty au.bids}">
                            Giá hiện tại: <c:out value="${current}" /> VND <br>
                            (<c:out value="${fn:length(au.bids)}" />) lời đặt giá
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
		</table>
	</div>
</body>
</html>