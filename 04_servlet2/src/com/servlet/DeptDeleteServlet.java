package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.DeptService;
import com.service.DeptServiceImpl;

@WebServlet("/delete")
public class DeptDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String deptno = request.getParameter("deptno");
		
		//서비스에 넘겨주기 (서비스의 deleteDept호출)
		DeptService service = new DeptServiceImpl();
		int n = service.deleteDept(Integer.parseInt(deptno));
		
		//redirect 
		if(n==1) {
			response.sendRedirect("list");
		}else {
			response.sendRedirect("retrieve?deptno="+deptno);
		}
		
		//응답처리
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print("<html><head>");
//		out.print("<meta charset=\"UTF-8\">");
//		out.print("<title>Insert title here</title>");
//		out.print("</head><body>");
//		
//		if(n==1) {
//			out.print("부서삭제 성공 ");
//			out.print("<a href='list'>목록보기</a>");
//		}else {
//			out.print("부서삭제 실패 ");
//			out.print("<a href='retrieve?deptno="+deptno+"'>부서정보</a>");
//		}
//		out.print("</body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //TODO 핕터로 변경하기
		doGet(request, response);
	}

}
