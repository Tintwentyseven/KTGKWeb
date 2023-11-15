<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListTour</title>
<style>
table,th,td{
border:2px solid white;
border-collapse:collapse;
}
th{
background-color:#bbbbbb;
}
tr:nth-child(even){
background-color:rgb(153,255,204);
}
tr:nth-child(odd){
background-color: rgb(204,255,255);
}
button{
background-color:blue;
color:white;
font-weight:bold;
border-radius:3px;
}
</style>
</head>
<body>
<h2>Các chương trình DU LỊCH</h2>
<jsp:useBean id="tourService" class="services.TourService"></jsp:useBean>



   <table border="1">
      <tr>
         <th style="width:400px">Chương trình</th>
         <th style="width:150px">Lịch khởi hành</th> 
         <th style="width:100px">Gía</th>
         <th>Đặt</th>
      </tr>

      <c:forEach var="tour" items="${tourService.getAllTours()}">
          <tr>
              <td style="font-weight:bold"><a href="tourDetails?id=${tour.id}">${tour.description}</a><br>${tour.days}</td>
              <td>${tour.departureSchedule}</td>
              <td style="text-align:right;font-weight:bold"><fmt:formatNumber var="Price" value="${tour.price}" type="Number" pattern="###,###"/>
              <c:set var="Price" value="${Price.replace(',','.')}"/>${Price}
              </td>
              <td style="width:70px;text-align:center">
                  <a href="bookingTour.jsp?tourId=${tour.id}"><button>Đặt tour</button></a>
                  
              </td>
          </tr>
      </c:forEach>
   </table>

</body>
</html>