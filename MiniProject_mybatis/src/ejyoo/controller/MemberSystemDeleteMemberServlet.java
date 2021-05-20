package ejyoo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ejyoo.dto.MemberVO;
import ejyoo.exception.NotEnoughDataException;
import ejyoo.exception.NotEnoughResultException;
import ejyoo.service.IMemberSystemService;
import ejyoo.service.MemberSystemServiceImpl;

@WebServlet("/deleteMember")
public class MemberSystemDeleteMemberServlet extends HttpServlet {
	private static final Logger EXCEPTION_LOGGER = Logger.getLogger(MemberSystemInsertMemberServlet.class);
	private IMemberSystemService mssi = MemberSystemServiceImpl.getInstance();   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "/WEB-INF/views/result.jsp"; 
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userId = request.getParameter("userId");
		
		String script = "";
		try {
			if(userId == "" || userId == null) {
				throw new NotEnoughDataException();
			}
		
			int cnt = mssi.deleteMember(userId);
			if(cnt > 0) {
				script = "alert('회원이 삭제되었습니다.');"
						+ "location.href='memberList';";
			} else if(cnt == 0){
				throw new NotEnoughResultException();
			}
		} catch (SQLException e) {
			script = "alert('문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		} catch (NotEnoughDataException e) {
			script = "alert('삭제할 회원이 없습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		} catch (NotEnoughResultException e) {
			script = "alert('회원 삭제가 실패하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		}
		
		request.setAttribute("script", script);
		request.getRequestDispatcher(viewPage).forward(request, response);
	}
}
