<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm</title>
</head>
<body>
<h2><b>Chúc mừng bạn đã đăng ký thành công</b></h2><br>
<b>Thông tin bạn đăng kí bao gồm </b><br>
<h3>Đặt Tour: <b>${tour.description}</b>  ${tour.days}</h3><br>
<b>Thông tin khách hàng</b><br>


        <label for="name">Họ tên: ${customer.name}</label><br>
        
        <label for="address">Địa chỉ: ${customer.address}</label><br>
        

        <label for="email">E-mail:${customer.email}</label><br>
      

        <label for="telephoneNumber">Điện thoại: ${customer.phone} </label><br>
       

        <b>Thông tin chuyến đi:</b><br>

        <label for="date">Ngày khởi hành: ${booking.departureDate} </label><br>
       

        <label for="adult">Số người lớn: ${booking.noAdults} </label><br>
      

        <label for="child">Số trẻ em:  ${booking.noChildren}</label><br>
       
        <a href="listTour.jsp"><input type="button" value="Xác nhận thành công"></a><br>
   

</body>
</html>