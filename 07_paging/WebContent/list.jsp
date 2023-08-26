<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dto.PageDTO"%>
<%@page import="com.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판 목록</h2>
<%
	PageDTO pageDTO = (PageDTO)request.getAttribute("pageDTO");

	//PageDTO에 저장된 4가지 데이더 중 List 얻고 출력하기 - 게시판 목록(3개)
	List<BoardDTO> list = pageDTO.getList();
	
	//페이지 번호를 만들 정보 - 3가지
	int perPage = pageDTO.getPerPage();
	int curPage = pageDTO.getCurPage();
	int totalCount = pageDTO.getTotalCount();
	
	int totalNum = totalCount/perPage;
	if(totalCount%perPage != 0)totalNum++;
%>

<%
	// 목록 보여주기
	for(BoardDTO dto: list){
		int num = dto.getNum();
		String title = dto.getTitle();
%>
		<%= num %>. <%= title %><br>
<%
	}//end for
%>
<hr>
	<%
		// 페이지 번호 보여주기
		for (int i = 1; i < totalNum; i++) {
			if (curPage == i) {
		%>
		<%=i%>
		<%
			} else {
		%>
		<a href="list?curPage=<%=i%>"><%=i%></a>
		<%
			} //end if
		%>
	<%
		} //end for
	%>
</body>
</html>