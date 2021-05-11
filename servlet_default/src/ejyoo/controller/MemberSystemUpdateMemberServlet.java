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

import ejyoo.exception.NotEnoughDataException;
import ejyoo.exception.NullNOException;
import ejyoo.service.IMemberSystemService;
import ejyoo.service.MemberSystemServiceImpl;
import ejyoo.vo.MemberDTO;

@WebServlet("/updateMember")
public class MemberSystemUpdateMemberServlet extends HttpServlet {
	private static final Logger EXCEPTION_LOGGER = Logger.getLogger(MemberSystemUpdateMemberServlet.class);
	IMemberSystemService mssi = MemberSystemServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String script = "";
		MemberDTO memberDto = new MemberDTO();
		List<MemberDTO> memberList = null;
		
		try {
			String userNo = request.getParameter("userNo");
			System.out.println(userNo);
			
			if(userNo == null) {
				throw new NullNOException();
			}
			
			memberDto.setUserNo(userNo);
			
			memberList = mssi.getMemberList(memberDto);
			if(memberList.size() != 1) {
				throw new NotEnoughDataException();
			} else if (memberList.size() == 0) {
				throw new NotEnoughDataException();
			}
			
		} catch (NullNOException e) {
			script = "alert('문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			
			EXCEPTION_LOGGER.error(e.getMessage());
			request.setAttribute("script", script);
		} catch (SQLException e) {
			script = "alert('문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			
			EXCEPTION_LOGGER.error(e.getMessage());
			request.setAttribute("script", script);
		} catch (NotEnoughDataException e) {
			script = "alert('문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			
			EXCEPTION_LOGGER.error(e.getMessage());
			request.setAttribute("script", script);
		}
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/update.jsp");
		request.setAttribute("memberList", memberList);
		
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		MemberDTO memberDto = new MemberDTO();
		int cnt = 0;
		String script = "";
		
		try {
			String userNo = request.getParameter("userNo");
			String userId = request.getParameter("userId");
			String userPw = request.getParameter("userPw");
			String userPhone = request.getParameter("userPhone");
			String userEmail = request.getParameter("userEmail");
			
			if(userNo == "" || userId == "" || userPw == "" || userPhone == "" || userEmail == "") {
				throw new NullPointerException();
			} else if(userNo == null || userId == null || userPw == null || userPhone == null || userEmail == null) {
				throw new NullPointerException();
			}
			memberDto.setUserNo(userNo);
			memberDto.setUserId(userId);
			memberDto.setUserPw(userPw);
			memberDto.setUserPhone(userPhone);
			memberDto.setUserEmail(userEmail);
			
			cnt = mssi.updateMember(memberDto);
			if(cnt == 0) {
				throw new NotEnoughDataException();
			} else if(cnt > 0) {
				script = "alert('수정되었습니다.');"
						+ "location.href='memberList';";
				
				request.setAttribute("script", script);
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/memberList.jsp");
				disp.forward(request, response);
			}
		} catch (NullPointerException e) {
			script = "alert('문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			
			EXCEPTION_LOGGER.error(e.getMessage());
			request.setAttribute("script", script);
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/update.jsp");
			disp.forward(request, response);
		} catch (SQLException e) {
			script = "alert('문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			
			EXCEPTION_LOGGER.error(e.getMessage());
			request.setAttribute("script", script);
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/update.jsp");
			disp.forward(request, response);
		} catch (NotEnoughDataException e) {
			script = "alert('문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			
			EXCEPTION_LOGGER.error(e.getMessage());
			request.setAttribute("script", script);
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/update.jsp");
			disp.forward(request, response);
		}
	}

}
