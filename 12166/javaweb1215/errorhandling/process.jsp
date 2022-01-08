<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 에러가 발생했을 보여질 페이지를 설정 -->
<%@ page errorPage="errordisplay.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처리</title>
</head>
<body>
	<%
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");
		
		//정수로 변경해서 나눗셈 하기
		int result = 
			Integer.parseInt(su1) / Integer.parseInt(su2);
		//결과를 저장
		request.setAttribute("result", result);
		//결과를 출력할 페이지로 포워딩
		RequestDispatcher dispatcher = 
			request.getRequestDispatcher("output.jsp");
		dispatcher.forward(request, response);
		
		
	
	%>
</body>
</html>