<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!--  jstl의 format 기능을 사용하기 위한 설정  -->
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <!-- 대표하는 이름을 등록  -->
    <fmt:setBundle basename="intro" />
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 지역화  </title>
</head>
<body>

<fmt:message key="title"/>

</body>
</html>