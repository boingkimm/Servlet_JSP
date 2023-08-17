package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//요청 서블릿 (요청위임함)
//http://localhost:8090/04_servlet/main
@WebServlet("/main")
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MainServlet");
		
		//요청위임1 - 포워드(forward)
		//가. url변경안됨 - 하나의 request가 확장
		
		//나. scope에 저장
		request.setAttribute("request", "request");        //request scope
		
		HttpSession session = request.getSession();        //session scope
		session.setAttribute("session", "session");
		
		ServletContext applicaton = getServletContext();   //application scope
		applicaton.setAttribute("applicaton", "applicaton");
		
		
		//forward
		request.getRequestDispatcher("response").forward(request, response);  //main에 요청시 response가 응답함
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
