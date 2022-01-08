<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>  응답 페이지 </title>
</head>
<body>
<%
//처리한 곳에서 넘겨준 데이터 가져오기 >> 정수를 처리하려했더니 에러남 
//꺼낼때 형변환을 해줘야함)
int data = (Integer)request.getAttribute("result");
//out객체를 이용한 출력 
out.println("<p> "+ data +"</result>");


%>

<!--  스크립트릿을 이용한 출력  -->
<p> <%= data %></p>
<!-- el을 이용한 출력  -->
<p> ${result}</p>

<!-- el을 이용한 파라미터 출력  -->
<p>${param.num1}</p>

<!-- el을 이용한 초기화 파라미터 출력 -->
<p>${initParam.Database}</p>

<!-- 다른 객체의 속성 가져오기  -->
<p>${pageContext.request.requestURI}</p>

<p>${pageContext.request.remoteAddr}</p>

</body>
</html>