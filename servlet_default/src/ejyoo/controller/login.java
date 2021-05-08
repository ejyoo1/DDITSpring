package ejyoo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.vo.MemberVO;

import ejyoo.service.IMemberService;
import ejyoo.service.MemberServiceImpl;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>로그인 화면</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>로그인 화면</h1>");
		out.println("<form id='fm' method='post' action='login'>");
		out.println("아이디 : <input type='text' id='userId' name='userId'><br>");
		out.println("비밀번호 : <input type='text' id='userId' name='userPw'><br>");
		out.println("<input type='submit' value='전송'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		IMemberService memService = MemberServiceImpl.getInstance();
		
		String userId = (String) request.getParameter("userId");
		String userPw = (String) request.getParameter("userPw");
		String message = "";
		
		MemberVO mv = new MemberVO();
		mv.setUserId(userId);
		mv.setUserPw(userPw);
		
		boolean chk = memService.memberSearchId(mv);
		if(chk) {
			chk = memService.memberSearchPw(mv);
			if(chk) {
				mv = memService.memberSearch(mv);
			} else {
				message = "잘못된 비밀번호 입니다.";
			}
		} else {
			message = "아이디가 잘못되었습니다.";
		}
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>로그인 화면</title>");
		out.println("</head>");
		out.println("<body>");
		if("".equals(message)) {
			out.print("<script>");
			out.print("alert('로그인 성공')");
			out.print("</script>");
			out.print("<h1>" + mv.getUserId() + "님 환영합니다 !!!</h1>");
			out.println("<form id='fm' method='get' action='login'>");
			out.println("<button type='button' onclick='logout()'>로그아웃</button>");
			out.println("<script>");
			out.println("function logout(){");
			out.println("alert('로그아웃 합니다.')");
			out.println("var fm = document.getElementById('fm');");
			out.println("fm.method = 'get';");
			out.println("fm.action = 'login';");
			out.println("fm.submit();");
			out.println("}");
			out.println("</script>");
			out.println("</form>");
		} else {
			out.print("<script>");
			out.print("alert('" + message + "');");
			out.print("location.href='login';");
			out.print("</script>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
