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

import ejyoo.exception.NotEnoughDataException;
import ejyoo.service.IMemberSystemService;
import ejyoo.service.MemberSystemServiceImpl;
import ejyoo.vo.MemberDTO;

@WebServlet("/deleteMember")
public class MemberSystemDeleteMemberServlet extends HttpServlet {
	private static final Logger EXCEPTION_LOGGER = Logger.getLogger(MemberSystemInsertMemberServlet.class);
	IMemberSystemService mssi = MemberSystemServiceImpl.getInstance();   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("post");
		
		String script = "";
		try {
			String userNo = request.getParameter("userNo");
			
			if(userNo == "") {
				throw new NullPointerException();
			} else if(userNo == null) {
				throw new NullPointerException();
			}
			
			MemberDTO memberDto = new MemberDTO();
			memberDto.setUserNo(userNo);
		
			int cnt = mssi.deleteMember(memberDto);
			if(cnt == 1) {
				script = "success";
				
				request.setAttribute("script", script);
			}
		} catch (SQLException e) {
			script = "failed";
			
			EXCEPTION_LOGGER.error(e.getMessage());
			request.setAttribute("script", script);
			
		} catch (NullPointerException e) {
			script = "failed";
			
			EXCEPTION_LOGGER.error(e.getMessage());
			request.setAttribute("script", script);
		}

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/memberList.jsp");
		disp.forward(request, response);
	}
}
