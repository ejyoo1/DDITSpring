package ejyoo.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ejyoo.context.ApplicationContext;
import ejyoo.dto.MemberVO;
import ejyoo.exception.NullException;
import ejyoo.service.MemberService;

@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {
	private static final Logger EXCEPTION_LOGGER = Logger.getLogger(MemberListServlet.class);
	private MemberService memberService
		= (MemberService) ApplicationContext.getApplicationContext().get("memberService");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "/WEB-INF/views/memberList.jsp";
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		List<MemberVO> memberList = null;
		String script = "";
		try {
			MemberVO member = new MemberVO();
			memberList = memberService.getMemberList();
			if(memberList == null) {
				throw new NullException();
			}
		} catch (SQLException e) {
			script = "alert('문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		} catch (NullException e) {
			script = "alert('문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			EXCEPTION_LOGGER.error(e.getMessage());
		}
		
		request.setAttribute("memberList", memberList);
		request.setAttribute("script", script);
		request.getRequestDispatcher(viewPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("userId");
		
		List<MemberVO> memberList = null;
		try {
			MemberVO member = new MemberVO();
			member.setId(id);
			memberList = memberService.getMemberListByInfo(member);
			PrintWriter out = response.getWriter();
			if(memberList.size() > 0) {
				out.print("1");
			}else {
				out.print("0");
			}
			
			out.flush();
			out.close();
		} catch (SQLException e) {
			EXCEPTION_LOGGER.error(e.getMessage());
		} 
	}
}
