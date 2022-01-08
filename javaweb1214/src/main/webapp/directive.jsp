<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>directive - 지시자 </title>
</head>
<body>
<%@ page import ="java.util.*" %>
<!-- 공백제거  -->
<%@ trimDirectiveWhitespaces="true" %>
<!-- 자바코드 작성 1)캘린더는 유틸꺼라 에러남  -->
<%
Calendar cal = new GregorianCalendar();
%>
<!-- 자바로 만들 데이터를 출력  -->
<%= cal.toString() %>
</body>
</html>