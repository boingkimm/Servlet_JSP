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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//session얻기
		HttpSession session = request.getSession();
				
		//session에서 로그인정보 얻기 
		String id = (String)session.getAttribute("user");

		//응답처리
		 if( id != null ) {
			 //로그인하여 id값이 저장된 상태
			 session.invalidate(); //세션 제거
			 response.sendRedirect("loginForm.jsp");  //로그아웃 이후의 화면
		 } else {
			 //id값이 null: 로그인을 안했거나, 했는데 타임아웃된 상태
			 response.sendRedirect("loginForm.jsp");  //로그인화면으로 redirect
		 }

		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
