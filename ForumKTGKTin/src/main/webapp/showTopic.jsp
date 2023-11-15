
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShowTopicForum</title>
<link rel="stylesheet" type="text/css" href="./css/showTopic.css">
<link rel="stylesheet" type="text/css" href="./css/index.css">
</head>
<body>
	<div class="wrapper">
		<c:set var="topic" value="${requestScope.topic}" />
		<c:set var="user" value="${sessionScope.user}" />
		
		<div class="header" style="font-size:13px;text-align:right">
			<span>Chào ${user.username}| </span> <a href="logout">Thoát</a>
		
		</div>
		<p class="title">Chủ đề:&nbsp;${topic.title}</p>
		<c:catch var="emptyStackException">
            
			<c:choose>
				<c:when test="${not empty topic.newMessage}">
					<span>Bài mới nhất gửi <fmt:formatDate type="date" value="${topic.newMessage.createdTime.time}" pattern="MM/dd/yyyy hh:mm a" />, do <b>${topic.newMessage.creator.username}</b> gửi. <span>${fn:length(topic.messages)} hồi âm</span></span>
				</c:when>
				<c:otherwise>
					<span>Bài mới nhất gửi <fmt:formatDate type="date" value="${topic.createdTime.time}" pattern="MM/dd/yyyy hh:mm a" />, do <b>${topic.creator.username}</b> gửi. <span>${fn:length(topic.messages)} hồi âm</span></span>
				</c:otherwise>
			</c:choose>

		</c:catch>


		<div class="table">
            <div class="time"><fmt:formatDate type="both" value="${topic.createdTime.time}" pattern="MM-dd-yyyy hh:mm a" /></div>
            <div class="group">
                <div class="user">
                    <b>${topic.creator.username}</b>
                    <p>Tham gia <fmt:formatDate type="date" value="${topic.createdTime.time}" pattern="MM-dd-yyyy" /></p>
                </div>
                <div class="content">
                    <div class="content-title">
                        <span>${topic.title}</span> <a href="reply?id=${topic.id}">Trả lời</a>
                    </div>
                    <div class="content-detail">${topic.content}</div>
                </div>
            </div>
        </div>
        <c:forEach var="mess" items="${topic.messages}">
            <div class="table">
                <div class="time"><fmt:formatDate type="both" value="${mess.createdTime.time}" pattern="MM-dd-yyyy hh:mm a" /></div>
                <div class="group">
                    <div class="user">
                        <b>${mess.creator.username}</b>
                        <p>Tham gia <fmt:formatDate type="date" value="${mess.createdTime.time}" pattern="MM-dd-yyyy" /></p>
                    </div>
                    <div class="content">
                        <div class="content-title">
                            <span>${mess.title}</span> <a href="reply?id=${topic.id}">Trả lời</a>
                        </div>
                        <div class="content-detail">${mess.content}</div>
                    </div>
                </div>
            </div>
        </c:forEach>		
		<div class="list">
			<a href="topics">Danh sách chủ đề</a>
		</div>

	</div>
</body>
</html>