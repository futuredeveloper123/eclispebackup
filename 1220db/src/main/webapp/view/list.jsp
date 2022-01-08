<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>data</title>
<style>
a{
text-decoration : none;
}
table{

}
</style>
</head>
<body>

   <table border="1" id="table">
      <tr>
         <th>코드</th>
         <th>카테고리</th>
         <th>프로그램</th>
 	 </tr>
   </table>


</body>
<script>
//페이지번호를 저장할 변수 
var pageno=1 

//데이터를 가져와서 출력하는 함수를 생성 
var adddata = function(){
	//ajax 객체를 생성 
	var request = new XMLHttpRequest();
	//요청을 생성 - pageno라는 파라미터 값과 같이 생성 
	request.open("GET","getlist?pageno=" + pageno);
	//요청을 전송  
	request.send('');	
	//콜백함수 등록 
	request.onreadystatechange = function() {
		if(request.readyState == 4){
			//요청을 전송하고 응답이 오면 
			if(request.status >= 200 && request.status <300){
				//응답 가져오기 - XML이 아닌 경우 
				var text = request.responseText;
				//alert(text);
				//json parsing
				//여기서 실패하면 서버에서 ㅓ내ㅜ데이터 형식을 잘못 만든경우 
				var data = JSON.parse(text);
				/*
				//object이므로 속성 확인 -ar에 데이터 존재 
				for(var attr in data){
					alert(attr);
				}*/
				//기존의 더보기가 있으면 삭제 !!!!!! 더보기란 없어지고 새롭게 계속 생김 
				//맨마지막줄 출력하면 더보기 없어짐 !!!!!! $$$ (이거 스크롤에 응용하기 !!!!!! )
				var element = document.getElementById('add');
				if(element != null){
					element.parentNode.removeChild(element);
				}
				//배열을 순회 
				for(var idx=0; idx<data.list.length; idx=idx+1){
					//idx번째 데이터를 가져오기 
					var subject = data.list[idx];
					//alert(subject)
					
					//출력문 생성 //코드 출력란  만들기 
					var disp = "<tr><td align='right'>"+subject.code+"</td>";
					
					disp += "<td align='left'>&nbsp;"+"<a href = 'detail/"+subject.code+"'>"+subject.title+"</a></td>";
					
					disp += "<td align='left'>&nbsp;"+subject.description+"</td></tr>";
					//테이블 안에 출력 
					document.getElementById('table').innerHTML += disp;
					
				}
				//더보기 생성 (현재페이지번호와 페이지 개수가 다르다면 )
				if(data.pageno != data.endpage){
					//테이블에 더보기란 만드는중 
					var disp = "<tr id='add'><td colspan='3' align='center'>"
					//손가락 마우스 처럼 만들기 ,,굳이 안 해도 됨 
					disp+= "<a href='#'>더보기</a>" + "</td></tr>";
					document.getElementById("table").innerHTML +=disp;
					pageno = pageno+1;
					// 이벤트걸기 
					document.getElementById('add').addEventListener('click',function(e){ adddata(); })
				}//여기서 문제가 맨윗칸 더보기를 눌러야지 작업됨 
				//이제 지우는 작업 (위로 올라가서 ,,,더보기 삭제 코드 ㅇㅇ )
				
			}else{//요청에 대한 응답 실패 
				alert("응답실패:"+request.status);
			}
		}
	}
}
//이 파일이 메모리에 로드되자 마자 adddata라는 함수를 호출하도록 작업 
window.addEventListener("load",function(e){
	adddata();
});

</script>
</html>