<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>output</title>
</head>
<body>
<%

	int result = ( Integer )request.getAttribute("result");
	out.println("result:" + result );
	
%>

</body>
</html>