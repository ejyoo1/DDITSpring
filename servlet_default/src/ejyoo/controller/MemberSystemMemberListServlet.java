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

import ejyoo.dao.IMemberSystemDao;
import ejyoo.dao.MemberSystemDaoImpl;
import ejyoo.service.IMemberSystemService;
import ejyoo.service.MemberSystemServiceImpl;
import ejyoo.util.EncoderDecoder;
import ejyoo.vo.MemberDTO;

@WebServlet("/memberList")
public class MemberSystemMemberListServlet extends HttpServlet {
	private static final Logger EXCEPTION_LOGGER = Logger.getLogger(MemberSystemMemberListServlet.class);
	IMemberSystemService mmssi = MemberSystemServiceImpl.getInstance();
	IMemberSystemDao mmsdi = MemberSystemDaoImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MemberDTO memberDto = new MemberDTO();
		List<MemberDTO> memberList = null;
		String script = "";
		
		try {
			memberList = mmssi.getMemberList(memberDto);
			
		} catch (SQLException e) {
			script = "alert('문제가 발생하였습니다. 관리자에게 문의하여 주세요.');"
					+ "history.go(-1);";
			
			EXCEPTION_LOGGER.error(e.getMessage());
			request.setAttribute("script", script);
		}
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/memberList.jsp");
		request.setAttribute("memberList", memberList);
		
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
