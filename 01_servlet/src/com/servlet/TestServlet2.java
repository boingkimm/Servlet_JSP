package com.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 요청 URL : http://localhost:8090/01_servlet/test2
@WebServlet("/test2")
public class TestServlet2 extends HttpServlet {

	//인스턴스 변수 : 공유가 가능
	int num;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//로컬 변수 : 나 혼자 사용 가능
		int num2 = 0;
		
		num++;
		num2++;
		
		System.out.println("thread-unsafe: " + num);  //공유가 됨. 처음요청인데도 2
		System.out.println("thread-safe: " + num2);   //
	}

}
