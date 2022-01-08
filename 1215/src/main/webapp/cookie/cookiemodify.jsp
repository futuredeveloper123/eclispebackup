<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie modify </title>
</head>
<body>

<% 
//name 이라는 쿠기가 존재하면 수정 ! 이고 존재하지 않으면 추가 ! 
Cookie cookie = new Cookie("name","coo");
response.addCookie(cookie);

%>

</body>
</html>