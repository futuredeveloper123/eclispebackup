<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 쿠키를 이용한 아이디 저장 및 사용  </title>
</head>
<body>

	<form action="login.jsp" id="loginform">
	아이디	
	<%
	//쿠키의 존재 여부를 확인하기 위한 변수 
	boolean flag = false;
	//모든 쿠키를 가져오기 
	Cookie [] cookies = request.getCookies();
	//기본식은 항상 쿠키 읽을 때 똑같음 ! 
	//널이 아니고 렝스가 영보다 크면 
	if(cookies !=null && cookies.length>0 ){
		//아이디에 저장해 놨으니까 
		for(Cookie cookie : cookies){
			//아이디라는쿠키가 존재하면
			if(cookie.getName().equals("id")){
				//출력 //value = ' "+cookie.getValue()+" '
				out.println("<input type = 'text' id = 'id' value='"+cookie.getValue()+"'/><br/>");
				
				//html은 큰다옴표작은다옴표 상관없으니카 큰다옴표를 작은다옴표로 바가주기 
				out.println("<input type='checkbox' id='idsave' value ='check' checked='checked'/> 아이디저장 <br/>");
				
				
				//아이디가 있었다면 더이상 비교할 필요가 없어 ! break
				flag = true;
				break;
			}
		}
	}
	if(flag==false){
		out.pritln("<input type = 'text' id = 'id' name='id' /><br/>");
		out.println("<input type='checkbox' id='idsave' value ='check'/> 아이디저장 <br/>");
		
	}
	//서버읽어서 클라이언트페이지를 바꿀 수 있음 
	//쿠키가 뭐고 쿠키를 뭐 할때 써야하는 지 잘 기억해 두기 
	//전처럼 메인만들어서 실행시켜보고 하는게 아니라서 
	//개념을 알지 못하면 코드 줘봐야 아무 필요가 없음 ,,!!!
	%>
	<input type="submit" value="로그인"/> 


</form>
</body>
</html>