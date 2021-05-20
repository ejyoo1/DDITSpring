package ejyoo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ejyoo.dto.MemberVO;
import ejyoo.exception.NotEnoughDataException;
import ejyoo.exception.NotEnoughResultException;
import ejyoo.exception.NullException;
import ejyoo.service.IMemberSystemService;
import ejyoo.service.MemberSystemServiceImpl;

@WebServlet("/member")
public class MemberSystemMemberServlet extends HttpServlet {
	private static final Logger EXCEPTION_LOGGER = Logger.getLogger(MemberSystemMemberServlet.class);
	private IMemberSystemService mssi = MemberSystemServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		String viewPage = "/WEB-INF/views/member.jsp";
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MemberVO member = null;
		String userId = request.getParameter("userId");
		
		String script = "";
		try {
			if(userId == "" || userId == null) {
				throw new NotEnoughDataException();
			}
			
			member = mssi.getMember(userId);
			if(member == null) {
				throw new NullException();
			}			
		} catch (NullException e) {
			script = "alert('회원 조회 중 알 수 없는 문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		} catch (SQLException e) {
			script = "alert('문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		} catch (NotEnoughDataException e) {
			script = "alert('조회할 회원이 없습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		}
		request.setAttribute("member", member);
		request.setAttribute("script", script);
		request.getRequestDispatcher(viewPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
