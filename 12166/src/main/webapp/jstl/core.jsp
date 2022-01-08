<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- jstl의 core기능을 사용하기 위한 설정  -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!--  정해진거라 못 바꾸니 까 반드시 이렇게 써줘야함  -->
    <%@ tablib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>core</title>
</head>
<body>
	<c:forEach var="num" begin="1" end="5">
	<p>안녕하세요 : ${num } </p>
	</c:forEach>
	
	<!-- 현재 날짜 및 시간을 갖는 데이터 생성  -->
	<c:set var="data" value="<%= new java.util.Date() %>" />
	
	<!--  로케일 설정  -->
	<fmt:setLocale value ="en_us">
	
	오늘 날짜 <fmt:formatDate value = "${date }" pattern = "yyyy=MM-dd(E) (a) hh:mm:ss"/> <br/>
	
	현재 금액 <fmtLformatNumber value ="${8800000} " type="currency"/>
	
	
	
</body>
</html>