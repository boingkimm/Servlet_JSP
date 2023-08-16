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

@WebServlet("/retrieve")   //클릭한 데이터 
public class DeptRetrieveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String deptno = request.getParameter("deptno");

		DeptService service = new DeptServiceImpl();
		DeptDTO dto = service.findByDeptno(Integer.parseInt(deptno));
		
		//응답처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head><body>");
		
		out.print("<h1>클릭한 데이터</h1>");
		
		out.print("<form action='update' method='get'>");
		
		out.print("부서번호:"+dto.getDeptno()+"<br>");
		out.print("<input type='hidden' name='deptno' value='"+dto.getDeptno()+"'>");  //update에 부서번호도 같이 넘겨주기 위해 히든태그
		out.print("부서명:<input type='text' name='dname' value='"+dto.getDname()+"'><br>"); //수정가능
		out.print("부서위치:<input type ='text' name='loc' value='"+dto.getLoc()+"'><br>");
//		out.print("부서명:"+dto.getDname()+"<br>");  //수정불가
//		out.print("부서위치:"+dto.getLoc()+"<br>");

		out.print("<input type='submit' value='수정'>");
		out.print("</form>");
		
		//삭제 링크
		out.print("<a href='delete?deptno="+dto.getDeptno()+"'>삭제</a>");	
		out.print("<hr>");

		//TODO 삭제 버튼으로 만들기, 목록으로 돌아가기 추가 완료
		
		out.print("<form action='delete' method='get'>");
		out.print("<input type='hidden' name='deptno' value='"+dto.getDeptno()+"'>");
		out.print("<input type='submit' value='삭제'>");
		out.print("</form>");
		
		out.print("<form action='list' method='get'>");
		out.print("<input type='submit' value='목록으로 돌아가기'>");
		out.print("</form>");
//		out.print("<a href='list'>목록으로 돌아가기</a>");
		out.print("</body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //TODO 핕터로 변경하기
		doGet(request, response);
	}

}
