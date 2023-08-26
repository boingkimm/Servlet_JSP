<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>url 태그</h2>
이전방식 상대경로: <a href="JSTLServlet">JSTLServlet</a><br>
이전방식 절대경로: <a href="/09_JSTL/JSTLServlet">JSTLServlet</a><br>
url태그 상대경로: <a href="<c:url value='JSTLServlet'/>">JSTLServlet</a><br>
url태그 절대경로: <a href="<c:url value='/JSTLServlet'/>">JSTLServlet</a> : 자동으로 context명 추가되므로 편리. 많이 사용됨*** <br>
</body>
</html>