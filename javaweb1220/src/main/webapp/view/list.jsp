<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 반복문을 사용하기 위해서 JSTL 의 CORE 기능 설정 -->
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 목록 보기</title>
</head>
<body>
	<table align="center" border="1">
		<tr>
			<th>코드</th>
			<th>카테고리</th>
			<th>프로그램</th>
		</tr>
		<c:forEach var="subject" items="${list}">
			<tr>
				<td>${subject.code}</td>
				<td>${subject.category}</td>
				<td><a href="detail?code=${subject.code}">${subject.title}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>