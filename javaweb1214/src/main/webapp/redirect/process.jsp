<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>process<title>
</head>
<body>
<%

//파라미터 읽어오기 
String su1=request.getParameter("su1");
String su2=request.getParameter("su2");

//정수로 변환해서 덧셈하기 //항상 문자열 정수로 변환할때 parse 
int result = Integer.parseInt(su1) +Integer.parseInt(su2);

//결과를 저장 
request.setAttribute("result1",result);
session.setAttribute("result2",result);
application.setAttribute("result3",result);

//로그를 출력 
System.out.println("새로고침을 수행 할수 없습니다 . ");

//출력 페이지로 이동 - 리다이렉트 
response.sendRedirect("output.jsp");


%>

</body>
</html>