<%@page import="java.util.List"%>
<%@page import="com.dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>scope에 저장된 값 출력</h1>
<h2>1. jsp tag 방식</h2>
<% 
	String userid = (String)request.getAttribute("userid");
	String xxx = (String)request.getAttribute("xxx");
	
	String userid2 = (String)session.getAttribute("userid");
	String userid3 = (String)application.getAttribute("userid");
	
	//DTO얻기
	LoginDTO dto = (LoginDTO)request.getAttribute("login");
	
	//list얻기
	List<LoginDTO> list = (List<LoginDTO>)request.getAttribute("list"); 
%> 
이름: <%= userid %><br>
null값: <%= xxx %><br>
null여부: <%= xxx == null %><br>
---<br>
request: <%= userid %><br>
session: <%= userid2 %><br>
application: <%= userid3 %><br>
---<br>
아이디: <%= dto.getUserid() %><br>
비밀번호: <%= dto.getPasswd() %><br>
---<br>
list1: <%= list.get(0).getUserid() %><%= list.get(0).getPasswd() %><br>
list2: <%= list.get(1).getUserid() %><%= list.get(1).getPasswd() %><br>

<h2>2. EL tag 방식</h2>
<% 
String kkk = "이순신";
%>
이름: ${userid}<br>
이름: ${kkk}<br> 
null값: ${xxx}<br>
null여부: ${empty xxx}<br>

-- 기본은 request scope에서 가져옴<br>
request: ${userid}<br>
session: ${userid}<br>
application: ${userid}<br>

-- 다른 scope에서 가져오려면 명시해주기<br>
request: ${requestScope.userid}<br>
session: ${sessionScope.userid}<br>
application: ${applicationScope.userid}<br>
-- DTO를 EL로 출력하기<br>
아이디: ${login.userid}<br>
비밀번호: ${login.passwd}<br>
-- list를 EL로 출력하기<br>
list1: ${list[0].userid} ${list[0].passwd}<br>
list2: ${list[1].userid} ${list[1].passwd}<br>
</body>
</html>

<!-- 
kkk: 서블릿의 scope에 저장하지 않은 값. EL사용 불가 => 빈칸출력
xxx: null값이지만 "null"출력되지 않음. 비어있는 값으로 처리 => NullPointException 발생 안함
 -->
 