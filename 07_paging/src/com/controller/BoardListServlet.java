package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.PageDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청처리
		String curPage = request.getParameter("curPage");
		// 맨 처음 요청시는 curPage = null. 따라서 null인 경우 1로 초기화
		if (curPage==null) {
			curPage="1";
		}
		
		//서비스 연동
		BoardService service = new BoardServiceImpl();
		PageDTO pageDTO = service.list(Integer.parseInt(curPage));
		
		//scope에 저장
		request.setAttribute("pageDTO", pageDTO);
		
		//요청 위임
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
