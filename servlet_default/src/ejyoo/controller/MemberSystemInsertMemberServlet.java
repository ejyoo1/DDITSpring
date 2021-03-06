package ejyoo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ejyoo.service.IMemberSystemService;
import ejyoo.service.MemberSystemServiceImpl;
import ejyoo.vo.MemberDTO;

@WebServlet("/insertMember")
public class MemberSystemInsertMemberServlet extends HttpServlet {
	private static final Logger EXCEPTION_LOGGER = Logger.getLogger(MemberSystemInsertMemberServlet.class);
	IMemberSystemService mmssi = MemberSystemServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/insertMember.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String script = "";
		try {
			String userId = request.getParameter("userId");
			System.out.println(userId);
			String userPw = request.getParameter("userPw");
			String userPhone = request.getParameter("userPhone");
			String userEmail = request.getParameter("userEmail");
			
			if(userId == "" || userPw == "" || userPhone == "" || userEmail == "") {
				throw new NullPointerException();
			} else if(userId == null || userPw == null || userPhone == null || userEmail == null) {
				throw new NullPointerException();
			}
			
			MemberDTO memberDto = new MemberDTO();
			memberDto.setUserId(userId);
			memberDto.setUserPw(userPw);
			memberDto.setUserPhone(userPhone);
			memberDto.setUserEmail(userEmail);
		
			int cnt = mmssi.insertMember(memberDto);
			if(cnt == 1) {
				script = "alert('??????????????? ??????????????? ?????????????????????.');"
						+ "location.href='main';";
				
				request.setAttribute("script", script);
			}
		} catch (SQLException e) {
			script = "alert('????????? ?????????????????????. ??????????????? ???????????? ?????????.');"
					+ "history.go(-1);";
			
			EXCEPTION_LOGGER.error(e.getMessage());
			request.setAttribute("script", script);
			
		} catch (NullPointerException e) {
			script = "alert('???????????? ???????????? ?????????.');"
					+ "history.go(-1);";
			
			EXCEPTION_LOGGER.error(e.getMessage());
			request.setAttribute("script", script);
		}
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/insertMember.jsp");
		disp.forward(request, response);
	}
}
