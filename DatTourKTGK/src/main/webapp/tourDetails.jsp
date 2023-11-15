<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TourDetail</title>
</head>
<body>
<form action="datTour">
<b>${tour.description}</b><br>
<b>Số ngày: </b>${days} <b>Phương tiện: </b>${tour.transportation}. <b>Lịch khởi hành: </b>${tour.departureSchedule}<br>
<h3>Chương trình</h3><br>
${tour.details}<br>
<input type="hidden" name="tourId" value="${tour.id}">
                   
 <input type="submit" value="Dat tour">                                         <a href="listTour.jsp" style="position:absolute;left:650px;top:340px;font-size:15px">CHƯƠNG TRÌNH TOUR</a>
 
</form>

<style>
input[type="submit"]{
background-color:blue;
color:white;
font-weight:bold;
border-radius:3px;
}
</style>
</body>
</html>