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
import ejyoo.exception.NullException;
import ejyoo.service.MemberService;

@WebServlet("/updateMember")
public class UpdateMemberServlet extends HttpServlet {
	private static final Logger EXCEPTION_LOGGER = Logger.getLogger(UpdateMemberServlet.class);
	private MemberService memberService
		= (MemberService) ApplicationContext.getApplicationContext().get("memberService");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "/WEB-INF/views/updateMember.jsp";
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MemberVO member = null;
		String userId = request.getParameter("userId");
		
		String script = "";
		try {
			if(userId == "" || userId == null) {
				throw new NotEnoughDataException();
			}
			
			member = memberService.getMemberById(userId);
			if(member == null) {
				throw new NullException();
			}			
		} catch (NullException e) {
			script = "alert('회원 수정 도중 알 수 없는 문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		} catch (SQLException e) {
			script = "alert('문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		} catch (NotEnoughDataException e) {
			script = "alert('수정할 회원이 없습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		}
		request.setAttribute("member", member);
		request.setAttribute("script", script);
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
			
			int cnt = memberService.updateMemberByInfo(member);
			if(cnt == 0) {
				throw new NotEnoughResultException();
			} else if(cnt > 0) {
				script = "alert('수정되었습니다.');"
						+ "location.href='memberList';";
			}
		} catch (SQLException e) {
			script = "alert('문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		} catch (NotEnoughDataException e) {
			script = "alert('입력값을 확인하여주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		} catch (NotEnoughResultException e) {
			script = "alert('회원 수정이 실패하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		}
		
		request.setAttribute("script", script);
		request.getRequestDispatcher(viewPage).forward(request, response);
	}

}
