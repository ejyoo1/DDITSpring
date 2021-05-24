package kr.or.ddit.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.context.ApplicationContext;
import kr.or.ddit.dto.MenuVO;
import kr.or.ddit.service.MenuService;

@WebServlet("/index.htm")
public class MainMenuServlet extends HttpServlet {
	
	private MenuService menuService
		= (MenuService)ApplicationContext.getApplicationContext().get("menuService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/common/indexPage.jsp";
		
		String mCode = request.getParameter("mCode");
		
		if(mCode == null) mCode = "M000000";
		
		try {
			List<MenuVO> menuList = menuService.getMainMenuList();
			MenuVO menu = menuService.getMenuByMcode(mCode);
			
			request.setAttribute("menuList", menuList);
			request.setAttribute("menu", menu);
		} catch (SQLException e) {
			e.printStackTrace();
			url = null;
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
