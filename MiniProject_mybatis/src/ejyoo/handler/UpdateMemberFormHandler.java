package ejyoo.handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ejyoo.dto.MemberVO;
import ejyoo.exception.NotEnoughDataException;
import ejyoo.exception.NullException;
import ejyoo.service.MemberService;

public class UpdateMemberFormHandler implements Handler {
	private static final Logger EXCEPTION_LOGGER = Logger.getLogger(DeleteMemberHandler.class);
	private MemberService memberService;
	public void setMenuService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url 		= "member/updateMember";
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String script 	= "";
		MemberVO member = null;
		String id 		= request.getParameter("id");
		
		try {
			if(id == "" || id == null) {
				throw new NotEnoughDataException();
			}
			
			member = memberService.getMemberById(id);
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
		
		
		
		
		return url;
	}
}