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

@WebServlet("/updateMember")
public class MemberSystemUpdateMemberServlet extends HttpServlet {
	private static final Logger EXCEPTION_LOGGER = Logger.getLogger(MemberSystemUpdateMemberServlet.class);
	private IMemberSystemService mssi = MemberSystemServiceImpl.getInstance();
	
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
			
			member = mssi.getMember(userId);
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
		
		String userNo = request.getParameter("userNo");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		System.out.println(userNo+","+userId+","+userPw+","+userPhone+","+userEmail+",");
		
		String script = "";
		try {
			if(userNo == "" || userId == "" || userPw == "" || userPhone == "" || userEmail == "") {
				throw new NotEnoughDataException();
			} else if(userNo == null || userId == null || userPw == null || userPhone == null || userEmail == null) {
				throw new NotEnoughDataException();
			}
			MemberVO memberDto = new MemberVO();
			memberDto.setUserNo(userNo);
			memberDto.setUserId(userId);
			memberDto.setUserPw(userPw);
			memberDto.setUserPhone(userPhone);
			memberDto.setUserEmail(userEmail);
			
			int cnt = mssi.updateMember(memberDto);
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
