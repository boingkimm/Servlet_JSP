package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 요청 URL : http://localhost:8090/01_servlet/test3
@WebServlet("/test3")
public class TestServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//요청처리

		
		//응답처리
		// 가. MIME 타입 지정
//		response.setContentType("text/plain");  //기본. 문자열로 출력
		response.setContentType("text/html;charset=utf-8");  //html + 한글 처리
		
		// 나. java I/O 얻기
		PrintWriter out = response.getWriter();  //import
		
		// 다. 출력
		out.print("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head><body>");

		out.print("<h1>Hello, 서블릿 실습~~~</h1>");

		out.print("</body></html>");
		 
	}

}
