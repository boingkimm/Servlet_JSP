<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
declaration tag : <%! 자바선언문  %>
- 서블릿의 멤버변수, 멤버메서드를 선언
- 거의 사용 안함
- 위치 상관없음
--%>

<%!
	int num = 10;
	public void a(){}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
	int num2 = 10;
	public void a2(){}
%>

</body>
</html>

<%-- 
변환된 .java를 확인해보기 (tomcat/work)
"C:/servlet_study/apache-tomcat-9.0.78/work/
Catalina/localhost/05_jsp/org/apache/jsp/
_03_005fdeclaration_005ftag_jsp.java"

=>이클립스에 가져왔음
05_jsp/Java Resources/src/org.apache.jsp
--%>