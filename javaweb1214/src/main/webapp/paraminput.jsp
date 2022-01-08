<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 파라미터 입력 </title>
</head>
<body>

	<form action = "paramoutput.jsp">
	 	이름 <input type="text" name="name"/>
	 	나이 <input type="text" name="age"/>
	 	
	 	<fieldset><legend>취미 </legend>
		
		<input type="checkbox" name="hobby" value="sport">스포츠
		<input type="checkbox" name="hobby" value="reading">독서 
		<input type="checkbox" name="hobby" value="game">게임 
		 
		</fieldset>
	
		<input type="submit" value="전송"/>
	</form>

<%
//java 에서 초기화 파라미터 읽기 
String user = application.getInitParameter("name");
out.println("초기화 파라미터 : " +user);

//web 디렉토리 안에 있는 sample 디렉토리의 절대 경로를 가져오기  
//파일 업로드를 할 때 절대 경로를 사용합니다 .  

String path = application.getRealPath("./sample");
out.println("<br/"+path);

%>
</body>
</html>