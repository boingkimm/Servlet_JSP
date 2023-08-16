package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.DeptDTO;
import com.service.DeptService;
import com.service.DeptServiceImpl;

@WebServlet("/write")   //부서등록 화면의 입력값 받아서 저장하는 서블릿
public class DeptWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");

		DeptDTO dto = new DeptDTO(Integer.parseInt(deptno), dname, loc);
		
		//서비스 연동
		DeptService service = new DeptServiceImpl();
		int n  = service.addDept(dto);
		
		//응답처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head><body>");
		
		if(n==1) {
			out.print("부서등록 성공 ");
			out.print("<a href='list'>목록보기</a>");  //등록된 부서 추가하여 출력됨
		}else {
			out.print("부서등록 실패 ");   //TODO 언제 실패?
			out.print("<a href='deptForm.jsp'>부서등록</a>");	 
		}

	
		out.print("</body></html>");

		
	}
	//http://localhost:8090/03_servlet/deptForm.jsp
	//http://localhost:8090/03_servlet/write
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //TODO 핕터로 변경하기
		doGet(request, response);
	}

}
