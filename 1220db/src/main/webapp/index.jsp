<%@page import="util.CryptoUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connect data base</title>
</head>
<body>

	<!-- 요청을 생성 !!!!  -->

	<!-- 1 -->
	<a href="connect"> 데이터베이스 연결 </a>
	<br />
	<!-- 2 -->
	<a href="subject/list"> 전체 데이터 가져오기 </a>
	<br />
	<!-- 3 -->
	<a href="subject/insert"> 데이터 삽입 </a>
	<br />
	<%@ page import="org.mindrot.jbcrypt.BCrypt"%>
	<%
	//복호화가 불가능하도록 암호화 
	String pw = "1234";
	//비문 생성 -동일한 데이터가지고 해도 다른 결과 
	String secretpw = BCrypt.hashpw(pw, BCrypt.gensalt(10));
	out.println("변경된 문장:" + secretpw + "</br>");

	secretpw = BCrypt.hashpw(pw, BCrypt.gensalt(10));
	out.println("변경된 문장:" + secretpw + "</br>");

	//비교는 가능checkpw
	out.println("비교 :" + BCrypt.checkpw(pw, secretpw) + "</br>");
	out.println("비교 :" + BCrypt.checkpw("da", secretpw) + "</br>");

	//복호화가 가능하도록 암호화 
	util.CryptoUtil cryptoUtil = new CryptoUtil();
	String email = "da@naver.com";
	//동일한 데이터로 두번수행하면 결과는 같습 니다 .
	String secretemail = cryptoUtil.encrypt(email);
	out.println("변경된 문장:" + secretemail + "</br>");
	secretemail = cryptoUtil.encrypt(email);
	out.println("변경된 문장:" + secretemail + "</br>");

	//복호화 하기 
	String original = cryptoUtil.decrypt(secretemail);
	out.println("복원된 문장:" + original + "</br>");

	//랜덤한 문자열 생성하기 유효아이디 
	String randomString = java.util.UUID.randomUUID().toString();
	out.println("랜덤한문자열 :" + randomString + "</br>");
	%>
	<!-- 복호화는 메소드가 없음  -->
</body>
</html>