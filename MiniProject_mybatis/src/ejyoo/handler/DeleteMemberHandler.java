package ejyoo.handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ejyoo.exception.NotEnoughDataException;
import ejyoo.exception.NotEnoughResultException;
import ejyoo.service.MemberService;

public class DeleteMemberHandler implements Handler {
	private static final Logger EXCEPTION_LOGGER = Logger.getLogger(DeleteMemberHandler.class);
	private MemberService memberService;
	public void setMenuService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url 		= "result";
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String script 	= "";
		String id 		= request.getParameter("id");
		
		try {
			if(id == "" || id == null) {
				throw new NotEnoughDataException();
			}
		
			int cnt = memberService.deleteMemberById(id);
			if(cnt > 0) {
				script = "alert('회원이 삭제되었습니다.');"
						+ "location.href='/member/list.do';";
			} else if (cnt == 0) {
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
		return url;
	}
}
