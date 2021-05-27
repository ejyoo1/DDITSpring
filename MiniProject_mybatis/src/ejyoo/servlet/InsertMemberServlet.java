package ejyoo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ejyoo.context.ApplicationContext;
import ejyoo.dto.MemberVO;
import ejyoo.exception.NotEnoughDataException;
import ejyoo.exception.NotEnoughResultException;
import ejyoo.service.MemberService;

@WebServlet("/insertMember")
public class InsertMemberServlet extends HttpServlet {
	private static final Logger EXCEPTION_LOGGER = Logger.getLogger(InsertMemberServlet.class);
	private MemberService memberService
		= (MemberService) ApplicationContext.getApplicationContext().get("memberService");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "/WEB-INF/views/insertMember.jsp"; 
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		request.getRequestDispatcher(viewPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "/WEB-INF/views/result.jsp"; 
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id 		  = request.getParameter("id");
	 	String pwd        = request.getParameter("pwd");
	 	String email      = request.getParameter("email");
	 	String picture    = request.getParameter("picture");
	 	int enabled    = Integer.parseInt(request.getParameter("enabled"));
	 	String regdate    = request.getParameter("regdate");
	 	String phone      = request.getParameter("phone");
	 	String name       = request.getParameter("name");
	 	String register   = request.getParameter("register");
	 	String address    = request.getParameter("address");
	 	String authority  = request.getParameter("authority");
		
		String script = "";
		try {
			if(id == "" 
				|| pwd == "" 
				|| email == "" 
				|| picture == ""
				|| enabled == 0
				|| regdate == ""
				|| phone == ""
				|| name == ""
				|| register == ""
				|| address == ""
				|| authority == ""
			) {
				throw new NotEnoughDataException();
			} else if (id == null
					|| pwd == null 
					|| email == null 
					|| picture == null
					|| regdate == null
					|| phone == null
					|| name == null
					|| register == null
					|| address == null
					|| authority == null
				) {
				throw new NotEnoughDataException();
			}
			
			MemberVO member = new MemberVO();
			
			member.setId(id);
		 	member.setPwd(pwd);
		 	member.setEmail(email);
		 	member.setPicture(picture);
		 	member.setEnabled(enabled);
		 	member.setRegdate(regdate);
		 	member.setPhone(phone);
		 	member.setName(name);
		 	member.setRegister(register);
		 	member.setAddress(address);
		 	member.setAuthority(authority);
			
		
			int cnt = memberService.insertMemberByInfo(member);
			if(cnt == 1) {
				script = "alert('회원가입이 정상적으로 이루어졌습니다.');"
						+ "location.href='memberList';";
			} else {
				throw new NotEnoughResultException();
			}
		} catch (SQLException e) {
			script = "alert('문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		} catch (NotEnoughDataException e) {
			script = "alert('입력값을 확인하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		} catch (NotEnoughResultException e) {
			script = "alert('회원 등록이 실패하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		}
		
		request.setAttribute("script", script);
		request.getRequestDispatcher(viewPage).forward(request, response);
	}
}
