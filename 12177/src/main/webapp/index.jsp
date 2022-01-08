<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main page</title>
</head>
<body>
<p>welcome</p>
<!--  링크니까 get 방식 -->
<a href= "insert.do">데이터 삽입 </a></br>
<a href= "logout.do">logout </a></br>

</body>
<script>
window.addEventListener("beforeunload",function(e){
	
	//alert("call before browser close")
	//ajax 요청으로 logout을 수행 
	var request = new XMLGttpRequest()
	request.open("GET","logout.do")
	request.send('')
})
</script>


</html>