<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<c:set var="au" value="${requestScope.item}" />
	<c:choose>
	    <c:when test="${au.currentPrice eq 0}">
	        <c:set var="total" value="${au.initialPrice + au.priceStep}" />
	    </c:when>
	    <c:otherwise>
	        <c:set var="total" value="${au.currentPrice + au.priceStep}" />
	    </c:otherwise>
	</c:choose>
	<div class="wrapper">

		<div class="header">
		<span>Chào <b style="color: blue;"><c:out value="${user.username}" /></b>|</span>
			<a href="logout">Thoát</a>
		</div>
		<h2>
			<b><c:out value="${au.description}" /></b>
		</h2>
		<table>
			<tr>
				<th></th>
				<th style="text-align: left;">Thông tin người bán</th>
			</tr>

			<tr>
				<td>
					<span>
						<b>Giá hiện tại:</b>
						<fmt:formatNumber var="formattedNumber" value="${au.currentPrice}" type="number" pattern="#,##0.##" />
						<c:set var="formattedNumber" value="${formattedNumber.replace(',', '.')}" />${formattedNumber} VNĐ
					</span> <br>
					<span>
						<b>Người đặt:</b><a href = "#">${au.bids[fn:length(au.bids) - 1].bidder.username}</a>(có ${fn:length(au.bids)} lời đặt giá)
					</span> <br> 
					<span>
						<b>Giá khởi điểm:</b>
						<fmt:formatNumber var="formattedNumber" value="${au.initialPrice}" type="number" pattern="#,##0.##" />
						<c:set var="formattedNumber" value="${formattedNumber.replace(',', '.')}" />${formattedNumber} VNĐ
					</span> <br> 
					<span>
						<b>Bước giá:</b> 
						<fmt:formatNumber var="formattedNumber" value="${au.priceStep}" type="number" pattern="#,##0.##" />
						<c:set var="formattedNumber" value="${formattedNumber.replace(',', '.')}" />${formattedNumber} VNĐ
					</span> <br> 
					<span><b>Bắt đầu lúc:</b> <b style="color: red;"><fmt:formatDate type="time" value="${au.startDate.time}" pattern="HH:mm:ss" /> Ngày: <fmt:formatDate type="date" value="${au.startDate.time}" pattern="dd/MM/yyyy" /></span></b> <br> 
					<span><b>Ngày kết thúc:</b> <fmt:formatDate type="time" value="${au.endDate.time}" pattern="HH:mm:ss" /> Ngày: <fmt:formatDate type="date" value="${au.endDate.time}" pattern="dd/MM/yyyy" /></span> <br> 
					<span><b>Thời gian còn lại:</b> ${au.duration}</span> <br> <br>
					<form action="bid?id=<c:out value="${au.id}" />" method="post" class="form-login">
						<div>
							<span>Giá đặt: <input type="text" name="price" style="margin-right: 4px">>=<fmt:formatNumber var="formattedNumber" value="${total}" type="number" pattern="#,##0.##" /><c:set var="formattedNumber"
					value="${formattedNumber.replace(',', '.')}" />${formattedNumber}</span></span>
							<input type="hidden" name="priceStep" value="${au.priceStep}">
							<input type="hidden" name="currentPrice" value="${au.currentPrice}">
						</div>
						<button type="submit" style="margin-left: 55px; margin-top: 4px">Đặt giá</button>
					</form>
				</td>

				<td>
					<div style="padding-bottom: 97px;">
						<span><b>Tên tài khoản:</b> <a href = "#">${au.seller.username}</a></span> <br>
						<span><b>Tên cửa hàng:</b> ${au.seller.fullName}</span> <br>
						<span><b>Điện thoại:</b> ${au.seller.phone}</span> <br>
						<span><b>Email:</b> <a href = "#">${au.seller.email}</a></span> <br>
						<span><b>Địa chỉ:</b> ${au.seller.address}</span>
					</div>
					
				</td>
			</tr>

		</table> 
		<div class="list">
			<a href="listAution">Danh sách đấu giá</a>
		</div>
	</div>
</body>
</html>