package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청처리
		System.out.println("MemberServlet.doGet");
		//http://localhost:8090/01_servlet/member?userid=&passwd=&
		//hobby=football&hobby=basketball   -- 파라미터 여러개 : getParameterValues로 배열로 얻어오기
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
		String [] hobbies = request.getParameterValues("hobby");
		
		System.out.println(userid+"\t"+passwd+"\t" + Arrays.toString(hobbies));
		
		
		//응답처리 ==> 브라우저에 값 출력
		response.setContentType("text/html;charset=utf-8");  //html + 한글 처리
		PrintWriter out = response.getWriter();  //import
		out.print("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");

		out.print("아이디: " + userid + "<br>");
		out.print("비번: " + passwd + "<br>");
		out.print("취미: " + Arrays.toString(hobbies) + "<br>");
	

		out.print("</body></html>");
		
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberServlet.doPost");
		//Post 한글처리
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
