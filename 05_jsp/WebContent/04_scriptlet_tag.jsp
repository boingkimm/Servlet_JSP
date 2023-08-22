<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
Scriptlet tag : <% 자바코드 %> 
 --%>

<% 
	//scriptlet tag	
	//doGet에서 했던 작업 모두 가능
	//위치 상관없음, 작성위치에 생성됨 : .java 파일 확인해보기
	
	int num = 0;
	if(num==0){
		System.out.println("num==0");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//scriptlet tag	
	int num2 = 0;
	for(int i=0; i<5; i++){
		System.out.println("hello");
	}
%>
</body>
</html>

<%--
05_jsp/Java Resources/src/org.apache.jsp/_04_005fscriptlet_005ftag_jsp
--%>