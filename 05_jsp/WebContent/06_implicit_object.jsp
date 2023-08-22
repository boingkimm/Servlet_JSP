<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
내장객체 : scriptlet tag 안에서만 사용 가능한 자동으로 추가되는 객체
변환된 .java파일의 _javaService 메서드 내에 항상 미리 선언되는 변수
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>내장객체(내장변수)</h2>
<%
	// scriptlet tag내에서 변수선언없이 사용가능한 변수
	
	System.out.println("HttpServletRequest request 내장객체" + request);  //주소값 출력됨
	System.out.println("HttpServletRequest response 내장객체" + response);
	System.out.println("HttpSession session 내장객체" + session);
	System.out.println("ServletContext application 내장객체" + application);
	System.out.println("ServletConfig config 내장객체" + config);
	System.out.println("PrintWriter out 내장객체" + out);
	
%>

</body>
</html>