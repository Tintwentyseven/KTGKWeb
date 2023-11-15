<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DatTour</title>
</head>
<body>
<jsp:useBean id="booking" class="services.TourService"></jsp:useBean>
<c:set var="tour" value="${booking.getTour(Long.parseLong(param.tourId))}"/>
<br>
&nbsp;&nbsp;&nbsp;Đặt tour: <b>${tour.description} </b><span>${tour.days}</span><br>
<b style="position:absolute;left:149px;top:60px">Thông tin khách hàng</b>
<form method="get" action="confirm">
        <input type="hidden" name="tourId" value="${tour.id}">

<table style="position:absolute;left:15%;top:80px">
<tr>
<td align="left" width="50%" style="font-size:14px"><label for="name">Họ tên: (*) </label></td>
<td><input type="text" size="27" height="10px" id="name" name="name" required="required" style="border: 1px solid blue"></td>
</tr>
<tr>
<td align="left" width="50%" style="font-size:14px"><label for="address">Địa chỉ: </label></td>
<td><input type="text" size="27" height="10px" id="address" name="address" style="border: 1px solid blue"></td>
</tr>
<tr>
<td align="left" width="50%" style="font-size:14px"><label for="email">E-mail:(*) </label></td>
<td><input type="text" size="27" height="10px" id="email" name="email" required="required" style="border: 1px solid blue"></td>
</tr>
<tr>
<td align="left" width="50%" style="font-size:14px"> <label for="telephoneNumber">Điện thoại: </label></td>
<td><input type="tel" size="27" height="10px" id="telephoneNumber" name="telephoneNumber" style="border: 1px solid blue"></td>
</tr>
<tr style="position:relative;top:30px;left:-40px">
<th>Thông tin chuyến đi:</th>
      <th></th>
</tr>
<tr style="position:relative;top:28px;left:0px">
<td align="left" width="50%"style="font-size:14px" ><label for="date">Ngày khởi hành: (*) </label></td>
<td><input type="date" size="17" height="10px" name="date" id="date" style="border: 1px solid blue" required="required">dd/mm/yyy</td>
</tr>
<tr style="position:relative;top:28px;left:0px">
<td align="left" width="50%" style="font-size:14px"> <label for="adult">Số người lớn: (*) </label></td>
<td><input type="text" size="2" height="10px" name="adult" id="adult" required="required" style="border: 1px solid blue"></td>
</tr>
<tr style="position:relative;top:28px;left:0px">
<td align="left" width="50%" style="font-size:14px"><label for="child">Số trẻ em: </label></td>
<td><input type="text" size="2" height="10px" id="child" name="child" style="border: 1px solid blue"></td>
</tr>
<tr style="position:relative;top:28px;left:0px">
<td style="position:relative;left:280px;top:20px">
        <button type="submit" value="gui">Gửi</button>

 <a href="listTour.jsp"  style="text-decoration:none;color:black;"><input type="button" value="Hủy bỏ"></a>
      </td>
</tr>

</table>
<br>



</form>

</body>
</html>