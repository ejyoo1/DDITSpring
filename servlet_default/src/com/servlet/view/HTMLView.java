 package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class HTMLView {
	public static void html(HttpServletResponse response,
					String title, String body)
					throws IOException, ServletException {
		html(response, title, null, null, body);
	}
	
	public static void html(HttpServletResponse response,
					String script)
					throws IOException, ServletException {
		html(response, null, null, script, null);
	}
	
	public static void html(HttpServletResponse response,
					String title, String css, String script, String body) 
					throws IOException, ServletException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + title + "</title>");
		out.println("<style>" + css + "</style>");
		out.println("<script>" + script + "</script>");
		out.println("</head>");
		out.println("<body>" + body + "</body>");
		out.println("</html>");
	}
	
	public static void loginView(HttpServletResponse response) throws IOException, ServletException {
		String title = null;
		String body  = null;
		
		title = "로그인 화면";
		body = "<form action='/LoginServlet' method='post'>"
				+ "<input type='text' name='id' /><br/>"
				+ "<input type='text' name='pwd' /><br/>"
				+ "<input type='submit' value='로그인'"
				+ "</form>";
		html(response, title, null, null, body);
	}
}
