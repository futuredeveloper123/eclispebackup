<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 파라미터 읽기 </title>
</head>
<body>
<%
//파라미터 인코딩 설정 - POST방식일 때만 하면 됩니다.
request.setCharacterEncoding("utf-8");


String name = request.getParameter("name");
String age = request.getParameter("age");
//중복가능한 체크박스 만들기 
//String hobby = request.getParameter("hobby");
//parameterValues를 이용해서 읽어야 함 
String []hobby = request.getParameterValues("hobby");

//동일한 이름 여러개 가지는 경우 
for(String h : hobby){
	out.println("<p>" + h + "</p>");
}

%>
<%= name %> </br>
<%= age %>  </br>
<%= java.util.Arrays.toString(hobby) %></br>

</body>
</html>