package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//web.xml - parameter 지정X.
public class ExamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ExamServlet");
		
		// ServletConfig의 getInitParameter(name) - 다른 서블릿에서 접근 불가
		String dir_path = getInitParameter("dir_path");
		String email = getInitParameter("email");
		System.out.println(dir_path+"\t"+email);  // null null 
		
		// ServletContext의 getInitParameter(name)
		ServletContext ctx = getServletContext();  //컨텍스트 얻기
	    String userid = ctx.getInitParameter("userid");
	    String passwd = ctx.getInitParameter("passwd");
	    System.out.println(userid+"\t"+passwd);  // asdf	1234 
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
