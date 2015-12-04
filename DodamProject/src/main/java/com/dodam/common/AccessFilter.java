package com.dodam.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class AccessFilter implements Filter {
//	ũ�ν� ������ ������ �ذ��ϱ����� Access����
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("AccessFilter Start");
		String origin = ((HttpServletRequest)request).getHeader("Origin");
		((HttpServletResponse)response).setHeader("Access-Control-Allow-Origin", "*");
		 ((HttpServletResponse) response).setHeader("Access-Control-Allow-Methods", "POST, GET");
		 ((HttpServletResponse) response).setHeader("Access-Control-Allow-Credentials", "true");
		 ((HttpServletResponse) response).setHeader("Access-Control-Allow-Headers", "origin, x-requested-with, content-type, accept");
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
