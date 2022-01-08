<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert 데이터 삽입 </title>
</head>
<body>
<!--웹에서는 이동하는 url잇지만 모바일에서는 url없음 
동일한 요청은 하나의 url로 처리해야함 !!!!! rest api
디바이스가 다르면 서버도 달라야 한다고 배웠지만
다 따로따로 처리해야한다고 해서 굉장힘 힘들었음 
미국은 si구조가 별로 없음 ,,프로젝트 경력을 봄  -->
	<form action="insert.do " method="post">
		이름 : <input type="text" name="name"/>
		<input type = "submit" value="삽입"/>
		<br/>
	</form>

</body>
</html>