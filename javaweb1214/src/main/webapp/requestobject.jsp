<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//접속한 컴퓨터의 IP
String ip = request.getRemoteAddr();
//컨텍스트 경로
String contextPath = request.getContextPath();
//전체 요청 경로 
String requestURI =request.getRequestURI();
//requestURI부분에서 contextPath를 제외한 부분 
//contextPath의 길이만큼을 제외하고 잘라내면 됩니다. 

//controller을 만들때 공통된 부분을 제외한 요청을 추출하는데 사용  
//마지막 /는 제거해도 되고 포함시켜도 됩니다. 
int length = contextPath.length();
String uri = requestURI.substring(length+1);

//분리하는거 꼭 알고 있어야함 ! 
String [] imsi = requestURI.split(contextPath.substring(1));
%>

//클라이언트 ip주소 알아야함 
<p> IP : <%=ip %></p>
<p> 컨텍스트 경로 :<%=contextPath %> </p>
<p> 전체요청  경로 :<%=requestURI %> </p>
<p> 전체요청 경로에서 컨텍스트 경로를 제외한 부분 : <%= uri %></p>
<p> 전체요청 경로에서 컨텍스트 경로를 제외한 부분 : <%= imsi[1] %></p>

</body>
</html>