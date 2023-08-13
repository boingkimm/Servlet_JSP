package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetServlet");

		// 1. request scope에 값 조회 (HttpServletRequest)
		String x = (String)request.getAttribute("request");  //string으로 형변환
		
		// 2. session scope에 값 조회 (HttpSession)
		HttpSession session = request.getSession();
		String x2 = (String)session.getAttribute("session");
		
		
		// 3. application scope에 값 조회 (ServletContext)
		ServletContext ctx = getServletContext();
		String x3 = (String)ctx.getAttribute("application");
		
		System.out.println("request:" + x);
		System.out.println("session:" + x2);
		System.out.println("application:" + x3);
		
		// 여러 브라우저로 실습해보기 - 누가 언제 null값 되는지 확인해보기
		// Session있으면 무조건 모든 브라우저 닫고 실행
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
