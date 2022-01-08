<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>process</title>
<%

request.setCharacterEncoding("utf-8"); //파라미터 인코딩 처리하기  
//파라미터 읽기 >> 파라미터는 기본적으로 문자열로 처리 String
String num1 = request.getParameter("num1");
String num2 = request.getParameter("num2");

//처리 
//2개의 데이터를 더해서 결과를 생성 
int result = Integer.parseInt(num1) + Integer.parseInt(num2);

//전달할 결과를 저장>>포워딩이니까 리퀘스트에 저장하면 됨 
request.setAttribute("result", result );

//결과 페이지로 이동 
RequestDispatcher dispatcher = request.getRequestDispatcher("response.jsp");
dispatcher.forward(request, response);

%>
</head>
<body>

</body>
</html>