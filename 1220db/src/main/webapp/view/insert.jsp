<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
</head>
<body>

<!--  이게 단순한 페이지 이동을 만드는 방법 ....  -->
<form action ="insert" method="post">
이름 : <input type = "text" name = "title"  required="required"/> <br/>

카테고리  : <select name = "category">
<option value="language" selected="selected">언어</option>
<option value="ide">통합개발도구 </option>
<option value="library">라이브러리 </option>
<option value="etc">기타 </option>
</select><br/>

설명  : <textarea name = "description" rows="10" cols="30"></textarea> <br/>

<!-- 전송 쉽게 받느는 법 submit -->
<input type="submit" value="삽입" />
</form>

</body>
</html>