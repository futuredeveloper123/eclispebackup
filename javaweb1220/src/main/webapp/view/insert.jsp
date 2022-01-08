<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post">
		이름:<input type="text" name="title" required="required" />
		<br/>
		카테고리:<select name="category">
			<option value="language" selected="selected">언어</option>
			<option value="ide">통합개발도구</option>
			<option value="library">라이브러리</option>
			<option value="etc">기타</option>
		</select>
		<br/>
		설명:<textarea name="description" rows="10" cols="30"></textarea>
		<br/>
		<input type="submit" value="삽입" />
	</form>
</body>
</html>