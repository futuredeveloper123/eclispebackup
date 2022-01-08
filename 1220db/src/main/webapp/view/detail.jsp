<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

코드 : ${subject.code}<br/>
이름 : ${subject.title}<br/>
카테고리 : ${subject.category}<br/>
설명 : ${subject.description}<br/>


[<a href="../update/${subject.code}">수정하기 </a>]
[<a href="../delete/${subject.code}">삭제하기 </a>]



</body>
</html>