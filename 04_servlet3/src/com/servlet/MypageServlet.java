package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.net.www.content.text.plain;

@WebServlet("/mypage")
public class MypageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//session얻기
		HttpSession session = request.getSession();
				
		//session에서 로그인정보 얻기 
		String id = (String)session.getAttribute("user");

		//응답처리
		 if( id != null ) {
			 //로그인하여 id값이 저장된 상태
			 response.setContentType("text/html;charset=utf-8");
			 PrintWriter out = response.getWriter();
			 out.print("<html><head>");
			 out.print("<meta charset=\"UTF-8\">");
			 out.print("<title>Insert title here</title>");
			 out.print("</head><body>");
			 out.print("<h1>mypage</h1>");
			 out.print("안녕하세요. " + id + "님 ");
			 out.print("<a href='logout'>로그아웃</>");
			 out.print("</body></html>");
			 
		 } else {
			 //id값이 null: 로그인을 안했거나, 했는데 타임아웃된 상태
			 response.sendRedirect("loginForm.jsp");  //로그인화면으로 redirect
		 }

		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
