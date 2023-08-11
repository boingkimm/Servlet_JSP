package com.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.collections.MappingChange.Map;

// 요청 URL : http://localhost:8090/01_servlet/login
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		System.out.println("LoginServlet.doGet");
		
		// 사용자 입력 데이터 얻기
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String xxx = request.getParameter("addr");  //없는 값: null
		
		System.out.println(userid+"\t"+passwd);
		System.out.println("################################");
		
		//Enumeration<String> getParameterNames : tag의 name값 얻기
		Enumeration<String> enu = request.getParameterNames();
		while(enu.hasMoreElements ()){
			System.out.println(enu.nextElement());
			
			String name = enu.nextElement();  // tag name얻기 - userid
			String value = request.getParameter("name"); //사용자 입력값 얻기
			
			System.out.println(name+"\t"+value);
			}
		System.out.println("################################");
		
		//Map<String,String[]> getParameterMap()  : <name값, value값>
		java.util.Map<String, String[]> map = request.getParameterMap();
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key);
			String [] values = map.get(key);
			System.out.println(key+"\t"+Arrays.toString(values));
			
			
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		System.out.println("LoginServlet.doPost");
		// POST 한글처리
		request.setCharacterEncoding("utf-8");

		// 사용자 입력 데이터 얻기
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String xxx = request.getParameter("addr");  //없는 값: null
		
		System.out.println(userid+"\t"+passwd);
		
	}

}
