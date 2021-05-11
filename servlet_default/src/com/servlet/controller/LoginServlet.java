package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIdException;
import com.servlet.service.MemberService;
import com.servlet.service.MemberServiceImpl;
import com.servlet.view.HTMLView;
import com.servlet.vo.MemberVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private MemberService memberService = new MemberServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/views/login.jsp";
		
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면에 대한 URL을 먼저 정해야 함. (잘 되었을 때 기준으로)
		String view = "/WEB-INF/views/login_success.jsp";
		
		// 입력
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 처리
		String script = "";
		// memService.login(id,pwd) : memberVO, InvaidPasswordException, NotFoundIDException, SQLException
		try {
			MemberVO member = memberService.login(id, pwd);
			
			script="alert('로그인 성공했습니다.');"
					+ "location.href='" + request.getContextPath() + "/main';";
			
		} catch (NotFoundIdException e) {
			script="alert('" + e.getMessage() + "');"
					+ "history.go(-1);";
		} catch (InvalidPasswordException e) {
			script="alert('" + e.getMessage() + "');"
					+ "location.href='login';";
		} catch (SQLException e) {
			script="alert('서버 장애로 인해 불가합니다.');"
					+ "history.go(-1);";
		}
		
		// 출력 
		//HTMLView.html(response, script);
		request.setAttribute("script", script);
		request.getRequestDispatcher(view).forward(request, response);
	}

}
