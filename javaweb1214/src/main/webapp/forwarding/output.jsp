<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 응답 - 결과를 출력 </title>
</head>
<body>

<%
//앞에서 전달한 데이터 가져오기 
//이름 맞추는 거라 어려울 것도 없음 //앞에서 쓴거 다 그냥 갔다 쓰는 것 
//int result1 =(Integer)request.getAttribute("result1");
int result2 =(Integer)session.getAttribute("result2");
int result3 =(Integer)application.getAttribute("result3");

//출력
//out.println("<p>request:"+result1+"</p>");
out.println("<p>session:"+result2+"</p>");
out.println("<p>application:"+result3+"</p>");

%>


</body>
</html>