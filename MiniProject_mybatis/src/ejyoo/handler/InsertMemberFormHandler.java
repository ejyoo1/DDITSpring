package ejyoo.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertMemberFormHandler implements Handler {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url 		= "member/insertMemberForm";
		
		return url;
	}
}
