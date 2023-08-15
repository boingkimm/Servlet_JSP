package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class MyFilter implements Filter {

	public void destroy() {
		System.out.println("MyFilter.destroy");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("MyFilter.doFilter 전전전전");  //요청필터
		//POST방식의 한글처리를 요청필터로 처리
		request.setCharacterEncoding("utf-8");
		
		chain.doFilter(request, response);  //기준! 문자열이 언제 출력되는지 확인
		System.out.println("MyFilter.doFilter 후후후후");  //응답필터
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("MyFilter.init");

	}

}
