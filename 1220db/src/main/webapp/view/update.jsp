<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>


<!--  이게 단순한 페이지 이동을 만드는 방법 ....  -->
<form  method="post">
코드 : <input type = "text" name = "code" value="${subject.code }" readonly="readonly" /><br/>
이름 : <input type = "text" name = "title"  value="${subject.title }" required="required" /> <br/>
카테고리  : <select name = "category">
<option value="language" <c:out value="${subject.category=='language'?'selected':''}"/>>언어</option>
<option value="	ide" <c:out value="${subject.category=='ide'?'selected':''}"/> >통합개발도구 </option>
<option value="library" <c:out value="${subject.category=='library'?'selected':''}"/> >라이브러리 </option>
<option value="etc" <c:out value="${subject.category=='etc'?'selected':''}"/> >기타 </option>
</select><br/>

설명  : <textarea name = "description" rows="10" cols="30">${subject.description}</textarea> <br/>

<!-- 전송 쉽게 받느는 법 submit -->
<input type="submit" value="삽입" />
</form>

</body>
</html>

