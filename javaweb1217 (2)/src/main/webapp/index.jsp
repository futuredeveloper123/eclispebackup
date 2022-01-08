<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<p>저의 웹 사이트에 방문하신것을 환영합니다.</p>
	<!-- 1. -->
	<a href="insert.do">데이터 삽입</a><br />
	<!-- 2 -->
	<a href="logout.do">로그아웃</a><br />
</body>
<script>
	window.addEventListener("beforeunload", function(e){
		//ajax 요청으로 logout을 수행
		var request = new XMLHttpRequest()
		request.open("GET", "logout.do")
		request.send('')
	})
</script>
</html>